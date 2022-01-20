package hwdp;

import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * klasa obslugujaca serwer
 * @author  Mateusz Bystronski
 * @author Piotr Korycki
 */
public class App
{
    // All client names, so we can check for duplicates upon registration.
    /**
     * uporzadkowany zbior klientow (wyklucza powtorzenia)
     */
    //private static Set<String> names = new HashSet<>();
    /**
     * lista gier obslugiwanych przez serwer
     */
    private ArrayList<Game> games = new ArrayList<Game>();

    // The set of all the print writers for all the clients, used for broadcast.
    /**
     * zbior elementow wyjscia
     */
    //private static Set<PrintWriter> writers = new HashSet<>();

    /**
     *
     * @param Name nazwa gry
     * @param playerAm liczba graczy
     * @param caller
     * @return
     */
    public int newGame(String Name, String playerAm, Player caller){
        switch (Name){
            case "Chinese Checkers":
                try{
                    int playersNum= Integer.parseInt(playerAm);
                    //checking valid playerAm
                    if(playersNum==2 || playersNum==3 || playersNum==6){
                        for(Game game : this.games){
                            if(game.playerAm==playersNum && game instanceof ChineseCheckers && game.playerAm>game.players.size())    //spr czy gra ruszyla
                            {
                                game.addPlayer(caller);
                                return 1;
                            }
                        }
                        System.out.println("Dodano gre");
                        this.games.add(new ChineseCheckers(playersNum));
                        this.games.get(this.games.size()-1).addPlayer(caller);
                        this.games.get(this.games.size()-1).run();
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                    return 0;
                }
        }
        return 1;
    }

    /**
     * metoda kodujaca ksztalt w format mozliwy dio przeslania
     * @param shape kodowany ksztalt
     * @return zakodowany obiekt
     */
    public static String codeFigure(Shape shape){
        if(shape instanceof MyShape){
            return "MyShape" + "$"+ String.valueOf(((MyShape) shape).x) + "$"+ String.valueOf(((MyShape) shape).y)+ "$"+ String.valueOf(((MyShape) shape).width)+ "$" +String.valueOf(((MyShape) shape).height) +"$" + ((MyShape) shape).color.toString()+ "$";
        }
        else
        {
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("The game server is running...");
        App master = new App();
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
            while (true) {
                pool.execute(new Player(listener.accept(), master));
            }
        }
    }
}
