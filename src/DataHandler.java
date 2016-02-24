import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.*;

import java.util.List;

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
    public static void saveCustomer(String firstname, String lastname, String adress, String zipcode, String postAdress, String telephone){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        //Save customer information
        dataHandler.getCustomer().setFirstName(firstname);
        dataHandler.getCustomer().setLastName(lastname);
        dataHandler.getCustomer().setAddress(adress);
        dataHandler.getCustomer().setPostCode(zipcode);
        dataHandler.getCustomer().setPostAddress(postAdress);
        dataHandler.getCustomer().setPhoneNumber(telephone);
    }
    public static void saveCard(String cardType, String cardNumber, String cardHolder, int expireMonth, int expireYear, int ccv ){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        //Save all card details.
        dataHandler.getCreditCard().setCardType(cardType);
        dataHandler.getCreditCard().setCardNumber(cardNumber);
        dataHandler.getCreditCard().setHoldersName(cardHolder);
        //if values is zero => string == null and will not be included in save
        if(expireMonth != 0) {
            dataHandler.getCreditCard().setValidMonth(expireMonth);
        }
        if (expireYear != 0) {
            dataHandler.getCreditCard().setValidYear(expireYear);
        }
        if (ccv != 0 ) {
            dataHandler.getCreditCard().setVerificationCode(ccv);
        }

    }


    public static void addToCart(Product product, double amount) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.getShoppingCart().addProduct(product, amount);
    }

    public static Product getProduct(int idNumber) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProduct(idNumber);
    }

    public static List<Product> getProducts(ProductCategory category) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProducts(category);

    }
}