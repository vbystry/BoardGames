package hwdp;

import java.util.ArrayList;

public class ChineseCheckersBoard extends Board{
    private final double initx = 130;
    private final double inity = 10;
    private double ix, iy;
    final private int mycdiameter = 50;
    final private int standarddis = 10;
    @Override
    public void generateBoard(){
        this.fields = new MyShape[25][17];
        ix = initx;
        iy = inity;
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 25; j++){
                if(j % 2 == 0) {
                    fields[j][i] = new MyShape(this.convertCoordX(j, i), this.convertCoordY(i), mycdiameter, mycdiameter);
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

    }

    @Override
    public void setPawns(ArrayList<Pawn> pawns, int playeram) {

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
