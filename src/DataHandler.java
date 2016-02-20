import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ProductCategory;

public class DataHandler {

//    IMatDataHandler dataHandler;

    public DataHandler() {
//         dataHandler = IMatDataHandler.getInstance();
    }

    public static String getCategory() {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProduct(29).getCategory().toString();
    }

    public static Image getCategoryImage(ProductCategory category) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getFXImage(dataHandler.getProducts(category).get(0));
    }
}