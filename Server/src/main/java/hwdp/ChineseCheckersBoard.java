package hwdp;

import java.awt.*;
import java.util.ArrayList;

/**
 *Klasa rozszerzajaca plansze do planszy warcabow chinskich
 * @author Piotr Korycki
 * @author Mateusz Bystronski
 */
public class ChineseCheckersBoard extends Board{
    /**
     * wspolrzedna x pierwszego pola planszy
     */
    private final double initx = 130;       //jak starczy czasu: zrobic gety do tych pol i uzywac ich w Game
    /**
     * wspolrzedna y pierwszego pola planszy
     */
    private final double inity = 10;
    private double ix, iy;
    /**
     * srednica standardowego pola planszy
     */
    final private int mycdiameter = 50;
    /**
     * standardowy dystans dzielacy 2 sasiadujace pola w osi horyzontalnej
     */
    final private int standarddis = 10;

    /**
     * konstruktor wywolujacy metode inicjalizacyjna
     */
    ChineseCheckersBoard(){

        super();

        this.generateBoard();
    }

    /**
     * metoda generujaca pola
     * strategia to stworz macierz figur, a nastepnie usun niepotrzebne pola i uformuj gwiazde
     * dla wybranych pozycji w macierzy dodawane sa pola o przekonwertowanych wspolrzednych
     */
    @Override
    public void generateBoard(){
        this.fields = new Field[25][17];
        ix = initx;
        iy = inity;
        for(int i = 0; i < 17; i++){
            for(int j = 0; j < 25; j++){
                if((i%2 ==0 && j%2==0) || i%2 == 1 && j%2 == 1) {
                    int[] position = {j, i};
                    fields[j][i] = new ChineseCheckersField(new MyShape(this.convertCoordX(j, i), this.convertCoordY(i), mycdiameter, mycdiameter,new Color(10,70,30)), position);
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
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j += 2) {
                fields[j][i] = null;
            }
        }
        for(int i = 1; i < 11; i+=2){
            fields[i][1] = null;
        }
        for(int i = 1; i < 9; i+=2){
            fields[i][3] = null;
        }
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < 10; j += 2) {
                fields[j][i] = null;
            }
        }
        //lewy dolny rog
        for (int i = 13; i < 15; i++) {
            for (int j = 0; j < 10; j += 2) {
                fields[j][i] = null;
            }
        }
        for(int i = 1; i < 11; i+=2){
            fields[i][15] = null;
        }
        for(int i = 1; i < 9; i+=2){
            fields[i][13] = null;
        }
        for (int i = 15; i < 17; i++) {
            for (int j = 0; j < 12; j += 2) {
                fields[j][i] = null;
            }
        }
        //prawy gorny rog
        for (int i = 14; i < 25; i += 2) {
            fields[i][0] = null;
        }
        for (int i = 16; i < 25; i += 2) {
            fields[i][1] = null;
        }
        for (int i = 16; i < 25; i += 2) {
            fields[i][2] = null;
        }
        for (int i = 18; i < 25; i += 2) {
            fields[i][3] = null;
        }
        for(int i = 15; i < 25; i+=2){
            fields[i][1] = null;
        }
        for(int i = 17; i < 25; i+=2){
            fields[i][3] = null;
        }
        //prawy dolny rog
        for (int i = 14; i < 25; i += 2) {
            fields[i][16] = null;
        }
        for (int i = 16; i < 25; i += 2) {
            fields[i][15] = null;
        }
        for (int i = 16; i < 25; i += 2) {
            fields[i][14] = null;
        }
        for (int i = 18; i < 25; i += 2) {
            fields[i][13] = null;
        }
        for(int i = 17; i < 25; i+=2){
            fields[i][13] = null;
        }
        for(int i = 15; i < 25; i+=2){
            fields[i][15] = null;
        }
        //usuniecie lewej strony
        int i = 5;
        while (i < 12) {
            fields[0][i] = null;
            i++;
        }
        i = 7;
        while (i < 10) {
            fields[2][i] = null;
            i++;
        }
        fields[1][7] = null;
        fields[1][9] = null;
        //usuniecie prawej strony
        i = 6;
        while (i < 11) {
            fields[24][i] = null;
            i++;
        }
        fields[23][7] = null;
        fields[23][9] = null;
        fields[22][8] = null;

