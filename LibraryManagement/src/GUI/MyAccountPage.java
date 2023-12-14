package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.Row;

import javax.swing.*;

public class MyAccountPage implements Displayable{
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text
    public String nameText = "Edgrant Henderson Suryajaya";
    public String emailText = "edgrant@netlab.com";
    public String ratingText = "0";

    /*----------------------------------------------------------------------------------------------------------------*/

    @Override
    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Account Page");


            /*--------------------------------------------------------------------------------------------------------*/
            // Component setup
            Row nameRow = new Row("Name: ", nameText);
            basePage.add(nameRow.create());

            Row emailRow = new Row("Email: ", emailText);
            basePage.add(emailRow.create());

            Row ratingRow = new Row("Rating: ", ratingText);
            basePage.add(ratingRow.create());


            basePage.render();
        });
    }
}
