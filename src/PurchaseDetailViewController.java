
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PurchaseDetailViewController extends AnchorPane{
    @FXML private Label dateBoughtLabel;

    @FXML private Label nbrOfProductsLabel;

    @FXML private Label priceLabel;

    public PurchaseDetailViewController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PurchaseDetailView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }

    }

}
