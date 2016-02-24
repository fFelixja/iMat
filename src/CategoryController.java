import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;

public class CategoryController extends AnchorPane {

    @FXML private ImageView categoryImage;

    @FXML private Label categoryLabel;

    private ProductCategory category;

    public CategoryController (ProductCategory category, String categoryName, Image categoryImage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/Category.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of CategoryController");
        }

        this.category = category;
        this.categoryLabel.setText(categoryName);
        this.categoryImage.setImage(categoryImage);
    }

    @FXML
    protected void categoryPressedActionPerformed(MouseEvent event) {
        DataHandler.getProducts(category);

    }
}
