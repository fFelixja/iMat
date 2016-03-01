import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TextFiledListner implements ChangeListener<Boolean>{

    @FXML
    private final TextField texField;

    public TextFiledListner(TextField textField){
        this.texField = textField;
    }


    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if(!newValue){
                System.out.println("Texfield Listner, Focus off");
            }
    }
}
