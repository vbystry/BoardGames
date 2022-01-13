package hwdp;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;
import java.net.Socket;
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

    public MouseEvent getClickInfo(){
        String event = in.nextLine();
        MouseEvent e = jsonb.fromJson(event, MouseEvent.class);
        return e;
    }

    public int startGame(Game game){
        ArrayList<Shape> Lboard = new ArrayList<Shape>();

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
                    Lboard.add(game.board.fields[i][j].shape);
                }

            }
        }

        String data=jsonb.toJson(Lboard);

        out.println(data);

        System.out.println(data);

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
    }

    public void endRound(){
        out.println("Round over");
    }

    public void run(){
        try{
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String data;
                data=in.nextLine();

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
