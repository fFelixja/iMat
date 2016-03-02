import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

public class ShoppingCartViewController extends AnchorPane{

    @FXML private Label amountUnitLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button continueShoppingButton;

    @FXML private Button checkoutButton;

    @FXML private GridPane productGridPane;

    private TopMenuController topMenu;

    public ShoppingCartViewController(TopMenuController topMenu) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ShoppingCartView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ShoppingCartViewController");
        }

        this.topMenu = topMenu;
    }

    public void populateProductGridPane(ShoppingCart shoppingCart) {
        clearProductGridPane();
        for (int i = 0; i < shoppingCart.getItems().size(); i++) {
            ShoppingCartItemController shoppingItem = new ShoppingCartItemController(shoppingCart.getItems().get(i), this);
            productGridPane.add(shoppingItem, i % 2, i / 2);
        }
    }

    private void clearProductGridPane() {
        productGridPane.getChildren().removeAll(productGridPane.getChildren());
    }

    @FXML
    protected void continueShoppingButtonActionPerformed(ActionEvent event) {
        topMenu.categoryViewToFront();
    }
}
