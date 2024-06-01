/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;

/**
 * ARepresents a custom panel with mouse animation effect
 */
public class PanelMouseEffect extends JComponent {

    // Array of colors for the mouse effect
    public final static Color[] colors = new Color[]{Color.decode("#FFC312"), Color.decode("#C4E538"), Color.decode("#12CBC4"), Color.decode("#FDA7DF"), Color.decode("#ED4C67"), Color.decode("#009432"), Color.decode("#0652DD"), Color.decode("#9980FA"), Color.decode("#006266")};
    private List<Effect> effectes; // List to hold the mouse effects
    private Thread thread; // Thread to manage the animation
    private final int SHAPE_SIZE = 10; // Size of the shape
    private Shape shape; // Shape of the effect

    //Constructs a PanelMouseEffect with default background color.
    public PanelMouseEffect() {
        setOpaque(true);
        setBackground(new Color(193, 193, 193)); // Set default background color
    }

    //Registers mouse effect on this panel.
    public void registerMouseEffect() {
        initSubComponent(PanelMouseEffect.this); // Initialize sub-components for mouse effect
        shape = createShape(); // Create shape for mouse effect
    }

    // Create the shape for the mouse effect
    private Shape createShape() {
        Path2D p = new Path2D.Double(); // Create a new Path2D object
        float size = SHAPE_SIZE; // Define the size of the shape
        // Define the shape by specifying its vertices
        p.moveTo(0, 0.35 * size);
        p.lineTo(1 * size, 0.35 * size);
        p.lineTo(0.1 * size, 1 * size);
        p.lineTo(0.5 * size, 0);
        p.lineTo(0.9 * size, 1 * size);
        return p; // Return the created shape
    }

    /**
     * Initializes sub-components for the mouse effect.
     * Recursively initializes sub-components of the specified component.
     * 
     * @param com The root component to initialize.
     */
    private void initSubComponent(JComponent com) {
        init(com); // Initialize the root component
        // Iterate through each child component
        for (Component c : com.getComponents()) {
            // If the child component is a JComponent, initialize its sub-components recursively
            if (c instanceof JComponent) {
                initSubComponent((JComponent) c);
            }
        }
    }

