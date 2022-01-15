package hwdp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Menu extends JFrame implements ActionListener{
    private final JComboBox<String> choiceofgame;
    private final JComboBox<String> amofplayers;
    private final JButton button;
    protected GameFrame frame;
    private int players;
    private String gamename;
    private JLabel message;
    String serverAddress;
    private Scanner in;
    private PrintWriter out;


    /*private void run() throws IOException {
        try {
            var socket = new Socket(serverAddress, 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e){
            e.printStackTrace();

        }
    }*/
    protected Menu(String serverAddress){
        super("Menu");
        this.serverAddress=serverAddress;

        try {
            var socket = new Socket(serverAddress, 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (Exception e){
            e.printStackTrace();

        }
        finally {
            setSize(300, 150);
            choiceofgame = new JComboBox<>();
            message = new JLabel();
            message.setText("Witaj w menu wyboru gier, wybierz gre, ilosc graczy, a nstepnie prazycisk Play");
            choiceofgame.addItem("Chinese Checkers");
            choiceofgame.addItem("Other game in the future");
            amofplayers = new JComboBox<String>();
            amofplayers.addItem("2");
            amofplayers.addItem("4");
            amofplayers.addItem("6");
            button = new JButton("Play");
            button.addActionListener(this);
            choiceofgame.addActionListener(this);
            amofplayers.addActionListener(this);

            add(button);
            add(choiceofgame);
            add(amofplayers);
            setLayout(new FlowLayout());
            setDefaultCloseOperation(3);
            setVisible(true);
        }

    }

    public void actionPerformed(ActionEvent e){
        try {
            String selected = choiceofgame.getSelectedItem().toString();
            Object source = e.getSource();

            if(amofplayers.equals(source)){
                switch (selected){
                    case "2":

                        players = 2;
                        break;
                    case "4":
                        players = 4;
                        break;
                    case "6":
                        players = 6;
                }
            } else if(choiceofgame.equals(source)){
                        gamename = selected;

            } else if(button.equals(source)){
                System.out.println("START GAME");
                out.println("START GAME");
                out.println("Chinese Checkers");
                out.println("2");
                this.play(players, gamename);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    private void play(int players, String game){
        String data="";

        while(!data.equals("Start"))
        {
            if(in.hasNextLine())
            {
                data=in.nextLine();
                System.out.println(data);
            }

        }

        //System.out.println(data);

        frame = new GameFrame(game, in, out);

    }
}
