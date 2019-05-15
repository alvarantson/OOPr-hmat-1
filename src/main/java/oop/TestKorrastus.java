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
    public void start(Stage pealava) {
        List<String> testList = Arrays.asList("sõna1", "sõna2", "sõna3", "ai", "looool", "qwerty", "õppeinfosüsteem");
        Group juur = new Group();
        Scene stseen = new Scene(juur);
        stseen.setFill(Color.WHITE);
        pealava.setScene(stseen);
        pealava.setResizable(false);
        pealava.setHeight(800);
        pealava.setWidth(800);
        pealava.setTitle("Test");
        pealava.show();
        int eelmisePikkus = 0;
        int eelmiseX = 0;
        for (int i = 0; i < testList.size(); i++) {
            Text tekst = new Text(testList.get(i));
            tekst.setFont(new Font(20));
            tekst.setX(eelmiseX + eelmisePikkus);
            eelmiseX += eelmisePikkus;
            tekst.setY(20);
            juur.getChildren().add(tekst);
            eelmisePikkus = testList.get(i).length()*12;
        }
    }

}
