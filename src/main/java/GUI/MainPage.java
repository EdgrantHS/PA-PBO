package GUI;

import GUI.SubGUIModel.RefreshButton;
import Model.Book;
import GUI.SubGUIModel.NavigationBar;
import ProgramLogic.BookController;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainPage implements Displayable {

    // Assume these are somehow populated with data from your data source

    /*-----------------------------------------------Variables--------------------------------------------------------*/
    public static List<Book> books = new ArrayList<>(); // This should be populated with your books data
    private int itemsPerPage = 10;
    private int currentPage = 1;


    // UI Components
    private JLabel pageLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JPanel booksPanel;
    private JFrame frame;

    /*----------------------------------------------------------------------------------------------------------------*/
    @Override
    public void display() {
        books = BookController.getListBook();

        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Main Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            NavigationBar navigationBar = new NavigationBar(frame);
            frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

            // Main content panel
            booksPanel = new JPanel();
            booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
            frame.getContentPane().add(new JScrollPane(booksPanel), BorderLayout.CENTER);

            // Refresh button
            RefreshButton refreshButton = new RefreshButton(frame, RentedBooksPage.class);
            JPanel refreshButtonPanel = refreshButton.create();
            frame.getContentPane().add(refreshButtonPanel, BorderLayout.EAST);

            // Pagination controls
            JPanel paginationPanel = new JPanel();
            prevButton = new JButton("< Previous");
            nextButton = new JButton("Next >");
            pageLabel = new JLabel();

            prevButton.addActionListener(e -> changePage(-1));
            nextButton.addActionListener(e -> changePage(1));

            paginationPanel.add(prevButton);
            paginationPanel.add(pageLabel);
            paginationPanel.add(nextButton);
            frame.getContentPane().add(paginationPanel, BorderLayout.SOUTH);

            // Initial book load
            loadBooks();

            frame.setVisible(true);
        });
    }

    private void loadBooks() {
        booksPanel.removeAll();

        int start = (currentPage - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, books.size());

        for (int i = start; i < end; i++) {
            Book book = books.get(i);
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel bookLabel = new JLabel(book.title + " by " + book.author);
            JButton detailButton = new JButton("Details");
            detailButton.addActionListener(e -> bookDetail(book.id));

            bookPanel.add(bookLabel);
            bookPanel.add(detailButton);
            booksPanel.add(bookPanel);
        }

        pageLabel.setText("Page " + currentPage + " of " + ((books.size() - 1) / itemsPerPage + 1));
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(end < books.size());

        booksPanel.revalidate();
        booksPanel.repaint();
    }


    private void changePage(int delta) {
        int newPage = currentPage + delta;
        int pageCount = books.size() / itemsPerPage + 1;

        if (newPage > 0 && newPage <= pageCount) {
            currentPage = newPage;
            loadBooks();
        }
    }


    private void bookDetail(int bookId) {
        Displayable.movePage(frame, new RentBookPage());
    }
}

