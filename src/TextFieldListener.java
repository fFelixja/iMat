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

    public TextFieldListener(TextField textField, Label errorMessageLabel, String errorMessage, int checkType){
        this.texField = textField;
        this.errorMessageLabel = errorMessageLabel;
        this.errorMessage = errorMessage;
        this.checkType = checkType;
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(!newValue) {
                System.out.println("Start:" + texField.getText()+ ":End");
                isOk = CheckUtils.check(checkType, texField.getText());
                System.out.println(isOk);
                setErrorMessageLabel(errorMessage);
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
}
