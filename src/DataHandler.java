import javafx.scene.image.Image;
import se.chalmers.ait.dat215.project.*;

import java.util.Comparator;
import java.util.List;

public class DataHandler {

    public static String getCategory(int productId) {
        return IMatDataHandler.getInstance().getProduct(productId).getCategory().toString();
    }

    public static Image getCategoryImage(ProductCategory category) {
        return IMatDataHandler.getInstance().getFXImage(IMatDataHandler.getInstance().getProducts(category).get(0));
    }

    public static Image getProductImage(Product product) {
        return IMatDataHandler.getInstance().getFXImage(product);
    }

    public static List<Product> searchProducts(String search) {
        return IMatDataHandler.getInstance().findProducts(search);
    }

    public static void saveCustomer(String firstname, String lastname, String adress, String zipcode, String postAdress, String telephone){
        //Save customer information
        IMatDataHandler.getInstance().getCustomer().setFirstName(firstname);
        IMatDataHandler.getInstance().getCustomer().setLastName(lastname);
        IMatDataHandler.getInstance().getCustomer().setAddress(adress);
        IMatDataHandler.getInstance().getCustomer().setPostCode(zipcode);
        IMatDataHandler.getInstance().getCustomer().setPostAddress(postAdress);
        IMatDataHandler.getInstance().getCustomer().setPhoneNumber(telephone);
    }

    public static void saveCard(String cardType, String cardNumber, String cardHolder, int expireMonth, int expireYear, int ccv ){
        //Save all card details.
        IMatDataHandler.getInstance().getCreditCard().setCardType(cardType);
        IMatDataHandler.getInstance().getCreditCard().setCardNumber(cardNumber);
        IMatDataHandler.getInstance().getCreditCard().setHoldersName(cardHolder);
        //if values is zero => string == null and will not be included in save
        if(expireMonth != 0) {
            IMatDataHandler.getInstance().getCreditCard().setValidMonth(expireMonth);
        }
        if (expireYear != 0) {
            IMatDataHandler.getInstance().getCreditCard().setValidYear(expireYear);
        }
        if (ccv != 0 ) {
            IMatDataHandler.getInstance().getCreditCard().setVerificationCode(ccv);
        }

    }

    public static Customer getCustomer(){
        return IMatDataHandler.getInstance().getCustomer();
    }

    public static CreditCard getCreditCard(){
        return IMatDataHandler.getInstance().getCreditCard();
    }

    public static void shutdown() {
        IMatDataHandler.getInstance().shutDown();

    }

    public static ShoppingCart getShoppingCart() {
        return IMatDataHandler.getInstance().getShoppingCart();
    }

    public static double addToCart(Product product, double amount) {

        //Checks if the shopping cart already contains the product as to not create duplicates
        if (IMatDataHandler.getInstance().getShoppingCart().getItems().size() > 0) {
            for (ShoppingItem shoppingItem : IMatDataHandler.getInstance().getShoppingCart().getItems()) {
                if (shoppingItem.getProduct().equals(product)) {
                    IMatDataHandler.getInstance().getShoppingCart().getItems().get(
                            IMatDataHandler.getInstance().getShoppingCart().getItems().indexOf(shoppingItem)).setAmount(
                            shoppingItem.getAmount() + amount);
                    return shoppingItem.getAmount(); //Returns current amount to show the in the feedback panel
                }
            }
        }
        IMatDataHandler.getInstance().getShoppingCart().addProduct(product, amount);
        return amount;
    }

    public static Product getProduct(int idNumber) {
        return IMatDataHandler.getInstance().getProduct(idNumber);
    }

    public static List<Product> getProducts(ProductCategory category) {
        return IMatDataHandler.getInstance().getProducts(category);

    }

    public static List<Order> getPastOrders(){
        return IMatDataHandler.getInstance().getOrders();
    }

    public static void removeShoppingItem(ShoppingItem shoppingItem) {
        IMatDataHandler.getInstance().getShoppingCart().removeItem(shoppingItem);
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
        IMatDataHandler.getInstance().placeOrder(false);
    }

}
