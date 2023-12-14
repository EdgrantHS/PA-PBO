package GUI.SubGUIModel;

import javax.swing.*;
import java.awt.*;

public class BasePage {
    private JFrame frame = null;
    private JPanel columns = null;
    public BasePage(String pageName){
        this.frame = new JFrame(pageName);
        NavigationBar navigationBar = new NavigationBar(this.frame);
        this.frame.getContentPane().add(navigationBar, BorderLayout.NORTH);

        this.columns = new JPanel();
        this.columns.setLayout(new BoxLayout(this.columns, BoxLayout.Y_AXIS));

        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    //no menu
    public BasePage(String pageName, String forOverloading){
        this.frame = new JFrame(pageName);

        this.columns = new JPanel();
        this.columns.setLayout(new BoxLayout(this.columns, BoxLayout.Y_AXIS));

        this.frame.setSize(600, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
    public void add(JPanel row){
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, row.getPreferredSize().height));
        this.columns.add(row);
    }

    public void add(JButton button){
        this.columns.add(button);
    }
    public void render(){
        this.frame.add(this.columns);
    }
    public JFrame getFrame(){
        return this.frame;
    }
}
