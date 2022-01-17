package hwdp;

import java.util.ArrayList;

public class ChineseCheckersPawn extends Pawn{
    /**
     * Status kazdego z pionkow, w tym przypadku zwycieski oraz standardowy
     */
    private status Status;
    /**
     * lista
     */
    public ArrayList<int[]> lastPosition = new ArrayList<>();

    private int[][] winningFields;

    /**
     * wewnetrzna klasa typu enum reprezentujaca stany pionka
     */
    public enum status {
        /**
         * domyslny status pionka
         */
        Normal,
        /**
         * status pionka, ktory dostal sie w pole przeciwnika
         */
        Winning
    }

    /**
     * konstruktor pionka, przyporzadkowujacy mu jego polozenei w macierzy, polozenie w panelu, numer gracza, wielkosc, ksztalt oraz definiuje mozliwosci ruchu o konkretne wektory
     * @param position pozycja w macierzy
     * @param convertedPosition pozycja w panelu
     * @param playerNo numer gracza
     */
    public ChineseCheckersPawn(int[] position, double[] convertedPosition, int playerNo){
        this.position= position.clone();
        //this.lastPosition.add(position.clone());
        this.possibleMoves= new int[6][2];
        this.playerNo=playerNo-1;
        //zmienic x z y
        this.possibleMoves[0][1]=2;
        this.possibleMoves[0][0]=0;

        this.possibleMoves[1][1]=-2;
        this.possibleMoves[1][0]=0;

        this.possibleMoves[2][1]=1;
        this.possibleMoves[2][0]=1;

        this.possibleMoves[3][1]=1;
        this.possibleMoves[3][0]=-1;

        this.possibleMoves[4][1]=-1;
        this.possibleMoves[4][0]=1;

        this.possibleMoves[5][1]=-1;
        this.possibleMoves[5][0]=-1;

        int pawndiameter = 30;
        this.shape = new MyShape(convertedPosition.clone()[0], convertedPosition.clone()[1], pawndiameter, pawndiameter);    //ej jak ustawic status na active? xd
    }

    /**
     * metoda przemieszczajaca pionek z pierwotnej pozycji na nowa
     * @param position  docelowe polozenie w macierzy
     */
    @Override
    public void move(int[] position){
        //wywalac nie tylko przy powrocie na 1 (obcinac elementy o indexie wiekszym niz position)
        if(this.lastPosition.size()>0 && position[0]==this.lastPosition.get(0)[0] && position[1]==this.lastPosition.get(0)[1]){
            System.out.println("clear");
            this.lastPosition.clear();
        }
        else{
            this.lastPosition.add(this.position.clone());
        }

        this.position=position.clone();

        double[] convCords=ChineseCheckers.covertCoords(this.position, "Pawn");

        ((MyShape) shape).x=convCords[0];
        ((MyShape) shape).y=convCords[1];
    }

    /**
     * metoda zmieniajaca status pionka na wybrany (przydatny okaze sie raczej status zwycieski, ktore zostanie przyporzadkowany kazdemu pionkowi, ktory dotarl w pole przeciwnika
     * @param S wybrany status
     */
    public void setStatus(status S) {
        this.Status=S;
    }

    /**
     * metoda zwracajaca status pionka
     * @return status pionka
     */
    public status getStatus(){
        return this.Status;
    }


}
