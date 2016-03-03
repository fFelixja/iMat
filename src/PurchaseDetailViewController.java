import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.io.IOException;
import java.util.List;

public class PurchaseDetailViewController extends AnchorPane{

    @FXML private Label dateBoughtLabel;

    @FXML private Label nbrOfProductsLabel;

    @FXML private Label priceLabel;

    @FXML private GridPane productGrid;

    @FXML private Button addToCartButton;

    private List<ShoppingItem> productList;

    public PurchaseDetailViewController() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PurchaseDetailView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Fel i PurchaseDetailView");
        }
    }

    public void setOrder(Order order){
        dateBoughtLabel.setText(order.getDate().toString());
        nbrOfProductsLabel.setText(order.getItems().size() + " st");
        priceLabel.setText(DataHandler.getOrderTotal(order) + " kr");

        productList = order.getItems();
        addProducts();

    }

    private void addProducts(){
        clearProductGrid();
       for (int i = 0; i < productList.size(); i++){


           HistoryProductItemController productItem = new HistoryProductItemController(productList.get(i));
           productGrid.add(productItem, i%2, i/2);
       }

    }

    private void clearProductGrid() {
        productGrid.getChildren().removeAll(productGrid.getChildren());
    }

    @FXML
    protected void addToCartButtonActionPerformed(ActionEvent event) {

        for (ShoppingItem shoppingItem: productList) {
            DataHandler.addToCart(shoppingItem.getProduct(), shoppingItem.getAmount());
        }
    }
}
