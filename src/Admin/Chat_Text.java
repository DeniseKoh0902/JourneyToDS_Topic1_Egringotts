
package Admin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextPane;

/**
 * Custom JTextPane for chat messages.
 * This class overrides the paintComponent method to draw a rounded rectangle border
 * with specified background and border colors.
 */
public class Chat_Text extends JTextPane {

    // Border color of the chat text
    private Color borderColor = Color.BLUE;
    
    // Background color of the chat text
    private Color bgColor = Color.GREEN;
    
    /**
     * Get the border color of the chat text.
     *
     * @return The border color.
     */
    public Color getBorderColor() {
        return borderColor;
    }

    /**
     * Set the border color of the chat text.
     *
     * @param borderColor The border color to set.
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    /**
     * Get the background color of the chat text.
     *
     * @return The background color.
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * Set the background color of the chat text.
     *
     * @param bgColor The background color to set.
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * Constructor for Chat_Text class.
     * Sets the background color to transparent.
     */
    public Chat_Text() {
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * Overrides the paintComponent method to draw a rounded rectangle border
     * with specified background and border colors.
     *
     * @param grphcs The Graphics context.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 5, 5);
        super.paintComponent(grphcs);
    }
}
