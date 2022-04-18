import javax.swing.*;

public class Main {

    public static void main (String [] args) {

        JFrame objekt = new JFrame ();

        Hratelnost hratelnost = new Hratelnost ();

        objekt.setBounds (10, 10, 710, 600);
        objekt.setTitle ("Vítejte ve hře BRICK BREAKER");
        objekt.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        objekt.add (hratelnost);
        objekt.setResizable (false);
        objekt.setVisible (true);
    }
}
