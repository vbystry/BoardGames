package hwdp;

import java.awt.*;
import java.util.ArrayList;

public class ChineseCheckersBoard extends Board{
    private final double initx = 130;       //jak starczy czasu: zrobic gety do tych pol i uzywac ich w Game
    private final double inity = 10;
    private double ix, iy;
    final private int mycdiameter = 50;
    final private int standarddis = 10;

    ChineseCheckersBoard(){
        super();
    }

    @Override
    public void generateBoard(){
        this.fields = new Field[25][17];
        ix = initx;
        iy = inity;
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 25; j++){
                if(j % 2 == 0) {
                    int[] position = {j, i};
                    fields[j][i] = new ChineseCheckersField(new MyShape(this.convertCoordX(j, i), this.convertCoordY(i), mycdiameter, mycdiameter), position);
                    //fields[j][i].shape = new MyShape(this.convertCoordX(j, i), this.convertCoordY(i), mycdiameter, mycdiameter);
                    //fields[j][i].position = {j, i};
                    //ix += (mycdiameter + standarddis);
                } else{
                    fields[j][i] = null;
                }
            }
            if(i % 2 == 0){
                //ix = initx - ((mycdiameter + standarddis) / 2);
            } else{
                //ix = initx;
            }
            //iy += mycdiameter;
        }
        //usuwanie czesci planszy
        //lewy gorny rog
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 12; j += 2){
                fields[j][i] = null;
            }
        }
        for(int i = 2; i < 4; i++){
            for(int j = 0; j < 10; j += 2){
                fields[j][i] = null;
            }
        }
        //lewy dolny rog
        for(int i = 13; i < 15; i++){
            for(int j = 0; j < 10; j += 2){
                fields[j][i] = null;
            }
        }
        for(int i = 15; i < 17; i++){
            for(int j = 0; j < 12; j += 2){
                fields[j][i] = null;
            }
        }
        //prawy gorny rog
        for(int i = 14; i < 25; i += 2){
            fields[i][0] = null;
        }
        for(int i = 16; i < 25; i += 2){
            fields[i][1] = null;
        }
        for(int i = 16; i < 25; i += 2){
            fields[i][2] = null;
        }
        for(int i = 18; i < 25; i += 2){
            fields[i][3] = null;
        }
        //prawy dolny rog
        for(int i = 14; i < 25; i += 2){
            fields[i][16] = null;
        }
        for(int i = 16; i < 25; i += 2){
            fields[i][15] = null;
        }
        for(int i = 16; i < 25; i += 2){
            fields[i][14] = null;
        }
        for(int i = 18; i < 25; i += 2){
            fields[i][13] = null;
        }
        //usuniecie lewej strony
        int i = 5;
        while(i < 12){
            fields[0][i] = null;
            i++;
        }
        i = 7;
        while(i < 10){
            fields[2][i] = null;
            i++;
        }
        //usuniecie prawej strony
        i = 6;
        while(i < 11){
            fields[24][i] = null;
            i++;
        }
        fields[22][8] = null;

    }

    @Override
    public void setPawns(ArrayList<Pawn> pawns) {
        for(Pawn P : pawns)
        {
            this.fields[P.getPosition()[0]][P.getPosition()[1]].addPawn(P);
        }
    }

    @Override
    public ArrayList<Field> getPossibleMoves(Pawn pawn, int moveNo) {   //pewnie o czyms i tak zapomnialem
        ArrayList<Field> returnList = new ArrayList<Field>();
        for(int i=0; i<6; i++)
        {
            int[] xy= pawn.getPosition();

            int dx=pawn.possibleMoves[i][1];
            int dy=pawn.possibleMoves[i][0];

            int counter=1;  //uu licze od 1
            int pawnCounter=0;

            while(this.fields[xy[0]][xy[1]] != null )
            {
                if(counter==1)
                {
                    if(this.fields[xy[0]][xy[1]].getPawns() != null)
                    {
                        pawnCounter=counter;
                    }
                    //double[] coords = ChineseCheckers.covertCoords(xy, "Field");
                    returnList.add(this.fields[xy[0]][xy[1]]);    //dopilnowac kolejnosc kordow, zmienic dlugosc i szerokosc
                }
                else
                {
                    if(this.fields[xy[0]][xy[1]].getPawns() != null)
                    {
                        if(pawnCounter==0)
                        {
                            pawnCounter=counter;
                        }
                        else    //nie mozemy skakac przez 2 pionki
                        {
                            pawnCounter=0;
                        }
                    }
                    else if(counter-pawnCounter == pawnCounter)
                    {
                        //double[] coords = ChineseCheckers.covertCoords(xy, "Field");
                        returnList.add(this.fields[xy[0]][xy[1]]);
                    }
                }
                counter++;
                xy[1]+=dx;
                xy[0]+=dy;
            }
        }
        return returnList;
    }

    @Override
    public double convertCoordX(int x, int y) {

        if(y % 2 == 0){
            return initx + (x/2) * (mycdiameter + standarddis);
        } else {
            return initx - ((mycdiameter + standarddis) / 2) + (x/2) * (mycdiameter + standarddis);
        }
    }

    @Override
    public double convertCoordY(int y){
        return inity + y * mycdiameter;
    }



}
