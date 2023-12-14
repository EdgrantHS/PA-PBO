package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the main page of the application (Singleton).
 *
 * This class ensures that there's only one instance of the main page.
 *
 * @author Edgrant Henderson Suryajaya
 */
public class MainPage implements Displayable {
    @Override
    public void display() {
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame for the About Us page
            JFrame frame = new JFrame("About Us");
            NavigationBar navigationBar = new NavigationBar(frame);
            frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

            // Menu
            JPanel columns = new JPanel();
            columns.setLayout(new BoxLayout(columns, BoxLayout.Y_AXIS));

            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);


            /*--------------------------------------------------------------------------------------------------------*/



            // Add the content panel to the frame
            frame.add(columns);
        });
    }
}
