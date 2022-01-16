package hwdp;

import java.util.ArrayList;

public class ChineseCheckersPawn extends Pawn{
    private status Status;
    public ArrayList<int[]> lastPosition = new ArrayList<>();

    public enum status {
        Normal,
        Winning
    }

    public ChineseCheckersPawn(int[] position, double[] convertedPosition, int playerNo){
        this.position= position.clone();
        this.lastPosition.add(position.clone());
        this.possibleMoves= new int[6][2];
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

    @Override
    public void move(int[] position){
        this.lastPosition.add(this.position.clone());
        this.position=position.clone();

        double[] convCords=ChineseCheckers.covertCoords(this.position, "Pawn");

        ((MyShape) shape).x=convCords[0];
        ((MyShape) shape).y=convCords[1];
    }

    public void setStatus(status S) {
        this.Status=S;
    }

    public status getStatus(){
        return this.Status;
    }


}
