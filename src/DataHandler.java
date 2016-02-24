import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingCart;

public class DataHandler {

//    IMatDataHandler dataHandler;

    public DataHandler() {
//         dataHandler = IMatDataHandler.getInstance();
    }

    public static String getCategory(int productId) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProduct(productId).getCategory().toString();
    }

    public static Image getCategoryImage(ProductCategory category) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getFXImage(dataHandler.getProducts(category).get(0));
    }


    public static void addToCart(Product product, double amount) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.getShoppingCart().addProduct(product, amount);
    }

    public static Product getProduct(int idNumber) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProduct(idNumber);
    }
}