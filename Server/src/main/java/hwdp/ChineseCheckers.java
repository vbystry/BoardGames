package hwdp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ChineseCheckers extends Game{

    private static final double initx = 130;
    private static final double inity = 10;
    //private static double ix, iy;
    final static private int mycdiameter = 50;
    final static private int standarddis = 10;
    private boolean startFlag=false;

    ChineseCheckers(int playerAm){      //nie wiem czy tu nie bedzie problem, tzn czy w super beda sie wywolwyaly metody nadpisane czy nie

        super(playerAm);

        this.playerAm=playerAm;
        this.createPawns(playerAm);
        this.createBoard();
        this.players = new ArrayList<Player>();
    }

    @Override
    protected int Round() {
        int PlayerNo=0;
        while(Queue(PlayerNo)>0)
        {
            PlayerNo++;
            PlayerNo%=this.playerAm;
        }
        return 1;
    }

    @Override
    protected int Queue(int PlayerNo) {
        int queueFlag=1;
        this.players.get(PlayerNo).startRound();
        System.out.println("Powinno wystartowac u: " + (PlayerNo+1));
        while(queueFlag>0)
        {
            //oczekiwanie i pobieranie e od klienta
            MouseEvent e = players.get(PlayerNo).getClickInfo();
            if(HandleClickInfo(e, PlayerNo)>0)  {players.get(PlayerNo).sendData(this.getPlayerData());}
            if(checkWinnig(PlayerNo))   {return 0;}
        }
        this.players.get(PlayerNo).endRound();
        return 1;
    }

    private boolean checkWinnig(int PlayerNo){
        //Do zaimplementowania
        return false;
    }

    @Override
    protected void createPawns(int numofplayers) {
        this.pawns = new ArrayList<Pawn>();
        int mid, left, right;
        int[] pos = new int[2];
        double[] convpos;
        if(numofplayers == 2 || numofplayers == 4 || numofplayers == 6){

                //north corner

                mid = 12;
                left = mid;
                right = mid;
                for (int y = 0; y < 4; y++) {
                    for (int x = left; x <= right; x += 2) {

                        //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                        try {
                            pos[0] = x;
                            pos[1] = y;
                            convpos = covertCoords(pos, "Pawn");
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 2));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(y == 0 || y == 2){
                        right += 2;
                    }
                    if(y == 1){
                        left -= 2;
                    }
                }

                //south corner

                left = mid;
                right = mid;
                for (int y = 16; y > 12; y--) {
                    for (int x = left; x <= right; x += 2) {

                        //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                        try {
                            pos[0] = x;
                            pos[1] = y;
                            convpos = covertCoords(pos, "Pawn");
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(y == 16 || y == 14){
                        right += 2;
                    }
                    if(y == 15){
                        left -= 2;
                    }
                }

        }

        if(numofplayers == 4 || numofplayers == 6){
            //north east corner

            mid = 22;
            left = mid;
            right = mid;
            for (int y = 9; y < 13; y++) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        pawns.add(new ChineseCheckersPawn(pos, convpos, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(y == 9 || y == 11){
                    left -= 2;
                }
                if(y == 10){
                    right += 2;
                }
            }

            //south west corner

            mid = 4;
            left = mid;
            right = mid;
            for (int y = 9; y < 13; y++) {

                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        pawns.add(new ChineseCheckersPawn(pos, convpos, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (y == 9 || y == 11) {
                    left -= 2;
                }
                if (y == 10) {
                    right += 2;
                }

            }

        }
        if(numofplayers == 6){

            //south east corner

            mid = 22;
            left = mid;
            right = mid;
            for (int y = 7; y >= 4; y--) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        pawns.add(new ChineseCheckersPawn(pos, convpos, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(y == 7 || y == 5){
                    left -= 2;
                }
                if(y == 6){
                    right += 2;
                }
            }

            //north west corner

            mid = 4;
            left = mid;
            right = mid;
            for (int y = 7; y >= 4; y--) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        pawns.add(new ChineseCheckersPawn(pos, convpos, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(y == 7 || y == 5){
                    left -= 2;
                }
                if(y == 6){
                    right += 2;
                }
            }
        }

    }

    @Override
    protected void createBoard() {
        this.board = new ChineseCheckersBoard();
        this.board.setPawns(pawns);
    }

    public void addPlayer(Player player){       //tu
        this.players.add(player);
        System.out.println("Dodano gracza");
        /*if(this.players.size()==(this.playerAm))        //to powinno byc w run ale sie cos pierdoli
        {
            for(Player P : this.players){
                System.out.println("wystartowało u nowego huja");
                P.startGame(this);      //problem z synchronizacja
            }
            this.startFlag=true;
        }*/
    }

    @Override
    protected int HandleClickInfo(MouseEvent e, int playerNo) {   //1- kontynuujemy runde, 0- koniec
        if(activePawn != null)
        {
            if(activePawn.shape.contains(e.getPoint()))
            {
                return 0;
            }
            else
            {
                for(Field possibleMove : actualPossibleMoves) {
                    if (possibleMove.shape.contains(e.getPoint())) {
                        movePawn(activePawn, possibleMove.getPosition());
                        return 1;
                    }
                }
            }

        }
        else
        {
            for(Pawn P : pawns)
            {
                if (P.shape.contains(e.getPoint()) && P.getPlayerNo() == playerNo) {
                    activePawn = P;
                    return 1;
                }
            }
        }
        return 1;
    }

    @Override
    protected void movePawn(Pawn P, int[] position) {
        P.move(position);
    }


    public static double[] covertCoords(int[] coords, String type) {
        if(type.equals("Pawn"))
        {
            return pawnCoordsConv(coords);
        }
        else if(type.equals("Field"))
        {
            return fieldCoordsConv(coords);
        }
        else
        {
            return new double[0];
        }
    }

    private static double[] pawnCoordsConv(int[] coords){
        double[] converted = new double[2];

        if(coords[0] % 2 == 0){
            converted[1] = initx + (coords[0]/2) * (mycdiameter + standarddis)+3;   //zmienic +3 XD dalem losowo
        } else {
            converted[1] = initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis)+3;
        }

        /* Czy nie lepiej tak:
         * if(type.equals("Pawn") {converted[1]+=3;}
         */

        converted[0] = inity + coords[1] * mycdiameter +3;

        return converted;
    }

    public static double[] fieldCoordsConv(int[] coords){
        double[] converted = new double[2];

        if(coords[0] % 2 == 0){
            converted[0] = initx + (coords[0]/2) * (mycdiameter + standarddis);
        } else {
            converted[0] = initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis);
        }

        converted[1] = inity + coords[1] * mycdiameter;

        return converted;
    }

    @Override
    public void run() {
        System.out.println("rozpoczynam run");
        while(this.playerAm>players.size())
        {
            System.out.println(playerAm + " , " + players.size());      //nie wiem jak zrobic pusta petle XD

        }

        //while(!startFlag){}

        for(Player player : players){
            player.startGame(this);
         //   player.sendData(getPlayerData());
            System.out.println("kolejny gracz ma odpalone");
        }

        int playerNo=0;
        System.out.println("startujemy rundke");
        Round();

        for(Player player : players){
            player.setGameOver(true);
        }
    }
}
