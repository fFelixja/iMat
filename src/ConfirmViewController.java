import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConfirmViewController extends AnchorPane {
    @FXML private Label totalGroceriesLabel;

    @FXML private Label totalCostLabel;

    @FXML private Button shopAgainButton;

    @FXML private Button exitButton;

    public ConfirmViewController () {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ConfirmView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ConfirmViewController");
        }
    }

    @FXML
    protected void exitButtonActionPerformed(ActionEvent event) {
        DataHandler.shutdown();
        System.exit(0);
    }
}
