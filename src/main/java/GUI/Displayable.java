package GUI;

import javax.swing.*;

/**
 * Represents a page that can be displayed in a JFrame.
 *
 * @author Edgrant Henderson Suryajaya
 */
public interface Displayable {
    void display();

    /**
     * Moves the current page to the specified page.
     *
     * @param currentFrame The current JFrame.
     * @param obj          The Displayable object to be displayed.
     */
    static void movePage(JFrame currentFrame, Displayable obj) {
        if (currentFrame != null) {
            currentFrame.dispose(); // Close the current frame
        }
        obj.display(); // Display the new page without a reference to a current frame
    }

}