    /**
     * Initializes mouse events for the specified component.
     * 
     * @param com The component for which mouse events are initialized.
     */
    private void init(JComponent com) {
       effectes = new ArrayList<>(); // Initialize the list of effects
        // Create a new MouseAdapter to handle mouse events
        MouseAdapter mouseEvent = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                addEffect(e.getLocationOnScreen()); // Add effect on mouse movement
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                addEffect(e.getLocationOnScreen()); // Add effect on mouse drag
            }
        };
        com.addMouseMotionListener(mouseEvent);
    }

    /**
     * Adds a new mouse effect at the specified point.
     * 
     * @param point The point at which the effect is added.
     */
    public void addEffect(Point point) {
        effectes.add(new Effect(point)); // Add a new effect to the list
        startThread(); // Start animation thread
        repaint(); // Repaint the component
    }

    /**
     * Starts the animation thread if it's not already running.
     */
    private void startThread() {
        // Check if the thread is null or not alive
        if (thread == null || !thread.isAlive()) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Continuously update and repaint effects until the list is empty
                    while (!effectes.isEmpty()) {
                        for (int i = 0; i < effectes.size(); i++) {
                            Effect effect = effectes.get(i);
                            if (effect != null) {
                                effect.update(); //Update effect
                            }
                        }
                        repaint(); // Repaint the component
                        sleep(); // Sleep for a short duration
                    }

                }
            });
            thread.start(); // Start the thread
        }
    }

    // Sleep for a short duration
    private void sleep() {
        try {
            Thread.sleep(10); // Sleep for 10 milliseconds
        } catch (InterruptedException e) {
            System.err.println(e); // Print any InterruptedException that occurs
        }
    }

    // Remove an effect from the list
    private void removeEffect(Effect effect) {
        effectes.remove(effect); // Remove the specified effect
        if (effectes.isEmpty()) {
            repaint(); // Repaint the component if the effect list is empty
        }
    }

    /**
     * Overrides the default paintComponent method to customize the painting
     * behavior. This method fills the background of the panel with the
     * specified background color before painting any other components.
     *
     * @param g The Graphics context used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Fill the background with the specified color if the panel is opaque
        if (isOpaque()) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight()); // Fill background with color
        }
        super.paintComponent(g); // Call the superclass method to paint other components
    }

    /**
     * Overrides the default paint method to customize the painting behavior.
     * This method renders the mouse effects on the panel using the Graphics
     * context.
     *
     * @param g The Graphics context used for painting.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call the superclass method to paint other components

        // Check if there are any effects to render
        if (effectes != null) {
            Graphics2D g2 = (Graphics2D) g.create();// Create a Graphics2D object

            // Enable anti-aliasing for smoother rendering
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Iterate through each effect and render it on the panel
            for (int i = 0; i < effectes.size(); i++) {
                Effect effect = effectes.get(i); // Get the current effect
                if (effect != null) {
                    effect.render(g2); // Render the effect using the Graphics2D object
                }
            }
            g2.dispose(); // Dispose the Graphics2D object to free up resources
        }
    }

    /**
     * Represents a visual effect displayed on the panel in response to mouse
     * movement. Each effect consists of colored shapes emanating from a
     * specific location.
     */
    private class Effect {

    // Constants defining the properties of the effect
        private final static double MAX_DISTANCE = 50; // Maximum distance the effect can travel
        private final static int SIZE = 1; // Size of the effect
        private final static float SPEED = 0.5f; // Speed at which the effect expands

    // Properties of the effect
        private final Point location; // Location from which the effect emanates
        private double distance; // Current distance traveled by the effect
        private float[] angles; // Angles at which the effect is displayed
        private Color[] colors; // Colors of the effect
        
        /**
         * Constructs a new Effect object with the specified location.
         * Initializes the effect's properties and sets its initial state.
         * 
         * @param location The starting location of the effect.
         */
        public Effect(Point location) {
            this.location = location;
            init();
        }

         /**
         * Initializes the properties of the effect.
         * Generates random angles and colors for the effect.
         */
        private void init() {
            angles = new float[SIZE]; // Initialize the array of angles
            colors = new Color[SIZE]; // Initialize the array of colors
            
            int distanceAngle = 180; // Angle range for the effect
            float initAngle = 90 - ((distanceAngle * SIZE) / 2); // Initial angle for the effect
            
            Random ran = new Random(); // Random number generator
            for (int i = 0; i < angles.length; i++) {
                // Generate a random angle within the specified range
                int angle = ran.nextInt(distanceAngle) + 1;
                // Calculate the angle for the current effect
                angles[i] = initAngle + (distanceAngle * i) + angle;
                // Select a random color from the available color palette
                colors[i] = PanelMouseEffect.colors[ran.nextInt(PanelMouseEffect.colors.length)];
            }
        }

        /**
         * Updates the state of the effect.
         * Increases the distance traveled by the effect.
         * Removes the effect if it exceeds the maximum distance.
         */
        public void update() {
            if (distance > MAX_DISTANCE) {
                removeEffect(this); // Remove the effect if it exceeds the maximum distance
            } else {
                distance += SPEED; // Increase the distance traveled by the effect
            }
        }
        
        /**
         * Renders the effect on the panel using the specified Graphics2D context.
         * Applies transformations to display the effect at the correct position and size.
         * 
         * @param g2 The Graphics2D context used for rendering.
         */
        public void render(Graphics2D g2) {
            // Calculate the transparency of the effect based on its distance
            double alpha = distance / MAX_DISTANCE;
            if (alpha > 1f) {
                alpha = 1f; // Limit the transparency to 1
            }
            // Set the composite to control transparency of the effect
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (1f - alpha)));
            
            // Iterate through each angle and render the effect at that angle
            for (int i = 0; i < angles.length; i++) {
                // Set the paint (color) for rendering the effect
                g2.setPaint(createPaint(colors[i]));
                
                // Save the current transformation
                AffineTransform tran = g2.getTransform();
                
                // Get the position of the effect at the current angle
                Point2D p = getLocationOf(angles[i]);
                
                // Translate and rotate the Graphics2D context to render the effect
                g2.translate(p.getX(), p.getY()); // Translate to the effect's position
                g2.rotate(Math.toRadians(distance * 5f), SHAPE_SIZE / 2, SHAPE_SIZE / 2); // Rotate the effect
                g2.fill(shape); // Fill the shape with the specified paint
                
                // Restore the original transformation
                g2.setTransform(tran);
            }
        }

        /**
         * Creates a paint object (gradient) for rendering the effect with the specified color.
         * 
         * @param color The color of the effect.
         * @return The Paint object representing the gradient effect.
         */
        private Paint createPaint(Color color) {
            // Define the center point and color distribution for the radial gradient
            Point2D center = new Point2D.Double(SHAPE_SIZE / 2, SHAPE_SIZE / 2);
            float[] dist = {0.0f, 0.9f}; // Distribution of colors in the gradient
            Color[] cols = {color, Color.WHITE}; // Colors used in the gradient
            
            // Create a RadialGradientPaint object with the specified parameters
            Paint p = new RadialGradientPaint(center, SHAPE_SIZE, dist, cols);
            return p; // Return the created paint object
        }

        /**
         * Calculates the position of the effect at the specified angle and distance.
         * 
         * @param angle The angle at which the effect is positioned.
         * @return The Point2D representing the position of the effect.
         */
        private Point2D getLocationOf(float angle) {
            Point p = getLocationOnScreen(); // Get the screen coordinates of the panel
            // Calculate the x and y coordinates based on the angle and distance
            double cosX = Math.cos(Math.toRadians(angle)) * distance;
            double sinY = Math.sin(Math.toRadians(angle)) * distance;
            // Calculate the position of the effect relative to the screen
            return new Point2D.Double(location.getX() + cosX - p.getX(), location.getY() + sinY - p.getY());
        }
    }
}
