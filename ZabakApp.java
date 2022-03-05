package hra;

import java.awt.*;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;


public class ZabakApp {

    private static AnimationTimer stopky;

    private static Pane root;

    private static List <Node> auticka = new ArrayList <> ();
    private static Node zabak;

    private static Parent createContent () {

        root = new Pane ();
        root.setPrefSize(1200, 900);



        root.getChildren () .add (zabak);

        stopky =new AnimationTimer () {

            @Override
            public void handle (long now) {

                onUpdate ();
            }
        };

        return root;
    }

    private Node initZabak () {

        Rectangle ctverecek = new Rectangle (45, 45);


        return initZabak();
    }

    private static Node spawniAuticko () {

        Rectangle ctverec = new Rectangle (50, 50);



        return null;
    }

    private static void onUpdate () {

        for (Node auticko : auticka) {
            auticko.setTranslateX (auticko.getTranslateX () + Math.random () * 10);
        }

        if (Math.random () < 0.080) {
            auticka.add (spawniAuticko () );
        }

        checkState ();

    }

    private static void checkState () {

        for (Node auticko : auticka) {

            if (auticko.getBoundsInParent () . intersects (zabak.getBoundsInParent () ) ) {
                System.out.println(" Game Over You Noob ");
                zabak.setTranslateX (0);
                zabak. setTranslateY (900 - 50);

                return;
            }
        }

        if (zabak.getTranslateY () <= 0) {
            stopky.stop ();

            String vyhra = " JUPÍ VYHRÁLI JSTE ";

            HBox hbox = new HBox ();
            hbox.setTranslateX (480);
            hbox.setTranslateY (380);

            root.getChildren () .add (hbox);

            int a;
            for (a = 0; a < vyhra.toCharArray () .length; a++) {
                char pismenko = vyhra.charAt (a);

                Text text = new Text (String.valueOf (pismenko) );
                text.setFont (Font.font (50) );
                text.setOpacity (0);

                hbox.getChildren () .add(text);

                FadeTransition FT = new FadeTransition (Duration.seconds (0.69) , text);
                FT.setToValue (1);
                FT.setDelay (Duration.seconds (a * 0.16) );
                FT.play ();
            }
        }
    }

    public static void start (Stage stage) throws Exception {

        stage.setScene (new Scene (createContent () ) );
        stage.getScene () .setOnKeyPressed (event -> {
            switch (event.getCode()) {

                case W:
                    zabak.setTranslateY(zabak.getTranslateY() - 45);
                    break;

                case S:
                    zabak.setTranslateY(zabak.getTranslateY() + 45);
                    break;

                case A:
                    zabak.setTranslateY(zabak.getTranslateX() - 45);
                    break;

                case D:
                    zabak.setTranslateY(zabak.getTranslateX() + 45);
                    break;

                default:
                    break;
            }
        });
        stage.show ();

    }

    public static void main (String[] args) {

        launch (args);
    }

}


