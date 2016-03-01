import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ShoppingCartViewController extends AnchorPane{

    @FXML private Label amountUnitLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button continueShoppingButton;

    @FXML private Button checkoutButton;

    @FXML private GridPane productGridPane;

    public ShoppingCartViewController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ShoppingCartView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ShoppingCartViewController");
        }
    }
}
