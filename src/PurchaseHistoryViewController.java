import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import se.chalmers.ait.dat215.project.Order;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class PurchaseHistoryViewController extends AnchorPane {

    @FXML private VBox purchaseBox;

    public PurchaseHistoryViewController (TopMenuController controller) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/PurchaseHistoryView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Fel i PurchaseHistoryView");
        }

        List<Order> pastOrders = DataHandler.getPastOrders();

        pastOrders.sort(new OrderComparator());
        for (Order order : pastOrders){
            System.out.println(order.getOrderNumber());
            purchaseBox.getChildren().add(new PastPurchasePanelController(order, controller));
        }
    }
}

class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order a, Order b) {
        return b.getOrderNumber() - a.getOrderNumber();
    }

}
