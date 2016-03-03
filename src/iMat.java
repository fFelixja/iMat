import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class iMat extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("FXML/TopMenu.fxml"));

        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add("css/topMenuStyle.css");
        stage.setTitle("iMatVersionRune");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              DataHandler.shutdown();
              System.exit(0);
          }
      });

    }
    public static void main(String args[]) {
        launch(args);
    }
}
