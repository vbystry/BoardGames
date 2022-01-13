package hwdp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JComboBox choiceofgame;
    private JComboBox amofplayers;
    private JButton button;
    private int players;
    private JLabel message;
    protected Menu(){
        super("Menu");
        setSize(300, 150);
        choiceofgame = new JComboBox();
        choiceofgame.addItem("Chinese Checkers");
        amofplayers = new JComboBox();
        amofplayers.addItem("2");
        amofplayers.addItem("4");
        amofplayers.addItem("6");
        button = new JButton("Play");


        add(button);
        add(choiceofgame);
        add(amofplayers);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    private void actionPerformed(ActionEvent e){
        try {
            String selected = choiceofgame.getSelectedItem().toString();
            Object source = e.getSource();

            if(button.equals(source)){

            } else if(choiceofgame.equals(source)){
                switch (selected){
                    case "Chinese Checkers":

                        break;

                    default:
                        break;
                }

            } else if(amofplayers.equals(source)){
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
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
