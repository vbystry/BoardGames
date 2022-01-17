package hwdp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class ChineseCheckers extends Game{

    private static final double initx = 130;
    private static final double inity = 10;
    //private static double ix, iy;
    final static private int mycdiameter = 50;
    final static private int standarddis = 10;
    private boolean startFlag=false;
    private ArrayList<int[]>[] winningfields;
    private ArrayList<int[]>[] forbiddenfields;

    public ArrayList<int[]> getWinningfields(int pos){
        return winningfields[pos];
    }
    public ArrayList<int[]> getForbiddenFields(int pos){
        return forbiddenfields[pos];
    }



    ChineseCheckers(int playerAm){      //nie wiem czy tu nie bedzie problem, tzn czy w super beda sie wywolwyaly metody nadpisane czy nie

        super(playerAm);

        this.playerAm=playerAm;
        this.createPawns(playerAm);
        this.createBoard();
        this.players = new ArrayList<Player>();
        this.actualPossibleMoves=new ArrayList<Field>();
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
            Object[] clickCords = players.get(PlayerNo).getClickInfo(this);
            if(HandleClickInfo(clickCords, PlayerNo)>0)
            {
                //System.out.println();
                ArrayList<Shape> playerData=getPlayerData();
                for(Shape shape : playerData){
                    players.get(PlayerNo).sendData(App.codeFigure(shape));
                }
                players.get(PlayerNo).sendData("end");
                //queueFlag=0;
                //this.getPlayerData());
            }
            else{
                queueFlag=0;
            }
            //queueFlag=0;



            if(checkWinnig(PlayerNo))   {return 0;}
        }
        this.actualPossibleMoves.clear();

        ArrayList<Shape> playerData=getPlayerData();
        for(Shape shape : playerData){
            for(Player p : players){
                p.sendData(App.codeFigure(shape));
            }

        }
        for(Player p : players){
            p.sendData("end");
        }
        //players.get(PlayerNo).sendData("end");

        this.players.get(PlayerNo).endRound();
        ((ChineseCheckersPawn) activePawn).lastPosition.clear();
        activePawn=null;
        return 1;
    }

    private boolean checkWinnig(int PlayerNo){
        //Do zaimplementowania

        boolean winningFlag=true;

        for(Pawn p : pawns){
            if(p.playerNo==PlayerNo){
                if(!winningfields[PlayerNo].contains(p.position)){
                    winningFlag=false;
                }
            }
        }

        return winningFlag;
    }

    /**
     *
     * @param numofplayers
     */
    @Override
    protected void createPawns(int numofplayers) {
        winningfields = new ArrayList[7]; //winningfields[0] to null, indeksowanie zgodne z id gracza
        forbiddenfields = new ArrayList[7];
        this.pawns = new ArrayList<Pawn>();
        int mid, left, right;
        int[] pos = new int[2];
        double[] convpos;
        //int count = 0;
       // if(numofplayers == 2 || numofplayers == 4 || numofplayers == 6){

                //north corner

                mid = 12;
                left = mid;
                right = mid;
                winningfields[1] = new ArrayList<>();
                for(int i = 1; i < 7; i++){
                    forbiddenfields[i] = new ArrayList<>();
                }
                for (int y = 0; y < 4; y++) {
                    for (int x = left; x <= right; x += 2) {
                        if(numofplayers == 2 || numofplayers == 4 || numofplayers == 6) {
                            //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                            try {
                                pos[0] = x;
                                pos[1] = y;
                                //System.out.println("x: " + Integer.toString(pos[0]) + " y: " + Integer.toString(pos[1]));
                                //  System.out.println(" ");


                                convpos = covertCoords(pos, "Pawn");
                                if(numofplayers == 2 || numofplayers == 4 || numofplayers == 6 || numofplayers == 3) {
                                    pawns.add(new ChineseCheckersPawn(pos, convpos, 2));    //jesli prowadzimy rozgrywke dla dowolnej liczby graczy dodaj pionki gracza 2
                                }

                                winningfields[1].add(pos.clone());  //zawsze dodaj zwycieskie pionki gracza 2

                                forbiddenfields[3].add(pos.clone());        //zawsze dodaj zakazane pionki pozostalych graczy
                                forbiddenfields[4].add(pos.clone());
                                forbiddenfields[5].add(pos.clone());
                                forbiddenfields[6].add(pos.clone());

                                //System.out.println("x: " + Integer.toString(winningfields[1].get(count)[0]) + " y: " + Integer.toString(winningfields[1].get(count)[1]));

                                // count++;


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    left--;
                    right++;
                }
                /*for(int[] f : winningfields[1]){
                    System.out.println(Arrays.toString(f));
                }*/

                //south corner

                left = mid;
                right = mid;
                winningfields[2] = new ArrayList<>();
                for (int y = 16; y > 12; y--) {
                    for (int x = left; x <= right; x += 2) {

                        //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                        try {
                            pos[0] = x;
                            pos[1] = y;
                            convpos = covertCoords(pos, "Pawn");
                            if(numofplayers == 2 || numofplayers == 4 || numofplayers == 6) {
                                pawns.add(new ChineseCheckersPawn(pos, convpos, 1));
                            }
                            winningfields[2].add(pos.clone());

                            forbiddenfields[3].add(pos.clone());
                            forbiddenfields[4].add(pos.clone());
                            forbiddenfields[5].add(pos.clone());
                            forbiddenfields[6].add(pos.clone());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    left--;
                    right++;
                }

       // }

        //if(numofplayers == 4 || numofplayers == 6){
            //south east corner

            mid = 21;
            left = mid;
            right = mid;
            winningfields[4] = new ArrayList<>();
            for (int y = 9; y < 13; y++) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        if(numofplayers == 4 || numofplayers == 6 || numofplayers == 3) {
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 3));
                        }
                        winningfields[4].add(pos.clone());

                        forbiddenfields[2].add(pos.clone());
                        forbiddenfields[5].add(pos.clone());
                        forbiddenfields[6].add(pos.clone());
                        forbiddenfields[1].add(pos.clone());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                left--;
                right++;
            }
            //north west corner

            mid = 3;
            left = mid;
            right = mid;
            winningfields[3] = new ArrayList<>();
            for (int y = 7; y >= 4; y--) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        if(numofplayers == 4 || numofplayers == 6) {
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 4));
                        }
                        winningfields[3].add(pos.clone());

                        forbiddenfields[2].add(pos.clone());
                        forbiddenfields[5].add(pos.clone());
                        forbiddenfields[6].add(pos.clone());
                        forbiddenfields[1].add(pos.clone());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                left--;
                right++;
            }



        //}
       // if(numofplayers == 6){

            //south east corner

            mid = 21;
            left = mid;
            right = mid;
            winningfields[6] = new ArrayList<>();

            for (int y = 7; y >= 4; y--) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        if(numofplayers == 6) {
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 5));
                        }
                        winningfields[6].add(pos.clone());

                        forbiddenfields[2].add(pos.clone());
                        forbiddenfields[3].add(pos.clone());
                        forbiddenfields[4].add(pos.clone());
                        forbiddenfields[1].add(pos.clone());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                left--;
                right++;
            }

            //south west corner

            mid = 3;
            left = mid;
            right = mid;
            winningfields[5] = new ArrayList<>();

            for (int y = 9; y < 13; y++) {

                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        if(numofplayers == 6 || numofplayers == 3) {
                            pawns.add(new ChineseCheckersPawn(pos, convpos, 6));
                        }
                        winningfields[5].add(pos.clone());

                        forbiddenfields[2].add(pos.clone());
                        forbiddenfields[3].add(pos.clone());
                        forbiddenfields[4].add(pos.clone());
                        forbiddenfields[1].add(pos.clone());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                left--;
                right++;

            }
