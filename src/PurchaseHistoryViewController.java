import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PurchaseHistoryViewController extends AnchorPane {
    @FXML private VBox purchaseBox;

    public PurchaseHistoryViewController () {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PurchaseHistoryView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }

    }

}
