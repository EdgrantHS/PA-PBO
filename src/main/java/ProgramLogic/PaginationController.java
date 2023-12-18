package ProgramLogic;

import javax.swing.*;

public class PaginationController {
    private int itemsPerPage;
    private int currentPage;
    private int totalItems;

    private JButton prevButton;
    private JButton nextButton;
    private JLabel pageLabel;

    public PaginationController(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
        this.currentPage = 1;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setupPaginationControls(JButton prevButton, JButton nextButton, JLabel pageLabel) {
        this.prevButton = prevButton;
        this.nextButton = nextButton;
        this.pageLabel = pageLabel;

        prevButton.addActionListener(e -> changePage(-1));
        nextButton.addActionListener(e -> changePage(1));
        updatePaginationControls();
    }

    private void changePage(int delta) {
        int newPage = currentPage + delta;
        int pageCount = (totalItems + itemsPerPage - 1) / itemsPerPage;

        if (newPage > 0 && newPage <= pageCount) {
            currentPage = newPage;
            updatePaginationControls();
            onPageChange();
        }
    }

    private void updatePaginationControls() {
        pageLabel.setText("Page " + currentPage + " of " + ((totalItems + itemsPerPage - 1) / itemsPerPage));
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage * itemsPerPage < totalItems);
    }

    protected void onPageChange() {
        // Override this method in subclasses to load data for the current page
    }

    public int getCurrentPageStartIndex() {
        return (currentPage - 1) * itemsPerPage;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }
}