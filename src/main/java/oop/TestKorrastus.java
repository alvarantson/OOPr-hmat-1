package oop;

<<<<<<< HEAD

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
=======
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
>>>>>>> 385522c7150aa4bf27b61a5e3db56b37a4f1af80
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
<<<<<<< HEAD
=======
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
>>>>>>> 385522c7150aa4bf27b61a5e3db56b37a4f1af80

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class TestKorrastus extends Application {

<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
        /*
        KorrastajaLoendur korda = new KorrastajaLoendur();
        List<Ajaleht> ajalehed = Arrays.asList(new Postimees(), new Õhtuleht(), new Elu24(), new Telegram(),
                new Delfi(), new AnneJaStiil(), new Kroonika());
        korda.loeSisse(ajalehed);
        System.out.println("Tulemusi kokku: "+  korda.getGlobalList().size());
        Map<String, Integer> sorted = korda.getGlobalList()
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        //System.out.println(sorted);
        //*/
=======
    public static void main(String[] args) {
>>>>>>> 385522c7150aa4bf27b61a5e3db56b37a4f1af80
        launch(args);
    }

    @Override
    public void start(Stage pealava) throws IOException {

        Stage küsimused = new Stage();
        küsimused.setTitle("WordClout");
        küsimused.setResizable(false);
        GridPane gp1 = new GridPane();
        Text küsimus1 = new Text("Vali ajalehed:");
        küsimus1.setFont(new Font(14));
        gp1.add(küsimus1, 0, 0, 2, 1);
        Button next = new Button("Next");
        gp1.add(next, 5, 2);
        GridPane.setHalignment(next, HPos.RIGHT);
        GridPane.setMargin(next, new Insets(10));
        GridPane.setMargin(küsimus1, new Insets(10));

        GridPane gp1b = new GridPane();
        GridPane.setHalignment(gp1b, HPos.RIGHT);
        List<Ajaleht> kõikAjalehed = Arrays.asList(new Postimees(), new Õhtuleht(), new Elu24(), new Telegram(),
                new Delfi(), new AnneJaStiil(), new Kroonika());
        for (int i = 0; i < kõikAjalehed.size(); i++) {
            CheckBox check = new AjaleheCheck(kõikAjalehed.get(i).getNimi(), kõikAjalehed.get(i));
            gp1b.add(check, i % 4, i / 4);
            GridPane.setMargin(check, new Insets(5));
        }
        gp1.add(gp1b, 0, 1, 1, 1);
        GridPane.setMargin(gp1b, new Insets(10));

        Scene stseen1 = new Scene(gp1);
        küsimused.setScene(stseen1);
        küsimused.show();

        GridPane gp2 = new GridPane();
        TextField vastus1 = new TextField();
        Text küsimus2 = new Text("Sisesta keelatud sõnad (tühikutega eraldatuna):");
        küsimus2.setFont(new Font(14));
        Button valmis = new Button("Valmis");
        gp2.add(küsimus2, 0, 0, 3, 1);
        GridPane.setMargin(küsimus2, new Insets(10));
        gp2.add(vastus1, 0, 1, 3, 1);
        GridPane.setMargin(vastus1, new Insets(10));
        gp2.add(valmis, 2, 3);
        GridPane.setMargin(valmis, new Insets(10));
        Scene stseen1b = new Scene(gp2);
        GridPane.setHalignment(valmis, HPos.RIGHT);

        List<Ajaleht> valitud = new ArrayList<>();

        next.setOnMouseClicked(event -> {
            for (Node checkbox : gp1b.getChildren()) {
                if (checkbox instanceof AjaleheCheck && ((AjaleheCheck) checkbox).isSelected()) {
                    valitud.add(((AjaleheCheck) checkbox).getAjaleht());
                }
            }
            küsimused.setScene(stseen1b);
        });

        Text teade = new Text("Kaabin, läheb aega...");
        BorderPane bpTeade = new BorderPane(teade);
        BorderPane.setMargin(teade, new Insets(20));
        teade.setFont(new Font(14));
        Scene teadeStseen = new Scene(bpTeade);

        valmis.setOnMouseClicked(event -> {
            String keelatudString = vastus1.getText();
            küsimused.setScene(teadeStseen);
            KorrastajaLoendur korda = new KorrastajaLoendur();
            try {
                korda.loeSisse(valitud, Arrays.asList(keelatudString.split(" ")));
            } catch (IOException e) {
                System.exit(-1);
            }
            System.out.println("Tulemusi kokku: " + korda.getGlobalList().size());
            Map<String, Integer> sorted = korda.getGlobalList()
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                    LinkedHashMap::new));
            Group juur = new Group();
            Scene stseen2 = new Scene(juur);
            stseen2.setFill(Color.BLACK);
            pealava.setHeight(800);
            pealava.setWidth(800);
            pealava.setTitle("WordClout");
            int uusX, uusY, pikkus, font, maxFont = 10, maxValue = 0, counter = 0;
            for (String sõna : sorted.keySet()) {
                Text tekst = new Text(sõna);
                if (counter == 0) {
                    maxValue = sorted.get(sõna);
                    maxFont = Math.min(120, (int) (500 / (sõna.length() * 0.9) * (sorted.get(sõna) / maxValue)));
                    counter = 1;
                }
                font = (int) Math.sqrt(maxFont * 60 * ((double) sorted.get(sõna) / maxValue));
                pikkus = Math.min(795, (int) (sõna.length() * font * 0.9));
                int tugevus;
                if (sorted.get(sõna) < 3) {
                    tugevus = 80;
                } else if (sorted.get(sõna) < 7) {
                    tugevus = 170;
                } else if (sorted.get(sõna) < 10) {
                    tugevus = 200;
                } else {
                    tugevus = 255;
                }
                int red = (int) (Math.random() * tugevus);
                int green = (int) (Math.random() * tugevus);
                int blue = (int) (Math.random() * tugevus);
                tekst.setFill(Color.rgb(red, green, blue));
                if (pikkus == 795) uusX = 5;
                else uusX = (int) (Math.random() * (795 - pikkus) + (font / 4));
                uusY = (int) (Math.random() * (775 - font * 3) + font);
                tekst.setFont(new Font(font));
                tekst.setX(uusX);
                tekst.setY(uusY);
                juur.getChildren().add(tekst);
            }
            küsimused.close();
            pealava.setScene(stseen2);
            pealava.show();

            pealava.widthProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    for (Node node : juur.getChildren()) {
                        if (node instanceof Text) {
                            ((Text) node).setX(((Text) node).getX() * (newValue.doubleValue() / oldValue.doubleValue()));
                        }
                    }
                }
            });

            pealava.heightProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    for (Node node : juur.getChildren()) {
                        if (node instanceof Text) {
                            ((Text) node).setY(((Text) node).getY() * (newValue.doubleValue() / oldValue.doubleValue()));
                        }
                    }
                }
            });


        });
    }

}
