package sample;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerServer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button runButton;

    @FXML
    void initialize() {

        runButton.setOnAction(event -> {
            try {
                //runButton.getScene().getWindow().hide();
                //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                //Stage cancelLanguage = new Stage();
                //cancelLanguage.setTitle("ATM CREATED BY <HAZGAR>");
                //cancelLanguage.setScene(new Scene(root, 700, 400)); // размеры нового окна
                //cancelLanguage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        });




    }
}
