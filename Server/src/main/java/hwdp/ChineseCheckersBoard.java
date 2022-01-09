package hwdp;

public class ChineseCheckersBoard extends Board{
    public void generateBoard(){
        double ix = 130;
        double iy = 10;
        final int mycdiameter = 50;
        this.fields = new MyShape[25][17];

        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 25; j++){
                if(j % 2 == 0) {
                    fields[j][i] = new MyShape(ix, iy, mycdiameter, mycdiameter);
                    ix += 60;
                } else{
                    fields[j][i] = null;
                }
            }
            if(i % 2 == 0){
                ix = 100;
            } else{
                ix = 130;
            }
            iy += 50;
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
}
