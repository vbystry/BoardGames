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


public class GamePanel extends JPanel implements Runnable {
    private boolean turnflag = false;
    private boolean gameOver = false;
    public ArrayList<Shape> board= new ArrayList<>();
    public ArrayList<Shape> todraw = new ArrayList<>();
    private Scanner in;
    private PrintWriter out;
    private Scanner scanner;
    private Jsonb jsonb = JsonbBuilder.create();
    private String gameName;

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
    public Shape[][] readBoardFromBuffer(){
        return null;
    }
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
        //return null;
    }
    private void drawGame(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(20,50,70));
        //Rectangle2D rec = new Rectangle2D.Double(100,100,20,50);
        //g2d.fill(rec);

        for(Shape shape : board)
        {
            g2d.fill(shape);
        }
        //for(Shape shape : board){
          //  g2d.fill(shape);
        //}

        g2d.setPaint(Color.GREEN);

        for(Shape shape : todraw)
        {
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
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGame(g);

    }




    private class myMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event){
            System.out.println("click");
            sendClickInfo(event);
        }
    }

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
                    System.out.println("turnFlag");
                }
                else if(data.equals("Turn over"))   {this.turnflag=false;}
                else
                {
                    //System.out.println(data);
                    try{
                        todraw.add(App.decodeFigure(data));
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    //System.out.println(data2);
                    //todraw = jsonb.fromJson(data, new ArrayList<Shape>(){}.getClass().getGenericSuperclass());
                }
            }

        }
    }
}
