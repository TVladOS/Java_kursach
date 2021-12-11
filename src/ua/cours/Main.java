package ua.cours;
import ua.cours.classes.IFace.ThreadStarter;
import ua.cours.classes.IFace.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Thread emuThread;
    public static Controller controller;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("simple.fxml"));
        Parent root = loader.load();
        controller =  loader.getController();
        emuThread = new Thread(new ThreadStarter());


        stage.setTitle("Threads");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }


    @Override
    public void stop() throws Exception {
        super.stop();
        if(emuThread.isAlive())
            emuThread.stop();
    }

    }
