import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TextFiledListner implements ChangeListener<Boolean>{

    @FXML
    private final TextField texField;
    private final Label errorMessageLabel;
    private final Button saveButton;
    private final int checkType;
    private boolean isOk;

    public TextFiledListner(TextField textField, Label errorMessage, int checkType, Button saveButton){
        this.texField = textField;
        this.errorMessageLabel = errorMessage;
        this.saveButton = saveButton;
        this.checkType = checkType;
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(!newValue){
                switch (checkType){
                    case 0:
                        boolean isOk = CheckUtils.nameCheck(texField.getText().toString());
                        if(!isOk){
                            errorMessageLabel.setText("Nu blev något fel!");

                        }else{
                            errorMessageLabel.setText("");
                        }
                        break;
                    case 1:
//                        CheckUtils.adressCheck(texField.getText().toString());
                }
            }
    }

    public boolean getIsOk(){
        return isOk;
    }
}
