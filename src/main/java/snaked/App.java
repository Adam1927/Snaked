package snaked;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import snaked.model.GameOptions;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(
                GameOptions.fromJSON("C:\\Users\\amirp\\group11\\group-11\\src\\main\\resources\\snaked\\config\\initialSettings.json")// don't forget to change it later
        );
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}