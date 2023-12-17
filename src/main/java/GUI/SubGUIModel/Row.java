package GUI.SubGUIModel;

import javax.swing.*;


/**
 * A model for a single row in a table.
 *
 * @author Edgrant
 */
public class Row {

    /**
     * The text value of the row.
     */
    private final String text;

    /**
     * The value value of the row.
     */
    private final String value;

    /**
     * Constructs a new row with the given text and value.
     *
     * @param text  The text value of the row.
     * @param value The value value of the row.
     */
    public Row(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * Gets the text value of the row.
     *
     * @return The text value of the row.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the value value of the row.
     *
     * @return The value value of the row.
     */
    public String getValue() {
        return value;
    }

    /**
     * Creates a JPanel that represents the row.
     *
     * @return A JPanel that represents the row.
     */
    public JPanel create() {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        JLabel nameText = new JLabel(this.text);
        row.add(nameText);
        JLabel nameVal = new JLabel(getValue());
        row.add(nameVal);

        return row;
    }
}