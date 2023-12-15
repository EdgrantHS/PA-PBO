package GUI.SubGUIModel;

import javax.swing.*;
import java.awt.*;
/**
 * A base class for all pages in the library management system.
 *
 * @author Edgrant
 * @version 1.0
 * @since 2023-03-08
 */
public class BasePage {

    /**
     * The frame that contains the page.
     */
    private final JFrame frame;

    /**
     * The panel that contains the columns of the page.
     */
    private final JPanel columns;

    /**
     * Constructs a new page with the given name.
     *
     * @param pageName The name of the page.
     */
    public BasePage(String pageName) {
        this.frame = new JFrame(pageName);
        NavigationBar navigationBar = new NavigationBar(this.frame);
        this.frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

        this.columns = new JPanel();
        this.columns.setLayout(new BoxLayout(this.columns, BoxLayout.Y_AXIS));

        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    /**
     * Constructs a new page with the given name and no menu.
     *
     * @param pageName The name of the page.
     */
    public BasePage(String pageName, String forOverloading) {
        if (forOverloading == null) {
            throw new IllegalArgumentException("forOverloading cannot be null");
        }

        this.frame = new JFrame(pageName);

        this.columns = new JPanel();
        this.columns.setLayout(new BoxLayout(this.columns, BoxLayout.Y_AXIS));

        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    /**
     * Adds a row to the page.
     *
     * @param row The row to add.
     */
    public void add(JPanel row) {
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, row.getPreferredSize().height));
        this.columns.add(row);
    }

    /**
     * Adds a button to the page.
     *
     * @param button The button to add.
     */
    public void add(JButton button) {
        this.columns.add(button);
    }

    /**
     * Renders the page.
     */
    public void render() {
        this.frame.add(this.columns);
    }

    /**
     * Gets the frame of the page.
     *
     * @return The frame of the page.
     */
    public JFrame getFrame() {
        return this.frame;
    }
}