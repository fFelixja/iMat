import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import se.chalmers.ait.dat215.project.ShoppingCart;

import java.io.IOException;

public class ShoppingCartViewController extends AnchorPane{

    @FXML private Label amountItemsLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button continueShoppingButton;

    @FXML private Button checkoutButton;

    @FXML private GridPane productGridPane;

    private TopMenuController controller;

    public ShoppingCartViewController(TopMenuController controller) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ShoppingCartView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ShoppingCartViewController");
        }

        this.controller = controller;
    }

    public void populateProductGridPane(ShoppingCart shoppingCart) {
        clearProductGridPane();
        for (int i = 0; i < shoppingCart.getItems().size(); i++) {
            ShoppingCartItemController shoppingItem = new ShoppingCartItemController(shoppingCart.getItems().get(i), this);
            productGridPane.add(shoppingItem, i % 3, i / 3);
        }

        amountItemsLabel.setText("Totalt antal varor: " + Integer.toString(shoppingCart.getItems().size()));
        totalPriceLabel.setText("Totalt pris: " + Double.toString(shoppingCart.getTotal()));
    }

    private void clearProductGridPane() {
        productGridPane.getChildren().removeAll(productGridPane.getChildren());
    }

    @FXML
    protected void continueShoppingButtonActionPerformed(ActionEvent event) {
        controller.categoryViewToFront();
    }

    @FXML
    protected void checkoutButtonButtonActionPerformed(ActionEvent event) {
        controller.checkoutViewToFront();
    }
}
