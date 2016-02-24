import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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

    public ProfileViewController(){

    }

    @FXML
    public void saveButtonActionPerformed(ActionEvent event){
        if(!isError) {
            getData();
            saveData();
        }
    }

    private void getData(){
        firstname = checkString(firstnameTextField.getText());
        lastname = checkString(lastnameTextField.getText());
        adress = checkString(adressTextField.getText());
        adressTwo = checkString(adressTwoTextField.getText());
        zipcode = checkString(zipcodeTextField.getText());
        postCity = checkString(cityTextField.getText());
        telephone = checkString(telephoneTextField.getText());
    }
    private String checkString(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
    private void saveData(){

    }
}
