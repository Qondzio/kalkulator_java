import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public void start(Stage stage) throws Exception
    {
        Parent mainScene=FXMLLoader.load(getClass().getResource("calc_fxml.fxml"));
        Scene scene=new Scene(mainScene);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}