import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Order;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class PastPurchasePanelController extends AnchorPane {

    @FXML private Label datePurchasedLabel;

    @FXML private Label nbrOfProductsLabel;

    @FXML private Label priceLabel;

    @FXML private Button viewDetailsButton;

    private TopMenuController topController;

    public PastPurchasePanelController (Order order, TopMenuController controller) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PastPurchasePanel.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Fel i PastPurchasePanelController");
        }


        datePurchasedLabel.setText(order.getDate().toString());
        nbrOfProductsLabel.setText(order.getItems().size() + "st");
      priceLabel.setText(DataHandler.getOrderTotal(order) + "kr");

        topController = controller;

    }

    protected void viewDetailsButtonActionPerformed (ActionEvent event){
       // topController.pastPurchaseDetailViewToFront(Order order);
        System.out.println("hej");
    }

}
