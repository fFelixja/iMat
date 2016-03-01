import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

public class ShoppingCartItemController extends AnchorPane {

    @FXML private Label nameLabel;

    @FXML private Label amountLabel;

    @FXML private Label pricePerUnitLabel;

    @FXML private Label totalPriceLabel;

    @FXML private Button increaseAmountButton;

    @FXML private Button decreaseAmountButton;

    @FXML private ImageView productImageView;

    private ShoppingItem shoppingItem;

    public ShoppingCartItemController(ShoppingItem shoppingItem) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ShoppingCartItem.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ShoppingCartItemController");
        }

        this.shoppingItem = shoppingItem;

        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(Double.toString(shoppingItem.getAmount()));
        pricePerUnitLabel.setText(shoppingItem.getProduct().getUnit());
        totalPriceLabel.setText(Double.toString(shoppingItem.getTotal()));
        productImageView.setImage(DataHandler.getProductImage(shoppingItem.getProduct()));
    }
}
