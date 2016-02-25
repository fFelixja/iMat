
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class PurchaseDetailViewController extends AnchorPane{
    @FXML private Label dateBoughtLabel;

    @FXML private Label nbrOfProductsLabel;

    @FXML private Label priceLabel;

    @FXML private GridPane productGrid;

    private List<ShoppingItem> productList;


    public PurchaseDetailViewController(Order order) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PurchaseDetailView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("fel");
        }


        /* So maybe this shit should be moved to separate methods... TODO */

        productList = order.getItems();
        double orderTotal = 0.0;

        for (ShoppingItem i : productList){
            orderTotal = orderTotal + i.getTotal();
        }

        dateBoughtLabel.setText(order.getDate().toString());
        nbrOfProductsLabel.setText(order.getItems().size() + " st");
        priceLabel.setText(orderTotal + " kr");


    }



}
