import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Order;

import java.io.IOException;

public class PastPurchasePanelController extends AnchorPane {

    @FXML private Label datePurchasedLabel;

    @FXML private Label amountLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button viewDetailsButton;

    private TopMenuController controller;

    private Order order;

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
        amountLabel.setText(order.getItems().size() + "st");
        totalPriceLabel.setText(DataHandler.getOrderTotal(order) + "kr");
        this.controller = controller;
        this.order = order;

    }

    @FXML
    protected void viewDetailsButtonActionPerformed (ActionEvent event){
        controller.pastPurchaseDetailViewToFront(order);

    }



}
