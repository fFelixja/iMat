import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
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

    @FXML private Button searchButton;

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

    @FXML private Label viewLabel;

    @FXML private AnchorPane feedbackPanel;

    private PauseTransition feedbackDelay = new PauseTransition(Duration.seconds(5));

    private CategoryController latestCategory;

    private ConfirmViewController confirmView = new ConfirmViewController();

    private ProfileViewController profile = new ProfileViewController(this);

    private CheckoutViewController checkout = new CheckoutViewController(this);

    private PurchaseHistoryViewController history  = new PurchaseHistoryViewController(this);

    private PurchaseDetailViewController pastDetails = new PurchaseDetailViewController();

    private ShoppingCartViewController shoppingCart = new ShoppingCartViewController(this);

    private List<Integer[]> productID = new ArrayList<>();
    private String[] categoryName = {"Kött", "Fisk", "Mejeriprodukter", "Potatis & Ris",
            "Pasta", "Bröd","Citrusfrukter", "Exotiska Frukter", "Meloner","Stenfrukter",
            "Grönsaker", "Kål", "Rotfrukter", "Baljväxter", "Bär", "Örtkryddor", "Sötsaker",
            "Torrvaror", "Nötter & Frön", "Dryck"};

    Timeline timeline = new Timeline();

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

        baseStackPane.getChildren().add(checkout);

        baseStackPane.getChildren().add(confirmView);

        homeButton.requestFocus();

        categoryViewToFront();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(5),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        feedbackPanel.setVisible(false);
                        System.out.println("stop");
                    }
                }));
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

//                Used to make meat the "default category" to eliminate errors while looping with the back button
//                when the application starts
                if (i == 0 && j == 0) {
                    latestCategory = categoryPane;
                }

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

        setViewLabel("Sökning på \"" + searchTextField.getText() + "\"");

    }

    @FXML
    protected void homeButtonActionPerformed(ActionEvent event) {
        categoryViewToFront();
        viewLabel.setText("Alla kategorier");
    }

    @FXML
    protected void backButtonActionPerformed(ActionEvent event) {
        baseStackPane.getChildren().get(baseStackPane.getChildren().size() - 1).toBack();

        if (baseStackPane.getChildren().get(baseStackPane.getChildren().size() - 1).getId().equals("productView")) {
            latestCategory.createProductView();
        }

        switch (baseStackPane.getChildren().get(baseStackPane.getChildren().size() - 1).getId()){
            case "shoppingCart": setViewLabel("Kundvagn");
                break;
            case "purchaseDetailView": setViewLabel("Skriv bra text här");
                break;
            case "purchaseHistoryView": setViewLabel("Tidigare inköp");
                break;
            case "profileView": setViewLabel("Din profil");
                break;
            case "productView": try {
                setViewLabel(latestCategory.getName());
            } catch (NullPointerException e) {
                System.out.println("Fuck iMat");
            }
                break;
            case "categoryScrollPane": setViewLabel("Alla kategorier");
                break;
            case "confirmView": setViewLabel("Bekräftelsevy");
                break;
            default: break;
        }
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

    public void setLatestCategory(CategoryController category) {
        latestCategory = category;
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

    public void checkoutViewToFront() {
        checkout.toFront();
        setViewLabel("Kassa");
    }

    public void shoppingCartViewToFront() {
        shoppingCart.populateProductGridPane(DataHandler.getShoppingCart());
        viewLabel.setText("Kundvagn");
        shoppingCart.toFront();
    }

    public void confirmViewToFront() {
        confirmView.toFront();
        setViewLabel("Bekräftelsevy");
    }

    public void pastPurchaseDetailViewToFront(Order order){
        pastDetails.setOrder(order);
        pastDetails.toFront();
    }

    public void addProductToGrid(Product product, int column, int row) {
        ProductViewController productView = new ProductViewController(this, product, 1);
        productGridPane.add(productView, column, row);
        productGridPane.getStyleClass().add("gridStyle");
    }

    public void addToCartFeedback(Product product, double amount) {
        timeline.stop();

        ItemAddedMessagePanelController popupPanel= new ItemAddedMessagePanelController(product.getName(), amount);
        feedbackPanel.getChildren().removeAll(feedbackPanel.getChildren());
        feedbackPanel.getChildren().addAll(popupPanel);
        feedbackPanel.setVisible(true);

        timeline.play();

//        feedbackDelay.setOnFinished( event -> feedbackPanel.setVisible(false) );
//        feedbackDelay.play();
    }

    public void setViewLabel(String text) {
        viewLabel.setText(text);
    }

}
