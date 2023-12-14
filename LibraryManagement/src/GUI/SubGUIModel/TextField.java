package GUI.SubGUIModel;

import javax.swing.*;
import java.awt.*;

public class TextField {
    private final String hintText;
    private String inputText;
    private JTextField inputTextF;

    public TextField(String hintText){
        this.hintText = hintText;
    }

    public String getInputText() {
        return inputText;
    }

    public JPanel create(){
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        JLabel hintTextL = new JLabel(this.hintText);
        row.add(hintTextL);

        inputTextF = new JTextField();
        inputTextF.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputTextF.getPreferredSize().height));
        row.add(inputTextF);

        return row;
    }

    public String getText(){
        return inputTextF.getText();
    }
}