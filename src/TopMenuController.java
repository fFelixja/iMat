import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;


public class TopMenuController extends AnchorPane implements Initializable{

    @FXML private TextField searchTextField;

    @FXML private Button backButton;

    @FXML private Button homeButton;

    @FXML private Button profileButton;

    @FXML private Button purchaseHistoryButton;

    @FXML private Button shoppingCartButton;

    @FXML private ImageView backButtonImage;

    @FXML private ImageView cartImage;

    @FXML private StackPane baseStackPane;

    @FXML private ScrollPane categoryScrollPane;

    @FXML private GridPane categoryGridPane;

    @FXML private ScrollPane productScrollPane;

    @FXML private GridPane productGridPane;

    @FXML public Label viewLabel; //TODO: set to name of category

    private ProfileViewController profile = new ProfileViewController();

    private PurchaseHistoryViewController history  = new PurchaseHistoryViewController(this);

    private PurchaseDetailViewController pastDetails = new PurchaseDetailViewController();

    private ShoppingCartViewController shoppingCart = new ShoppingCartViewController();

    private Pane[] panelList = {baseStackPane, profile};

    private String[] panelLabelName = {"Alla kategorier","Din profil"};

    private List<Integer[]> productID = new ArrayList<>();
    private String[] categoryName = {"Kött", "Fisk", "Mejeriprodukter", "Potatis & Ris",
            "Pasta", "Bröd","Citrusfrukter", "Exotiska Frukter", "Meloner","Stenfrukter",
            "Grönsaker", "Kål", "Rotfrukter", "Baljväxter", "Bär", "Örtkryddor", "Sötsaker",
            "Torrvaror", "Nötter & Frön", "Dryck"};

    @Override
    public void initialize(URL url, ResourceBundle bundle){
        populateProductID();
        initializeCategoryView();
        backButtonImage.setImage(new Image("img/backbutton.png"));
        cartImage.setImage(new Image("img/shop.png"));
        viewLabel.setText("Alla kategorier");

        baseStackPane.getChildren().add(profile);
        baseStackPane.getChildren().add(history);
        baseStackPane.getChildren().add(pastDetails);
        baseStackPane.getChildren().add(shoppingCart);

        homeButton.requestFocus();

        categoryViewToFront();
    }

    private void populateProductID(){

        Integer[] kfm = {11,8,12};
        Integer[] kol = {17,16,2};
        Integer[] fr = {4,7,13,19};
        Integer[] green = {9,10,18};
        Integer[] green2 = {1,3,21};
        Integer[] ovrigt = {20,14,15,5};
        productID.add(kfm);
        productID.add(kol);
        productID.add(fr);
        productID.add(green);
        productID.add(green2);
        productID.add(ovrigt);

    }

    private void initializeCategoryView(){
     ProductCategory[] enumForCategories = ProductCategory.values();
        int count = 0;
        for(int i = 0; i < productID.size(); i++){
            Integer[] intTemp = productID.get(i);

            for (int j = 0; j <intTemp.length; j++){
                //New categoryview to add
                CategoryController categoryPane = new CategoryController(enumForCategories[intTemp[j] - 1],
                        categoryName[count++],DataHandler.getCategoryImage(enumForCategories[intTemp[j] - 1]), this);

                if (i == 4) {
                    categoryGridPane.add(categoryPane,j, 8);
                } else {

                    categoryGridPane.add(categoryPane,j,2*i + 1);
                }

            }
        }

    }

    @FXML
    protected void searchTextFieldKeyPressed(ActionEvent event) {
        clearProductGridPane();

        List<Product> productList = DataHandler.searchProducts(searchTextField.getText());

        for (int i = 0; i < productList.size(); i++) {
            addProductToGrid(productList.get(i), i % 4, i / 4);
        }
        productGridPane.getStyleClass().add("gridStyle");
        productViewToFront();

    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        categoryViewToFront();
        viewLabel.setText("Alla kategorier");
    }

    @FXML
    protected void backButtonActionPerformed(ActionEvent event) {
        baseStackPane.getChildren().get(baseStackPane.getChildren().size() - 1).toBack();
    }

    @FXML
    protected void profileButtonActionPerformed(ActionEvent event)throws IOException {
        profileViewToFront();

    }

    @FXML
    protected void purchaseHistoryButtonActionPerformed(ActionEvent event) throws IOException {
        historyViewToFront();
    }

    @FXML
    protected void shoppingCartButtonActionPerformed(ActionEvent event)throws IOException {
        shoppingCartViewToFront();
    }

    public void clearProductGridPane() {
        productGridPane.getChildren().removeAll(productGridPane.getChildren());
    }

    public void profileViewToFront(){
        profile.toFront();
        viewLabel.setText("Din profil");
    }

    public void productViewToFront() {
        productScrollPane.toFront();
    }

    public void categoryViewToFront() {
        categoryScrollPane.toFront();
    }

    public void historyViewToFront() {
        history.toFront();
        viewLabel.setText("Tidigare inköp");
    }

    public void shoppingCartViewToFront() {
        shoppingCart.populateProductGridPane(DataHandler.getShoppingCart());
        viewLabel.setText("Kundvagn");
        shoppingCart.toFront();
    }

    public void pastPurchaseDetailViewToFront(Order order){
        pastDetails.setOrder(order);
        pastDetails.toFront();
    }

    public void addProductToGrid(Product product, int column, int row) {
        ProductViewController productView = new ProductViewController(product, 1);
        productGridPane.add(productView, column, row);
        productGridPane.getStyleClass().add("gridStyle");
    }

    /* TODO get current pane
        public void setLabel(Label label){
            Pane currentPanel = new Pane();
            label.setText(panelLabelName[currentPanel.getChildren()]);




    }
*/

}
