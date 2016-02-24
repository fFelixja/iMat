import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PastPurchasePanelController extends AnchorPane {

    @FXML private Label datePurchasedtLabel;

    @FXML private Label nbrOfProductsLabel;

    @FXML private Label priceLabel;

    @FXML private Button viewDetailsButton;

    public PastPurchasePanelController () {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PastPurchasePanel.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }

    }

}
