
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;

public class ProductViewController extends AnchorPane {
    @FXML private Spinner amountSpinner;

    @FXML private Label nameLabel;

    @FXML private Label priceUnitLabel;

    @FXML private Label amountUnitLabel;

    @FXML private Button addToCartButton;

    @FXML private ImageView productImage;

    private Product product;

    public ProductViewController(Product product, String name, Image image, int spinnerSpinAmount) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ProductView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }

        this.product = product;
        nameLabel.setText(name);
        productImage.setImage(image);

        amountSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1, spinnerSpinAmount));
    }

    public void setProductImage(Image image) {
        productImage.setImage(image);
    }

    public void setNameLabel(String name) {
        nameLabel.setText(name);
    }

    @FXML
    protected void addToCartButtonActionPerformed(ActionEvent event) {
        DataHandler.addToCart(product, Double.parseDouble(amountSpinner.getValue().toString()));
    }
}
