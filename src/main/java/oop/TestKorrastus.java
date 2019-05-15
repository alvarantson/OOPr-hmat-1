package oop;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class TestKorrastus extends Application {

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
        */
        launch(args);
    }

    @Override
    public void start(Stage pealava) throws Exception {
        String[] testList = {"sõna1", "sõna2", "sõna3", "ai", "looool", "qwerty", "õppeinfosüsteem",
                "veel", "muud", "paska", "räigelt", "jamamist", "katsetamiseks"};
        int[] testlist2 = {2, 11, 10, 8, 6, 5, 10, 7, 1, 1, 3, 6, 4};
        Map<String, Integer> testmap = new HashMap<>();
        for (int i = 0; i < testList.length; i++) {
            testmap.put(testList[i], testlist2[i]);
        }
        Map<String, Integer> sorted = testmap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        Group juur = new Group();
        System.out.println(sorted);
        Scene stseen = new Scene(juur);
        stseen.setFill(Color.WHITE);
        pealava.setScene(stseen);
        pealava.setResizable(false);
        pealava.setHeight(800);
        pealava.setWidth(800);
        pealava.setTitle("Test");
        pealava.show();
        int uusX, uusY, pikkus, font, maxFont = 0, max = 0, counter = 0;
        for (String sõna : sorted.keySet()) {
            Text tekst = new Text(sõna);
            if (counter == 0) {
                max = sorted.get(sõna);
                maxFont = Math.min(120, (int) (500 / (sõna.length() * 0.75) * (sorted.get(sõna) / max)));
                counter = 1;
            }
            font = (int) (maxFont * ((double) sorted.get(sõna) / max));
            pikkus = (int) (sõna.length() * font * 0.75);
            uusX = (int) (Math.random() * (795 - pikkus) + 5);
            uusY = (int) (Math.random() * (780 - font * 2) + 20);
            tekst.setFont(new Font(font));
            tekst.setX(uusX);
            tekst.setY(uusY);
            tekst.toBack();
            juur.getChildren().add(tekst);
            System.out.println(sõna);
        }
    }

}
