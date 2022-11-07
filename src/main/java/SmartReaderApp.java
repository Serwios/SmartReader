import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SmartReaderApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(SmartReaderApp.class.getResource("app-main.fxml"));
        loader.load();
        Scene scene = new Scene(loader.getRoot());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
