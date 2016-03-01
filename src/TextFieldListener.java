import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class TextFieldListener implements ChangeListener<Boolean>{

    @FXML
    private TextField textField;
    private Label errorMessageLabel;
    private ImageView cardImage;
    private  int checkType;
    private String errorMessage;
    private boolean isOk;
    private Label cardLabel;
    private CheckUtils utils;

    public TextFieldListener(TextField textField, Label errorMessageLabel, String errorMessage, int checkType){
        this.textField = new TextField();
        this.textField = textField;
        this.errorMessageLabel = errorMessageLabel;
        this.errorMessage = errorMessage;
        this.checkType = checkType;
        this.utils = new CheckUtils();
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(!newValue) {
                isOk = utils.check(checkType, textField.getText());
                setErrorMessageLabel(errorMessage);
                if(checkType == 5){
                    cardLabel.setText(utils.getCardType());
                    cardImage.setImage(utils.getCardImage());
                }
            }
    }

    private void setErrorMessageLabel(String message){
        if(!isOk){
            errorMessageLabel.setText(message);
        }else{
            errorMessageLabel.setText(null);
        }
    }

    public boolean getIsOk(){
        return isOk;
    }

    public void setCardNumberGUI(Label cardLabel, ImageView cardImage){
        this.cardLabel = cardLabel;
        this.cardImage = cardImage;
    }


}
