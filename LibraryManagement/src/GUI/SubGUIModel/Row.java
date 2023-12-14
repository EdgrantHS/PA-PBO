package GUI.SubGUIModel;

import javax.swing.*;

public class Row{
    private final String text;
    private final String value;

    public Row(String text, String value){
        this.text = text;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

//    public void setValue(String value) {
//        this.value = value;
//    }

    public JPanel create(){
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        JLabel nameText = new JLabel(this.text);
        row.add(nameText);
        JLabel nameVal = new JLabel(getValue());
        row.add(nameVal);

        return row;
    }
}