package GUI;

import GUI.SubGUIModel.NavigationBar;
import GUI.SubGUIModel.RefreshButton;
import Model.Borrow;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import ProgramLogic.*;

/**
 * Represents the rented books page of the application.
 */
public class RentedBooksPage implements Displayable {
    /**
     * The list of borrows.
     */
    private final List<Borrow> borrows = BorrowController.handleGetBorrowedBook(AccountController.loggedInAccount.id);

    /**
     * The pagination controller.
     */
    private PaginationController paginationController;

    /**
     * The panel that contains the borrows.
     */
    private JPanel borrowsPanel;

    /**
     * The frame that contains the rented books page.
     */
    private JFrame frame;


    /**
     * Displays the rented books page.
     */
    @Override
    public void display() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Rented Books Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            NavigationBar navigationBar = new NavigationBar(frame);
            frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

            borrowsPanel = new JPanel();
            borrowsPanel.setLayout(new BoxLayout(borrowsPanel, BoxLayout.Y_AXIS));
            frame.getContentPane().add(new JScrollPane(borrowsPanel), BorderLayout.CENTER);

            RefreshButton refreshButton = new RefreshButton(frame, RentedBooksPage.class);
            JPanel refreshButtonPanel = refreshButton.create();
            frame.getContentPane().add(refreshButtonPanel, BorderLayout.EAST);

            JPanel paginationPanel = new JPanel();
            JButton prevButton = new JButton("< Previous");
            JButton nextButton = new JButton("Next >");
            JLabel pageLabel = new JLabel();

            paginationController = new PaginationController(10) {
                @Override
                protected void onPageChange() {
                    loadBorrows();
                }
            };
            paginationController.setTotalItems(borrows.size());
            paginationController.setupPaginationControls(prevButton, nextButton, pageLabel);

            paginationPanel.add(prevButton);
            paginationPanel.add(pageLabel);
            paginationPanel.add(nextButton);
            frame.getContentPane().add(paginationPanel, BorderLayout.SOUTH);

            loadBorrows();
            frame.setVisible(true);
        });
    }

    /**
     * Loads the borrows.
     */
    private void loadBorrows() {
        borrowsPanel.removeAll();
        int start = paginationController.getCurrentPageStartIndex();
        int end = Math.min(start + paginationController.getItemsPerPage(), borrows.size());

        for (int i = start; i < end; i++) {
            Borrow borrow = borrows.get(i);
            JPanel borrowPanel = new JPanel();
            borrowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel borrowLabel = new JLabel("Account ID: " + borrow.accountId + ", Book ID: " + borrow.bookId);

            borrowPanel.add(borrowLabel);
            borrowsPanel.add(borrowPanel);
        }

        borrowsPanel.revalidate();
        borrowsPanel.repaint();
    }
}
