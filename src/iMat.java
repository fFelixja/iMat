import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class iMat extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXML/TopMenu.fxml"));

        Scene scene = new Scene(root, 1280, 800);

        stage.setTitle("Ett fint namn");
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String args[]) {
        launch(args);
    }
}
