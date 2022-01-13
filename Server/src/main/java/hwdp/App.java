package hwdp;

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
 * Hello world!
 *
 */
public class App
{
    // All client names, so we can check for duplicates upon registration.
    private static Set<String> names = new HashSet<>();

    private ArrayList<Game> games = new ArrayList<Game>();

    // The set of all the print writers for all the clients, used for broadcast.
    private static Set<PrintWriter> writers = new HashSet<>();

    public int newGame(String Name, String playerAm, Player caller){
        switch (Name){
            case "Chinese Checkers":
                try{
                    int playersNum= Integer.parseInt(playerAm);
                    //checking valid playerAm
                    if(playersNum==2 || playersNum==3 || playersNum==6){
                        for(Game game : this.games){
                            if(game.playerAm==playersNum && game instanceof ChineseCheckers)
                            {
                                game.addPlayer(caller);
                                return 1;
                            }
                        }
                        System.out.println("Dodano gre");
                        this.games.add(new ChineseCheckers(playersNum));
                        this.games.get(this.games.size()-1).addPlayer(caller);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                    return 0;
                }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running...");
        App master = new App();
        var pool = Executors.newFixedThreadPool(500);
        try (var listener = new ServerSocket(59001)) {
            while (true) {
                pool.execute(new Player(listener.accept(), master));
            }
        }
    }
}