/*
            //north west corner

            mid = 3;
            left = mid;
            right = mid;
            for (int y = 7; y >= 4; y--) {
                for (int x = left; x <= right; x += 2) {

                    //System.out.println("x: " + Integer.toString(x) + " y: " + Integer.toString(y));
                    try {
                        pos[0] = x;
                        pos[1] = y;
                        convpos = covertCoords(pos, "Pawn");
                        pawns.add(new ChineseCheckersPawn(pos, convpos, 6));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                left--;
                right++;
            }*/
       // }

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
    protected int HandleClickInfo(Object[] info, int playerNo) {   //1- kontynuujemy runde, 0- koniec
        Point2D click=new Point2D.Double((double) info[0], (double) info[1]);
        if(activePawn != null)
        {

            if(activePawn.shape.contains(click))
            {
                if(forbiddenfields[playerNo].contains(activePawn.position.clone())){
                    if(((ChineseCheckersPawn)activePawn).outOfBase){
                        //players.get(playerNo).sendData("You cannot end here");
                        return 1;
                    }
                    else{
                        actualPossibleMoves.clear();
                        return 0;
                    }
                }
                else if(!((ChineseCheckersPawn)activePawn).outOfBase){
                    ((ChineseCheckersPawn)activePawn).outOfBase=true;
                    actualPossibleMoves.clear();
                    return 0;
                }
                else{
                    actualPossibleMoves.clear();
                    return 0;
                }
            }
            else
            {
                for(Field possibleMove : actualPossibleMoves) {
                    if (possibleMove.shape.contains(click)) {
                        movePawn(activePawn, possibleMove.getPosition());
                        actualPossibleMoves=board.getPossibleMoves(activePawn, ((ChineseCheckersPawn)activePawn).lastPosition.size()+1);
                        return 1;
                    }
                }
            }

        }
        else
        {
            for(Pawn P : pawns)
            {
                if (P.shape.contains(click) && P.getPlayerNo() == playerNo) {
                    activePawn = P;
                    System.out.println(activePawn);
                    actualPossibleMoves=board.getPossibleMoves(activePawn, 1);
                    //System.out.println(actualPossibleMoves);
                    for(Field field : actualPossibleMoves){
                        System.out.println(App.codeFigure(field.getShape()));
                    }
                    return 1;
                }
            }
        }
        return 1;
    }

    @Override
    protected void movePawn(Pawn P, int[] position) {
        board.fields[P.position[0]][P.position[1]].getPawns().remove(P);
        P.move(position);
        board.fields[P.position[0]][P.position[1]].getPawns().add(P);
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

        if(coords[1] % 2 == 0){
            converted[0] = initx + (coords[0]/2) * (mycdiameter + standarddis) + 8.5;   //zmienic +3 XD dalem losowo
        } else {
            converted[0] = (initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis)) + 8.5 + 60;
        }

        /* Czy nie lepiej tak:
         * if(type.equals("Pawn") {converted[1]+=3;}
         */

        converted[1] = inity + coords[1] * mycdiameter + 8.5;

        return converted;
    }

    public static double[] fieldCoordsConv(int[] coords){
        double[] converted = new double[2];

        if(coords[0] % 2 == 0){
            converted[0] = initx + (coords[0]/2) * (mycdiameter + standarddis);
        } else {
            converted[0] = initx - ((mycdiameter + standarddis) / 2) + (coords[0]/2) * (mycdiameter + standarddis) + 60;
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
