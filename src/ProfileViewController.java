import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @FXML private Label profileLabel;

    @FXML private Label cardTypeLabel;
    @FXML private Label cardNumberLabel;
    @FXML private Label cardHolderLabel;
    @FXML private Label expireDateLabel;
    @FXML private Label monthLabel;
    @FXML private Label yearLabel;
    @FXML private Label ccvLabel;
    @FXML private Label cardLabel;
    @FXML private ImageView cardImage;

    @FXML private Label errorFirstNameLabel;
    @FXML private Label errorLastNameLabel;
    @FXML private Label errorAdressLabel;
    @FXML private Label errorAdressTwoLabel;
    @FXML private Label errorZipCodeLabel;
    @FXML private Label errorPostAreaLabel;
    @FXML private Label errorTelephoneLabel;
    @FXML private Label errorCardNumberLabel;
    @FXML private Label errorCardHolderLabel;
    @FXML private Label errorDateLabel;
    @FXML private Label errorCCVLabel;
    @FXML private Label feedBackLabel;

    private List<TextFieldListener> textFieldListenerList;


    private String firstname;
    private String lastname;
    private String adress;
    private String adressTwo;
    private String zipcode;
    private String postCity;
    private String telephone;
    private boolean isOk;


    private String cardType;
    private String cardNumber;
    private String cardHolder;
    private int cardExpireMonth;
    private int cardExpireYear;
    private int cardCCV;

    public ProfileViewController(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ProfileView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            System.out.println("Error in constructor of ProfileVeiwController");
        }
        //Sets items to choicebox
        ObservableList<String> cardTypes = FXCollections.observableArrayList("Visa", "Mastercard");
        cardTypeChoiceBox.setItems(cardTypes);
        cardTypeChoiceBox.setValue("Visa");
        initializeListeners();

    }

    private void initializeListeners(){
       textFieldListenerList = new ArrayList<>();
        TextFieldListener firstnameListener = new TextFieldListener(firstnameTextField, errorFirstNameLabel, "Godkända tecken [A-Z]" ,0);
        textFieldListenerList.add(firstnameListener);
        firstnameTextField.focusedProperty().addListener(firstnameListener);

        TextFieldListener lastnameListener = new TextFieldListener(lastnameTextField,errorLastNameLabel, "Godkända tecken [A-Z]" ,0);
        textFieldListenerList.add(lastnameListener);
        lastnameTextField.focusedProperty().addListener(lastnameListener);

        TextFieldListener adressListener = new TextFieldListener(adressTextField,errorAdressLabel, "Godkända tecken [A-Z][0-9][. , -]",1);
        textFieldListenerList.add(adressListener);
        adressTextField.focusedProperty().addListener(adressListener);
        TextFieldListener adressTwoListner = new TextFieldListener(adressTextField, errorAdressTwoLabel, "Godkända tecken [A-Z][0-9][. , -]" , 1);
        textFieldListenerList.add(adressTwoListner);
        adressTwoTextField.focusedProperty().addListener(adressTwoListner);

        TextFieldListener zipCodeListener = new TextFieldListener(zipcodeTextField, errorZipCodeLabel, "5 siffror långt [0-9]", 2);
        textFieldListenerList.add(zipCodeListener);
        zipcodeTextField.focusedProperty().addListener(zipCodeListener);

        TextFieldListener cityListener = new TextFieldListener(cityTextField, errorPostAreaLabel, "Godkända tecken [A-Ö]", 3);
        textFieldListenerList.add(cityListener);
        cityTextField.focusedProperty().addListener(cityListener);

        TextFieldListener telephoneListener = new TextFieldListener(telephoneTextField, errorTelephoneLabel, "10 tecken, bara siffror [0-9]", 4);
        textFieldListenerList.add(telephoneListener);
        telephoneTextField.focusedProperty().addListener(telephoneListener);

        TextFieldListener cardNumberListener = new TextFieldListener(cardNumberTextField,errorCardNumberLabel,"xxxx-xxxx-xxxxx-xxxx", 5);
        textFieldListenerList.add(cardNumberListener);
        cardNumberTextField.focusedProperty().addListener(cardNumberListener);

        TextFieldListener cardHolderListener = new TextFieldListener(cardHolderTextField,errorCardHolderLabel,"Förnamn Efternamn", 6);
        textFieldListenerList.add(cardHolderListener);
        cardHolderTextField.focusedProperty().addListener(cardHolderListener);

        TextFieldListener expireMonthListener = new TextFieldListener(expirationMonthTextField,errorDateLabel, "Två tecken [0-9] i vardera", 7);
        textFieldListenerList.add(expireMonthListener);
        expirationMonthTextField.focusedProperty().addListener(expireMonthListener);

        TextFieldListener expireYearListener = new TextFieldListener(expirationYearTextField,errorDateLabel, "Två tecken [0-9] i vardera", 8);
        textFieldListenerList.add(expireYearListener);
        expirationYearTextField.focusedProperty().addListener(expireYearListener);

        TextFieldListener ccvListener = new TextFieldListener(ccvTextField,errorCCVLabel, "Tre siffror [0-9]", 9);
        textFieldListenerList.add(ccvListener);
        ccvTextField.focusedProperty().addListener(ccvListener);
        cardNumberListener.setCardNumberGUI(cardLabel, cardImage);

    }

    @FXML
    public void radioButtonActionPerformed(ActionEvent event){
        if(invoiceRadioButton.isSelected()){
            cardTypeChoiceBox.setDisable(true);
            cardNumberTextField.setDisable(true);
            cardHolderTextField.setDisable(true);
            expirationMonthTextField.setDisable(true);
            expirationYearTextField.setDisable(true);
            ccvTextField.setDisable(true);
            ccvHelpButton.setDisable(true);


            cardTypeLabel.setTextFill(Color.web("CCC"));
            cardHolderLabel.setTextFill(Color.web("CCC"));
            cardNumberLabel.setTextFill(Color.web("CCC"));
            monthLabel.setTextFill(Color.web("CCC"));
            yearLabel.setTextFill(Color.web("CCC"));
            ccvLabel.setTextFill(Color.web("CCC"));
            expireDateLabel.setTextFill(Color.web("CCC"));

        }else {
            cardTypeChoiceBox.setDisable(false);
            cardNumberTextField.setDisable(false);
            cardHolderTextField.setDisable(false);
            expirationMonthTextField.setDisable(false);
            expirationYearTextField.setDisable(false);
            ccvTextField.setDisable(false);
            ccvHelpButton.setDisable(false);

            cardTypeLabel.setTextFill(Color.web("000"));
            cardHolderLabel.setTextFill(Color.web("000"));
            cardNumberLabel.setTextFill(Color.web("000"));
            monthLabel.setTextFill(Color.web("000"));
            yearLabel.setTextFill(Color.web("000"));
            ccvLabel.setTextFill(Color.web("000"));
            expireDateLabel.setTextFill(Color.web("000"));
        }
    }

    @FXML
    public void saveButtonActionPerformed(ActionEvent event) {
        int i = 0;
        isOk = true;
        while (isOk || i < textFieldListenerList.size()) {
            isOk = textFieldListenerList.get(i).getIsOk();
            i++;
        }

        if(isOk) {
            getPersonalData();
            if(cardRadioButton.isSelected()) {
                getCardData();
            }
            feedBackLabel.setTextFill(Color.web("#038610"));
            feedBackLabel.setText("Dina uppgiter är sparade!");
        }else{
            feedBackLabel.setTextFill(Color.web("#da1515"));
            feedBackLabel.setText("Du kan inte spara när det är fel!");
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

    public String getLabel(){
        return this.profileLabel.toString();
    }
}
