//package GUI;
//
//import javax.swing.*;
//
///**
// * Represents the account page of the application (Singleton).
// *
// * This class ensures that there's only one instance of the account page.
// *
// * @author Edgrant Henderson Suryajaya
// */
//public class AboutUsPage {
//    private static AboutUsPage instance;
//
//    // Private constructor to prevent external instantiation
//    private AboutUsPage() {
//        // Initialize page components here
//    }
//
//    /**
//     * Gets the single instance of the account page.
//     *
//     * @return The singleton instance of the account page.
//     */
//    public static AboutUsPage getInstance() {
//        if (instance == null) {
//            instance = new AboutUsPage();
//        }
//        return instance;
//    }
//
//    /**
//     * Creates and returns the panel for the account page.
//     *
//     * @return The JPanel representing the account page.
//     */
//    public JPanel createPage() {
//        JPanel panel = new JPanel();
//        // Add account page components here
//        return panel;
//    }
//}
