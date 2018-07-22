import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("view/screen1.fxml"));
        VBox pane = fxmlLoader.load();

        Scene scene = new Scene(pane);
        scene.getStylesheets().add("css/screen1.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }
}
