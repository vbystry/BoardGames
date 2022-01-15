package hwdp;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private Jsonb jsonb;
    private App master;
    private boolean gameOver=false;

    Player(Socket socket, App master){
        this.socket=socket;
        this.jsonb=JsonbBuilder.create();
        this.master=master;
    }

    public Object[] getClickInfo(Game game){
        /*String event = in.nextLine();
        MouseEvent e = jsonb.fromJson(event, MouseEvent.class);
        System.out.println(e);*/

        if(game instanceof ChineseCheckers){
            while(!in.hasNextLine());

            double x = Double.parseDouble(in.nextLine());

            while(!in.hasNextLine());

            double y = Double.parseDouble(in.nextLine());

            Object[] array = {x,y};

            return array;
        }
        else
        {
            return new Object[0];
        }
    }

    public int startGame(Game game){

        System.out.println("Started");

        out.println("Start");

        for(int i=0; i<game.board.fields.length; i++)
        {
            for(int j=0; j<game.board.fields[0].length; j++)
            {
                //System.out.println(i);
                //System.out.println(j);
                if(game.board.fields[i][j]!=null)
                {
                    out.println(App.codeFigure(game.board.fields[i][j].shape));
                }

            }
        }

        out.println("end");

        ArrayList<Shape> playerData=game.getPlayerData();
        for(Shape shape : playerData){
            this.sendData(App.codeFigure(shape));
        }

        //String data=jsonb.toJson(Lboard);

        out.println("end");

        //System.out.println(data);

        return 1;
    }

    public void setGameOver(boolean status){
        this.gameOver=status;
    }

    public void sendData(String data){
        out.println(data);
    }

    public void startRound(){
        out.println("Your turn");
        System.out.println("Round started");
    }

    public void endRound(){
        out.println("Round over");
    }

    public void run(){
        try{
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String data="";
                while(!in.hasNextLine()){
                    data="";
                }
                data=in.nextLine();
                System.out.println(data);

                if(data.equals("START GAME"))
                {
                    //System.out.println(data);
                    String gameName=in.nextLine();
                    System.out.println(gameName);
                    String playerAm=in.nextLine();
                    System.out.println(playerAm);

                    if(master.newGame(gameName, playerAm, this)==1)
                    {
                        System.out.println("Ur waiting in a queue");
                        out.println("Ur waiting in a queue");
                        while(!gameOver) {}
                        gameOver=false;
                    }
                    else{
                        out.println("Wrong playerAm");
                    }
                }
            }



        }
        catch (Exception e){

        }
    }
}
