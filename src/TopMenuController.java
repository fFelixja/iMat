import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class TopMenuController extends AnchorPane implements Initializable{
    @FXML private TextField searchTextField;

    @FXML private Button backButton;

    @FXML private Button homeButton;

    @FXML private Button profileButton;

    @FXML private Button purchaseHistoryButton;

    @FXML private Button shoppingCartButton;

    @FXML private ImageView backButtonImage;

    @Override
    public void initialize(URL url, ResourceBundle bundle){
        System.out.println("a");
//        backButtonImage.setImage(new Image("img/backbutton.png"));
    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        System.out.println("hej");
    }

}
