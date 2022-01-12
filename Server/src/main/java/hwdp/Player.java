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
    //private Game game;

    private Socket socket;
    private Scanner in;
    private PrintWriter out;
    private Jsonb jsonb;

    Player(Socket socket){
        this.socket=socket;
        this.jsonb=JsonbBuilder.create();
    }

    private MouseEvent getClickInfo(){
        String event = in.nextLine();
        MouseEvent e = jsonb.fromJson(event, MouseEvent.class);
        return e;
    }

    public void startGame(Game game){
        ArrayList<Shape> board;

        for

    }

    public void run(){
        try{

        }
        catch (Exception e){

        }
    }
}
