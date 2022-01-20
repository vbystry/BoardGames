package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author  Mateusz Bystronski
 * @author  Piotr Korycki
 * klasa panelu, na ktorym prowadzona jest rozgrywka, zawiera metody potrzebne do malowania, odczytu oraz wysylania danych, a takze do synchronizowania graczy (watkow)
 */
public class GamePanel extends JPanel implements Runnable {
    /**
     * flaga ruchu informujaca watek, w ktorym znajduje sie panel o mozliwosci ruchu
     */
    private boolean turnflag = false;
    /**
     * flaga gry
     */
    private boolean gameOver = false;
    /**
     * lista pol wyslanych przez serwer
     */
    public ArrayList<Shape> board= new ArrayList<>();
    /**
     * lista pionkow
     */
    public ArrayList<Shape> todraw = new ArrayList<>();
    /**
     * wejscie klienta
     */
    private Scanner in;
    /**
     * wyjscie klienta
     */
    private PrintWriter out;
   // private Scanner scanner;
    //private Jsonb jsonb = JsonbBuilder.create();
    /**
     * nazwa gry obslugiwanej przez klient
     */
    private String gameName;

    /**
     * konstruktor panelu, inicjalizuje polaczenie z serwerem, uruchamia obsluge myszy oraz odczytuje figury, potrzebne do rysowania planszy
     * @param in wejscie panelu
     * @param out wyjscie panelu
     * @param gameName nazwa gry
     */
    public GamePanel(Scanner in, PrintWriter out, String gameName){
        this.in=in;
        this.out=out;
        this.gameName="Chinese Checkers";

        String data="";

        boolean flag=true;

        while(flag) {

            while (!in.hasNextLine()) {

            }
            data = in.nextLine();
            if(data.equals("end"))  {
                flag=false;
                System.out.println("end");
            }
            else {
                //System.out.println(data);
                //board=jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                Shape shape= App.decodeFigure(data);
                board.add(shape);
            }
        }

        this.readToDrawFromBuffer();

        myMouseAdapter A= new myMouseAdapter();
        addMouseListener(A);


    }
  //  public Shape[][] readBoardFromBuffer(){
    //    return null;
    //}

    /**
     * metoda odczytujaca z wyjscia serwera informacje, potrzebne do prowadzenia rozgrywki
     */
    public void readToDrawFromBuffer(){
        todraw.clear();
        boolean flag=true;
        String data="";

        while(flag) {

            while (!in.hasNextLine()) {

            }
            data = in.nextLine();
            if(data.equals("end"))  {
                flag=false;
                System.out.println("end");
            }
            else {
                //System.out.println(data);
                //board=jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                Shape shape= App.decodeFigure(data);
                todraw.add(shape);
            }
        }
        this.repaint();
        //return null;
    }

    public void readToDrawFromBuffer(String prevData){
        todraw.clear();
        todraw.add(App.decodeFigure(prevData));
        boolean flag=true;
        String data="";

        while(flag) {

            while (!in.hasNextLine()) {

            }
            data = in.nextLine();
            if(data.equals("end"))  {
                flag=false;
                System.out.println("end");
            }
            else {
                //System.out.println(data);
                //board=jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                Shape shape= App.decodeFigure(data);
                todraw.add(shape);
            }
        }
        this.repaint();
        //return null;
    }

    /**
     * metoda obslugujaca malowanie obiektow
     * @param g obiekt graficzny
     */
    private void drawGame(Graphics g){
        //System.out.println("rysujemy");
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(100,100,100));
        //Rectangle2D rec = new Rectangle2D.Double(100,100,20,50);
        //g2d.fill(rec);

        for(Shape shape : board)
        {
            g2d.fill(shape);
        }
        //for(Shape shape : board){
          //  g2d.fill(shape);
        //}

        //g2d.setPaint(Color.GREEN);
        for(Shape shape : todraw)
        {
            g2d.setPaint(((MyShape)shape).color);
            g2d.fill(shape);
        }


    }
    public void sendClickInfo(MouseEvent e){
        if(turnflag)
        {
            /*String event = jsonb.toJson(e);
            out.println(event);
            System.out.println(event);*/

            //Jak bedzie czas zmienic to na factory method
            switch(gameName){
                case "Chinese Checkers":
                    out.println(e.getPoint().x);
                    out.println(e.getPoint().y);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * metoda malujaca obiekty
     * @param g obiekt graficzny
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }


    /**
     * klasa wewnetrzna, pelniaca funkcje rozszerzenia klasy mosyeAdapter w celu wysylania informacji o przycisnieciu myszy
     */
    private class myMouseAdapter extends MouseAdapter{
        /**
         * metoda wysylajaca dane po kliknieciu
         * @param event
         */
        @Override
        public void mousePressed(MouseEvent event){
            System.out.println("click");
            sendClickInfo(event);
        }
    }

    /**
     * metoda odpowiadajaca za komunikacje z serwerem oraz synchronizacje paneli obslugiwanych przez poszczegolne watki
     */
    @Override
    public void run() {
        System.out.println("run");
        while(!gameOver)
        {
            if(in.hasNextLine()){
                System.out.println("new data");
                String data = in.nextLine();
                //String data2= in.nextLine();
                System.out.println(data);


                if(data.equals("Your turn"))
                {
                    this.turnflag=true;
                    repaint();
                    System.out.println("turnFlag");
                }
                else if(data.equals("Turn over"))   {this.turnflag=false;}
                else
                {
                    //System.out.println(data);
                    try{
                        //todraw.add(App.decodeFigure(data));
                        readToDrawFromBuffer(data);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    //System.out.println(data2);
                    //todraw = jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                }
                repaint();
            }

        }
    }
}
