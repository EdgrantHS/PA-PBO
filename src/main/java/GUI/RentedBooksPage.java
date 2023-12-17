package GUI;

import GUI.SubGUIModel.NavigationBar;
import GUI.SubGUIModel.RefreshButton;
import Model.Borrow;
import ProgramLogic.BorrowController;
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RentedBooksPage implements Displayable {

    private List<Borrow> borrows = new ArrayList<>();
    private int itemsPerPage = 10;
    private int currentPage = 1;

    // UI Components
    private JLabel pageLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JButton displayButton; // New display button
    private JPanel borrowsPanel;
    private JFrame frame;

    @Override
    public void display() {
        // Temporary data
        borrows.add(new Borrow(1, 1, new Timestamp(System.currentTimeMillis())));
        borrows.add(new Borrow(1, 2, new Timestamp(System.currentTimeMillis())));
        borrows.add(new Borrow(1, 3, new Timestamp(System.currentTimeMillis())));
        borrows.add(new Borrow(1, 4, new Timestamp(System.currentTimeMillis())));
        borrows.add(new Borrow(1, 5, new Timestamp(System.currentTimeMillis())));
        borrows.add(new Borrow(1, 6, new Timestamp(System.currentTimeMillis())));

        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Rented Books Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Navigation bar
            NavigationBar navigationBar = new NavigationBar(frame);
            frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

            // Content panel for borrowed books
            borrowsPanel = new JPanel();
            borrowsPanel.setLayout(new BoxLayout(borrowsPanel, BoxLayout.Y_AXIS));
            frame.getContentPane().add(new JScrollPane(borrowsPanel), BorderLayout.CENTER);

            // Refresh button
            RefreshButton refreshButton = new RefreshButton(frame, RentedBooksPage.class);
            JPanel refreshButtonPanel = refreshButton.create();
            frame.getContentPane().add(refreshButtonPanel, BorderLayout.EAST);

            // Pagination controls
            JPanel paginationPanel = new JPanel();
            prevButton = new JButton("< Previous");
            nextButton = new JButton("Next >");
            pageLabel = new JLabel();

            // Initialize the display button
            displayButton = new JButton("Display");
            displayButton.addActionListener(e -> loadBorrows());

            prevButton.addActionListener(e -> changePage(-1));
            nextButton.addActionListener(e -> changePage(1));

            paginationPanel.add(prevButton);
            paginationPanel.add(pageLabel);
            paginationPanel.add(nextButton);
            paginationPanel.add(displayButton);
            frame.getContentPane().add(paginationPanel, BorderLayout.SOUTH);

            loadBorrows(); // Call this after initializing all components

            frame.setVisible(true);
        });

    }
    private void loadBorrows() {
        borrowsPanel.removeAll();

        int start = (currentPage - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, borrows.size());

        for (int i = start; i < end; i++) {
            Borrow borrow = borrows.get(i);
            JPanel borrowPanel = new JPanel();
            borrowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel borrowLabel = new JLabel("Account ID: " + borrow.accountId + ", Book ID: " + borrow.bookId);
            // Additional details can be added here

            borrowPanel.add(borrowLabel);
            borrowsPanel.add(borrowPanel);
        }

        pageLabel.setText("Page " + currentPage + " of " + ((borrows.size() - 1) / itemsPerPage + 1));
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(end < borrows.size());

        borrowsPanel.revalidate();
        borrowsPanel.repaint();
    }

    private void changePage(int delta) {
        int newPage = currentPage + delta;
        int pageCount = borrows.size() / itemsPerPage + 1;

        if (newPage > 0 && newPage <= pageCount) {
            currentPage = newPage;
            loadBorrows();
        }
    }
}