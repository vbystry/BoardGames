package hwdp;

public class ChineseCheckersPawn extends Pawn{
    private status Status;

    public enum status {
        Normal,
        Winning
    }

    public ChineseCheckersPawn(int[] position, double[] convertedPosition, int playerNo){
        this.position= position;
        this.possibleMoves= new int[6][2];
        //zmienic x z y
        this.possibleMoves[0][0]=2;
        this.possibleMoves[0][1]=0;

        this.possibleMoves[1][0]=-2;
        this.possibleMoves[1][1]=0;

        this.possibleMoves[2][0]=1;
        this.possibleMoves[2][1]=1;

        this.possibleMoves[3][0]=1;
        this.possibleMoves[3][1]=-1;

        this.possibleMoves[4][0]=-1;
        this.possibleMoves[4][1]=1;

        this.possibleMoves[5][0]=-1;
        this.possibleMoves[5][1]=-1;

        int pawndiameter = 30;
        this.shape = new MyShape(convertedPosition[0], convertedPosition[1], pawndiameter, pawndiameter);    //ej jak ustawic status na active? xd
    }

    public void setStatus(status S) {
        this.Status=S;
    }

    public status getStatus(){
        return this.Status;
    }


}