        //System.out.println(fields[0][0].toString());

    }

    /**
     * metoda przyporzadkowujaca wybranym polom liste pionkow, ktore powinny znajdowac sie w polu
     * @param pawns lista pionkow znajdujacych sie na planszy
     */
    @Override
    public void setPawns(ArrayList<Pawn> pawns) {
        for(Pawn P : pawns)
        {
            this.fields[P.getPosition()[0]][P.getPosition()[1]].addPawn(P);
        }
    }

    /**
     * metoda zwracajaca liste pol, na ktore moze przemiescic sie wybrany pionek
     * @param pawn pionek, dla ktorego wyszukujemy mozliwych ruchow
     * @param moveNo
     * @return lista pol, na ktore mozna przemiescic pionka
     */
    @Override
    public ArrayList<Field> getPossibleMoves(Pawn pawn, int moveNo) {   //pewnie o czyms i tak zapomnialem
        ArrayList<Field> returnList = new ArrayList<Field>();

        if( ((ChineseCheckersPawn) pawn).lastPosition.size()>0 ){
            for(int[] lastP : ((ChineseCheckersPawn) pawn).lastPosition)
            {
                //wywalac kiedy wrocimy na poczatkowa (w pawn)
                returnList.add(this.fields[lastP[0]][lastP[1]]);
            }
        }

        returnList.remove(pawn.position);


        for(int i=0; i<6; i++)
        {
            int[] xy= pawn.getPosition().clone();

            int dx=pawn.possibleMoves[i][1];
            int dy=pawn.possibleMoves[i][0];

            int counter=1;  //uu licze od 1
            int pawnCounter=0;
            boolean out=false;

            xy[0]+=dx;
            xy[1]+=dy;

            while(!out && xy[0]<25 && xy[1]<17 && xy[0]>0 && xy[1]>0 && this.fields[xy[0]][xy[1]] != null )
            {
                if(counter==1) {
                    if (this.fields[xy[0]][xy[1]].getPawns().size() > 0) {
                        pawnCounter = 1;
                        //out=true;
                    }
                    //double[] coords = ChineseCheckers.covertCoords(xy, "Field")
                    else {
                        if(moveNo==1){
                            //((ChineseCheckersPawn) pawn).jumpFlag=false;
                            returnList.add(this.fields[xy[0]][xy[1]]);    //dopilnowac kolejnosc kordow, zmienic dlugosc i szerokosc
                        }
                        //System.out.println(App.codeFigure(returnList.get(returnList.size() - 1).getShape()));

                    }
                }
                else
                {
                    if(this.fields[xy[0]][xy[1]].getPawns().size()>0)
                    {
                        if(pawnCounter==0)
                        {
                            pawnCounter=counter;
                        }
                        else    //nie mozemy skakac przez 2 pionki
                        {
                            pawnCounter=0;
                            break;
                        }
                    }
                    else if(counter-pawnCounter == pawnCounter && ((ChineseCheckersPawn) pawn).jumpFlag)
                    {
                        //double[] coords = ChineseCheckers.covertCoords(xy, "Field");
                        returnList.add(this.fields[xy[0]][xy[1]]);
                        System.out.println(App.codeFigure(returnList.get(returnList.size()-1).getShape()));
                    }
                }
                counter++;
                xy[0]+=dx;
                xy[1]+=dy;
            }
        }
        return returnList;
    }

    /**
     * metoda konwertujaca wspolrzedna x z pozycji w macierzy na wektor pikseli w panelu
     * @param x pierszy indeks w macierzy
     * @param y drugi indeks w macierzy
     * @return przekonwertowana wspolrzedna
     */
    @Override
    public double convertCoordX(int x, int y) {

        if(y % 2 == 0){
            return initx + (x/2) * (mycdiameter + standarddis);
        } else {
            return initx - ((mycdiameter + standarddis) / 2) + (x/2) * (mycdiameter + standarddis) + 60;
        }
    }

    /**
     * metoda konwertujaca wspolrzedna y z pozycji w macierzy na wektor pikseli w panelu
     * @param y drugi indeks w macierzy
     * @return przekonwertowana wspolrzedna
     */
    @Override
    public double convertCoordY(int y){
        return inity + y * mycdiameter;
    }



}
