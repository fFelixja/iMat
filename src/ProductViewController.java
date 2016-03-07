
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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

    private TopMenuController controller;

    public ProductViewController(TopMenuController controller, Product product, int spinnerSpinAmount) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ProductView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ProductViewController");
        }

        this.controller = controller;

        this.product = product;
        this.nameLabel.setText(product.getName());
        this.productImage.setImage(DataHandler.getProductImage(product));
        priceUnitLabel.setText(Double.toString(product.getPrice()) + " " + product.getUnit());
        amountUnitLabel.setText(product.getUnitSuffix());

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
        double amount = DataHandler.addToCart(product, Double.parseDouble(amountSpinner.getValue().toString()));

        controller.addToCartFeedback(product.getName(), amount);

    }
}
