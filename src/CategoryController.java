import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class CategoryController extends AnchorPane {

    @FXML private ImageView categoryImage;
    @FXML private Label categoryLabel;

    public CategoryController (String categoryName, Image categoryImage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/Category.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }
        this.categoryLabel.setText(categoryName);
        this.categoryImage.setImage(categoryImage);
    }

}
