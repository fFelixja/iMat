import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;
import java.util.List;

public class CategoryController extends AnchorPane {

    @FXML private ImageView categoryImage;

    @FXML private Label categoryLabel;

    private ProductCategory category;

    private TopMenuController controller;

    private String categoryName;

    public CategoryController (ProductCategory category, String categoryName, Image categoryImage, TopMenuController controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/Category.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of CategoryController");
        }

        this.controller = controller;
        this.categoryName = categoryName;

        this.category = category;
        this.categoryLabel.setText(categoryName);
        this.categoryImage.setImage(categoryImage);
    }

    public String getName(){
        return categoryName;
    }

    @FXML
    protected void categoryPressedActionPerformed(MouseEvent event) {
        controller.clearProductGridPane();

        controller.productViewToFront();

        controller.setViewLabel(categoryName);

        controller.setLatestCategory(this);

        createProductView();

    }

    public void createProductView() {

        List<Product> productList = DataHandler.getProducts(category);
        if (category.equals(ProductCategory.HOT_DRINKS)) {
            productList.addAll(DataHandler.getProducts(ProductCategory.COLD_DRINKS));
        }

        for (int i = 0; i < productList.size(); i++) {
            controller.addProductToGrid(productList.get(i), i % 4, i / 4);
        }
    }
}
