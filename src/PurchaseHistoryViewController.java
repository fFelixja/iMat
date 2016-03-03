import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import se.chalmers.ait.dat215.project.Order;

import java.io.IOException;
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

        for (Order order : pastOrders){
            purchaseBox.getChildren().add(new PastPurchasePanelController(order, controller));
        }


    }

}
