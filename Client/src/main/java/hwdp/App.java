package hwdp;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * klasa klienta  odpowiadajaca za utworzenie okna menu wyboru gry
 *
 */
public class App {
    /**
     * metoda dekodujaca lancuch znakow w obiekt graficzny
     * @param figure zakodowany lancuch znakow
     * @return odkodowany ksztalt
     */
    public static Shape decodeFigure(String figure){

            int i=0;
            String[] color = {"","",""};
            Shape f;
            String type = "";

            //Odczytywanie typu figury
            while(figure.charAt(i) != '$')
            {
                type =type + (figure.charAt(i) +"");
                i++;
            }
            i++;

            //Odczytywanie parametrów figury w zalezności od odczytanego typu
            switch(type) {
                case "MyShape":
                    String[] cord = {"", "", "", ""};

                    for (int j = 0; j < 4; j++) {
                        while (figure.charAt(i) != '$') {
                            cord[j] = cord[j] + (figure.charAt(i) + "");
                            i++;
                        }
                        i++;
                    }
                    f = new MyShape(Double.parseDouble(cord[0]), Double.parseDouble(cord[1]), Double.parseDouble(cord[2]), Double.parseDouble(cord[3]));


                    while (figure.charAt(i) != '[') {
                        i++;
                    }

                    //Odczytanie koloru
                    for (int j = 0; j < 3; j++) {
                        i++;
                        i++;
                        i++;
                        while ((figure.charAt(i) != ',') && (figure.charAt(i) != ']')) {
                            color[j] = color[j] + (figure.charAt(i) + "");
                            i++;
                        }
                    }
                    ((MyShape)f).setColor(new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])));
                    return f;
                default:
                    return null;
            }

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Menu menu = new Menu("localhost");

    }
}
