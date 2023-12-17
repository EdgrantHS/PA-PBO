package GUI.SubGUIModel;

import javax.swing.*;
import GUI.Displayable;
import static GUI.Displayable.*;


/**
 * A button that allows users to refresh the current page.
 *
 * @author Edgrant
 */
public class RefreshButton {

    private JButton refreshButton;
    private JFrame currentFrame; // Field to store the reference to the current frame
    private Class<? extends Displayable> currentPageClass; // This will be the class of the new page to display

    /**
     * Constructor for RefreshButton.
     *
     * @param currentFrame The current JFrame.
     * @param currentPageClass The class of the new page to display when the button is pressed.
     */
    public RefreshButton(JFrame currentFrame, Class<? extends Displayable> currentPageClass) {
        this.currentFrame = currentFrame;
        this.currentPageClass = currentPageClass;
    }

    /**
     * Creates a JPanel with a refresh button.
     *
     * @return The JPanel with the refresh button.
     */
    public JPanel create() {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        refreshButton = new JButton("Refresh");

        // Add an action listener to the refresh button
        refreshButton.addActionListener(e -> {
            try {
                Displayable newPage = currentPageClass.getDeclaredConstructor().newInstance();
                movePage(currentFrame, newPage);
            } catch (Exception ex) {
                ex.printStackTrace(); // Handle the exception appropriately
            }
        });

        row.add(refreshButton);
        return row;
    }
}
