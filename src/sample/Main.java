package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.ServerSocket;
import java.net.Socket;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sampleServer.fxml"));
        primaryStage.setTitle("SERVER FOR ATM");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        try{
            ServerSocket server = new ServerSocket(2111);
            while(true)
            {
                System.out.println("Waiting for a client");
                Socket socket = server.accept();
                System.out.println("Client connected");
                ServerRunnable sr = new ServerRunnable(socket);
                sr.start();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
      //  launch(args);

    }

}

