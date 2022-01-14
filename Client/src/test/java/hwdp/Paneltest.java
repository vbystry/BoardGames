package hwdp;

import org.junit.Test;

import java.io.PrintWriter;
import java.util.Scanner;

public class Paneltest {
    @Test
    public void paneltest() {

    Scanner scan = new Scanner(System.in);
    PrintWriter pr = new PrintWriter(System.out);
    GamePanel panel = new GamePanel(scan, pr);
    }
}
