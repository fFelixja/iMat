import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;

public class HistoryProductItemController extends AnchorPane {

    @FXML private Label nameLabel;

    @FXML private Label amountLabel;

    @FXML private Label pricePerUnitLabel;

    @FXML private Label totalPriceLabel;

    @FXML private ImageView productImageView;

    private ShoppingItem shoppingItem;

    public HistoryProductItemController(ShoppingItem shoppingItem){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/HistoryProductItem.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of HistoryProductItemController");
        }

        this.shoppingItem = shoppingItem;

        setValues();

    }

    private void setValues(){
        nameLabel.setText(shoppingItem.getProduct().getName());
        amountLabel.setText(shoppingItem.getAmount() + shoppingItem.getProduct().getUnitSuffix());
        pricePerUnitLabel.setText(shoppingItem.getProduct().getPrice() +
                shoppingItem.getProduct().getUnit());
        totalPriceLabel.setText(shoppingItem.getTotal() + " kr");
        productImageView.setImage(DataHandler.getProductImage(shoppingItem.getProduct()));

    }


}
