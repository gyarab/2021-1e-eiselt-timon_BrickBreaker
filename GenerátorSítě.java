import java.awt.*;
import java.awt.Graphics2D;
import java.awt.Color;

public class GenerátorSítě {

    public int síť [][]; //tvorba sítě, ve které se budou cihly nacházet//
    public int šířkaCihly; //tvorba šířky cihly//
    public int výškaCihly; //tvorba výšky cihly//

    public GenerátorSítě (int řada, int sloupec) {
        síť = new int [řada][sloupec];

        int a;
        for (a = 0; a < síť.length; a++) {

            int b;
            for (b = 0; b < síť [0].length; b++) {
                síť [a][b] = 1;
            }
        }

        šířkaCihly = 550/sloupec;
        výškaCihly = 150/řada;
    }

    public void draw (Graphics2D grafika)  {

        int a;
        for (a = 0; a < síť.length; a++) {

            int b;
            for (b = 0; b < síť [0].length; b++) {

                if (síť [a][b] > 0) {
                    grafika.setColor (Color.red);
                    grafika.fillRect (b * šířkaCihly + 80, a * výškaCihly + 50, šířkaCihly, výškaCihly);

                    grafika.setColor (Color.black);
                    grafika.drawRect (b * šířkaCihly + 80, a * výškaCihly + 50, šířkaCihly, výškaCihly);
                    grafika.setStroke (new BasicStroke () );
                }
            }
        }
    }

    public void udejHodnotuCihly (int hodnota, int řada, int sloupec) {

        síť [řada][sloupec] = hodnota;
    }
}
