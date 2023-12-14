package GUI;

import javax.swing.*;

public interface Displayable {
    void display();

    static void movePage(JFrame currentFrame, Displayable obj) {
        if (currentFrame != null) {
            currentFrame.dispose(); // Close the current frame
        }
        obj.display(); // Display the new page without a reference to a current frame
    }
}
