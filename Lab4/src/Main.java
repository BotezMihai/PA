/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("d:/graphs");
        catalog.add (new Graph("K4", "complete/k4.tgf", "complete/view/k4.png"));
        catalog.add (new Graph("Petersen", "special/petersen.tgf", "d:/ag/test.jpg"));
        catalog.open("Petersen");
    }
}
