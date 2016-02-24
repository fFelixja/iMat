import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

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

    @FXML private StackPane baseStackPane;

    @FXML private ScrollPane categoryScrollPane;

    @FXML private GridPane categoryGridPane;

    @Override
    public void initialize(URL url, ResourceBundle bundle){
//        System.out.println("a");
        backButtonImage.setImage(new Image("img/backbutton.png"));
        CategoryController categoryPane = new CategoryController("Kött");
        categoryGridPane.add(categoryPane, 1, 1);
    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        System.out.println("hej");
    }

    @FXML
    protected void profileButtonActionPerformed(ActionEvent event){
        System.out.println("Profilknapp fungerar");
        ProfileViewController profileController = new ProfileViewController();
        profileController.toFront();
    }

}
