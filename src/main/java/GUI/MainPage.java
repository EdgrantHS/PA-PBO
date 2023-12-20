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
    private PaginationController paginationController;

    public static int clickedBookId = -1;

    /*----------------------------------------------------------------------------------------------------------------*/

    @Override
    public void display() {
        books = BookController.getListBook();
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "2019" , 1));
//        BookController.generateBook();

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
            detailButton.addActionListener(e -> bookDetail(book.id));

            bookPanel.add(bookLabel);
            bookPanel.add(detailButton);
            booksPanel.add(bookPanel);
        }

        booksPanel.revalidate();
        booksPanel.repaint();
    }

    private void bookDetail(int bookId) {
        clickedBookId = bookId;
        System.out.println(clickedBookId);
        Displayable.movePage(frame, new RentBookPage());
    }
}
