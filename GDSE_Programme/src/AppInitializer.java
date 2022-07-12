import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);

        primaryStage.setScene
                (new Scene(FXMLLoader.load
                        (getClass().getResource("ijse/lk/dbp/view/StudentForm.fxml"))));
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
