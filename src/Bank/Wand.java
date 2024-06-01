/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bank;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Utility class for setting custom icon and cursor.
 */
public class Wand {
    
    /**
     * Sets a custom icon for the specified JFrame.
     * @param frame The JFrame to set the custom icon for.
     */
    public static void setCustomIcon(JFrame frame) {
        // Load the icon image
        Image iconImage = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/Images/wand.png"));
        // Set the custom icon for the frame
        if (iconImage != null) {
            frame.setIconImage(iconImage);
        } else {
            System.err.println("Icon image not found");
        }
    }
    
    /**
     * Sets a custom cursor for the specified JFrame.
     * @param frame The JFrame to set the custom cursor for.
     */
    public static void setCustomCursor(JFrame frame) {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Load the cursor image
        Image cursorImage = toolkit.getImage(frame.getClass().getResource("/Images/wand.png"));
        // Set the custom cursor for the frame
        if (cursorImage != null) {
            Point hotSpot = new Point(0, 0); // Set the hot spot to the top-left corner of the image
            Cursor customCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "Custom Cursor");
            frame.setCursor(customCursor);
        } else {
            System.err.println("Cursor image not found");
        }
    }
}

