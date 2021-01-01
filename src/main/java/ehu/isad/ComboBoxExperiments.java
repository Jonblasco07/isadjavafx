package ehu.isad;


import com.google.gson.Gson;
import ehu.isad.model.Txanpona;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ComboBoxExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("ComboBox Experiment 1");

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("BTC");
        comboBox.getItems().add("ETH");
        comboBox.getItems().add("LTC");

        comboBox.setEditable(true);

        comboBox.setOnAction(e -> System.out.println( comboBox.getValue()));

        HBox hbox = new HBox(comboBox);

        Scene scene = new Scene(hbox, 200, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

        comboBox.setOnAction(e -> {
            HBox h = new HBox();
            Scene scene2 = new Scene(h, 400, 120);
            String a = comboBox.getValue().toString();

            Txanpona b= null;
            try {
                b = readFromUrl(a.toLowerCase());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            h.getChildren().addAll(new Label("1 " + a + " = " + b.price + "euro", comboBox));
            primaryStage.setScene(scene2);



    });



    }
    public static Txanpona readFromUrl(String txanpon) throws IOException {

        String inputLine;

        URL coinmarket = new URL("https://api.gdax.com/products/"
                + txanpon + "-eur/ticker");
        URLConnection yc = coinmarket.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        inputLine = in.readLine();
        in.close();

        Gson gson = new Gson();
        return gson.fromJson(inputLine, Txanpona.class);

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

