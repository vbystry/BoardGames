package hwdp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{
    private final JComboBox<String> choiceofgame;
    private final JComboBox<String> amofplayers;
    private final JButton button;
    private int players;
    private String gamename;
    private JLabel message;
    protected Menu(){
        super("Menu");
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
                switch (selected){
                    case "Chinese Checkers":
                        gamename = selected;

                        break;

                    default:
                        break;
                }

            } else if(button.equals(source)){
                play(players, gamename);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    private void play(int players, String game){
        GameFrame frame = new GameFrame(game);

    }
}
