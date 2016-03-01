import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ShoppingCartItemController extends AnchorPane {

    @FXML private Label nameLabel;

    @FXML private Label amountLabel;

    @FXML private Label pricePerUnitLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button increaseAmountButton;

    @FXML private Button decreaseAmountButton;

    @FXML private ImageView productImageView;

    public ShoppingCartItemController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ShoppingCartItem.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ShoppingCartItemController");
        }
    }
}
