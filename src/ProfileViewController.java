import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;

public class ProfileViewController extends AnchorPane {
    @FXML private TextField firstnameTextField;

    @FXML private TextField lastnameTextField;

    @FXML private TextField adressTextField;

    @FXML private TextField adressTwoTextField;

    @FXML private TextField zipcodeTextField;

    @FXML private TextField telephoneTextField;

    @FXML private TextField cityTextField;

    @FXML private TextField ccvTextField;

    @FXML private TextField cardNumberTextField;

    @FXML private TextField cardHolderTextField;

    @FXML private TextField expirationMonthTextField;

    @FXML private TextField expirationYearTextField;

    @FXML private Button saveButton;

    @FXML private Button cancelButton;

    @FXML private Button ccvHelpButton;

    @FXML private RadioButton cardRadioButton;

    @FXML private RadioButton invoiceRadioButton;

    @FXML private ChoiceBox cardTypeChoiceBox;

    private String firstname;
    private String lastname;
    private String adress;
    private String adressTwo;
    private String zipcode;
    private String postCity;
    private String telephone;
    private boolean isError = false;

    private String cardType;
    private String cardNumber;
    private String cardHolder;
    private int cardExpireMonth;
    private int cardExpireYear;
    private int cardCCV;

    public ProfileViewController(){

        //Sets items to choicebox
        ObservableList<String> cardTypes = FXCollections.observableArrayList("Visa", "Mastercard");
        cardTypeChoiceBox.setItems(cardTypes);
    }

    @FXML
    public void saveButtonActionPerformed(ActionEvent event){
        if(!isError) {
            getPersonalData();
            if(cardRadioButton.isSelected()) {
                getCardData();
            }
        }
    }

    private void getPersonalData(){

        firstname = checkString(firstnameTextField.getText());
        lastname = checkString(lastnameTextField.getText());
        adress = checkString(adressTextField.getText());
        adressTwo = checkString(adressTwoTextField.getText());
        zipcode = checkString(zipcodeTextField.getText());
        postCity = checkString(cityTextField.getText());
        telephone = checkString(telephoneTextField.getText());
        savePersonalData();
    }
    private void getCardData(){
        cardType = cardTypeChoiceBox.getValue().toString();
        cardNumber = checkString(cardNumberTextField.getText());
        cardHolder = checkString(cardHolderTextField.getText());
        cardExpireMonth = checkStringToInt(expirationMonthTextField.getText());
        cardExpireYear = checkStringToInt(expirationYearTextField.getText());
        cardCCV = checkStringToInt(ccvTextField.getText());
        saveCardData();
    }
    private int checkStringToInt(String s){
        if (s == null){
            return 0;
        }
        return Integer.parseInt(s);
    }
    private String checkString(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    private void savePersonalData(){
        DataHandler.saveCustomer(firstname,lastname, adress, zipcode, postCity, telephone);
    }

    private void saveCardData(){
        DataHandler.saveCard(cardType, cardNumber, cardHolder, cardExpireMonth, cardExpireYear, cardCCV);
    }
}
