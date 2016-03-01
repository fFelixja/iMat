import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFieldListener implements ChangeListener<Boolean>{

    @FXML
    private final TextField texField;
    private final Label errorMessageLabel;
    private  final int checkType;
    private final String errorMessage;
    private boolean isOk;
    private Label cardLabel;
    private CheckUtils utils;

    public TextFieldListener(TextField textField, Label errorMessageLabel, String errorMessage, int checkType){
        this.texField = textField;
        this.errorMessageLabel = errorMessageLabel;
        this.errorMessage = errorMessage;
        this.checkType = checkType;
        this.utils = new CheckUtils();
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(!newValue) {
                isOk = utils.check(checkType, texField.getText());
                setErrorMessageLabel(errorMessage);
                if(checkType == 5){
                    String cardType = utils.getCardType();
                    cardLabel.setText(cardType);
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

    public void setCardLabel(Label cardLabel){
        this.cardLabel = cardLabel;
    }


}
