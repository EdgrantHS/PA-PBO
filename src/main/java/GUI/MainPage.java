package GUI;

import GUI.SubGUIModel.RefreshButton;
import Model.Book;
import GUI.SubGUIModel.NavigationBar;
import ProgramLogic.BookController;
import ProgramLogic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main page of the application.
 * This page is used to display the books that are currently available.
 * This page is accessible by all users.
 * This page is accessible from the navigation bar.
 */
/**
 * Represents the main page of the application.
 * This page is used to display the books that are currently available.
 * This page is accessible by all users.
 * This page is accessible from the navigation bar.
 *
 */
public class MainPage implements Displayable {

    // Assume these are somehow populated with data from your data source

    /*-----------------------------------------------Variables--------------------------------------------------------*/
    /**
     * The list of books.
     */
    public static List<Book> books = BookController.getListBook();

    /**
     * The panel that contains the books.
     */
    private JPanel booksPanel;

    /**
     * The frame that contains the main page.
     */
    private JFrame frame;

    /**
     * The pagination controller.
     */
    private PaginationController paginationController;

    public static int clickedBookId = -1;

    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Displays the main page.
     */
    @Override
    public void display() {
        SwingUtilities.invokeLater(() -> {
            frame = new JFrame("Main Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            NavigationBar navigationBar = new NavigationBar(frame);
            frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

            booksPanel = new JPanel();
            booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
            frame.getContentPane().add(new JScrollPane(booksPanel), BorderLayout.CENTER);

            RefreshButton refreshButton = new RefreshButton(frame, MainPage.class);
            JPanel refreshButtonPanel = refreshButton.create();
            frame.getContentPane().add(refreshButtonPanel, BorderLayout.EAST);

            JPanel paginationPanel = new JPanel();
            JButton prevButton = new JButton("< Previous");
            JButton nextButton = new JButton("Next >");
            JLabel pageLabel = new JLabel();

            paginationController = new PaginationController(10) {
                @Override
                protected void onPageChange() {
                    loadBooks();
                }
            };
            paginationController.setTotalItems(books.size());
            paginationController.setupPaginationControls(prevButton, nextButton, pageLabel);

            paginationPanel.add(prevButton);
            paginationPanel.add(pageLabel);
            paginationPanel.add(nextButton);
            frame.getContentPane().add(paginationPanel, BorderLayout.SOUTH);

            loadBooks();
            frame.setVisible(true);
        });
    }

    /**
     * Loads the books into the books panel.
     */
    private void loadBooks() {
        booksPanel.removeAll();
        int start = paginationController.getCurrentPageStartIndex();
        int end = Math.min(start + paginationController.getItemsPerPage(), books.size());

        for (int i = start; i < end; i++) {
            Book book = books.get(i);
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel bookLabel = new JLabel(book.title + " by " + book.author);
            JButton detailButton = new JButton("Details");
            detailButton.addActionListener(e -> {
                bookDetail(book.id);
                clickedBookId = book.id;
            });

            bookPanel.add(bookLabel);
            bookPanel.add(detailButton);
            booksPanel.add(bookPanel);
        }

        booksPanel.revalidate();
        booksPanel.repaint();
    }

    /**
     * Displays the book details page.
     *
     * @param bookId The id of the book to display.
     */
    private void bookDetail(int bookId) {
        clickedBookId = bookId;
        System.out.println(clickedBookId);
        Displayable.movePage(frame, new RentBookPage());
    }
}
