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

    public static Image getProductImage(Product product) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getFXImage(product);
    }

    public static List<Product> searchProducts(String search) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.findProducts(search);
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

    public static Customer getCustomer(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getCustomer();
    }
    public static CreditCard getCreditCard(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getCreditCard();
    }

    public static void shutdown() {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.shutDown();

    }

    public static ShoppingCart getShoppingCart() {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getShoppingCart();
    }

    public static void addToCart(Product product, double amount) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();

        //Checks if the shopping cart already contains the product as to not create duplicates
        if (dataHandler.getShoppingCart().getItems().size() < 1) {
            dataHandler.getShoppingCart().addProduct(product, amount);
        } else {
            boolean productExists = false;
            for (ShoppingItem shoppingItem : dataHandler.getShoppingCart().getItems()) {
                if (shoppingItem.getProduct().equals(product)) {
                    dataHandler.getShoppingCart().getItems().get(
                            dataHandler.getShoppingCart().getItems().indexOf(shoppingItem)).setAmount(
                            shoppingItem.getAmount() + amount);
                    productExists = true;
                    break;
                }
            }
            if (!productExists) {
                dataHandler.getShoppingCart().addProduct(product, amount);
            }
        }
    }

    public static Product getProduct(int idNumber) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProduct(idNumber);
    }

    public static List<Product> getProducts(ProductCategory category) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getProducts(category);

    }

    public static List<Order> getPastOrders(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        return dataHandler.getOrders();
    }

    public static void removeShoppingItem(ShoppingItem shoppingItem) {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.getShoppingCart().removeItem(shoppingItem);

    }

    // Returns the total cost of an order
    public static double getOrderTotal(Order order){
        double total = 0;
        for (ShoppingItem item : order.getItems()){
            total = total + item.getTotal();
        }
        return total;
    }

    public static void placeOrder() {
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.placeOrder(true);
        System.out.println(dataHandler.getOrders().size());
    }
}