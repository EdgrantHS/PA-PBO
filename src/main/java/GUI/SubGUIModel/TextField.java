package GUI.SubGUIModel;

import javax.swing.*;
import java.awt.*;

/**
 * A text field that allows users to input text.
 *
 * @author Edgrant
 */
public class TextField {

    /**
     * The hint text that appears in the text field when it is empty.
     */
    private final String hintText;

    /**
     * The text that the user has input into the text field.
     */
    private String inputText;

    /**
     * The text field itself.
     */
    private JTextField inputTextF;

    /**
     * Creates a new text field with the given hint text.
     *
     * @param hintText The hint text that appears in the text field when it is empty.
     */
    public TextField(String hintText) {
        this.hintText = hintText;
    }

    /**
     * Gets the text that the user has input into the text field.
     *
     * @return The text that the user has input into the text field.
     */
    public String getInputText() {
        return inputText;
    }

    /**
     * Creates a JPanel that contains the text field and its hint text.
     *
     * @return A JPanel that contains the text field and its hint text.
     */
    public JPanel create() {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        JLabel hintTextL = new JLabel(this.hintText);
        row.add(hintTextL);

        inputTextF = new JTextField();
        inputTextF.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputTextF.getPreferredSize().height));
        row.add(inputTextF);

        return row;
    }

    /**
     * Gets the text that the user has input into the text field.
     *
     * @return The text that the user has input into the text field.
     */
    public String getText() {
        return inputTextF.getText();
    }
}