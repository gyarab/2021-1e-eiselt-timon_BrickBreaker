import javax.swing.*;

public class Main {

    public static void main (String [] args) {

        JFrame objekt = new JFrame (); //vytváření objektu//

        Hratelnost hratelnost = new Hratelnost ();

        objekt.setBounds (10, 10, 710, 600); //udávání rozměrů otevřeného okna//
        objekt.setTitle ("Vítejte v mé verzi hry BRICK BREAKER"); //nadpis v otevřeném okně//
        objekt.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        objekt.add (hratelnost);
        objekt.setResizable (false);
        objekt.setVisible (true);
    }
}
