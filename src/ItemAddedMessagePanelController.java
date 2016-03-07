import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ItemAddedMessagePanelController extends AnchorPane {

    @FXML private Label nbrOfAddedItemLabel;

    @FXML private Label productAddedLabel;

    public ItemAddedMessagePanelController(String name, double amount) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ItemAddedMessagePanel.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ItemAddedMessagePanel");
        }

        nbrOfAddedItemLabel.setText(Double.toString(amount));
        productAddedLabel.setText(name);
    }
}
