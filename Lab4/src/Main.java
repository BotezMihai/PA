/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("d:/graphs");
        catalog.add(new Graph("K4", "complete/k4.tgf", "complete/view/k4.png"));
        catalog.add(new Graph("Petersen", "special/petersen.tgf", "petersen.png"));

        catalog.open("Petersen");

        catalog.save("catalog.ser");

        Catalog catalogLoaded = new Catalog("d:/graphs");
        catalogLoaded.load("catalog.ser");

        System.out.println("Catalog loaded below.");
        catalogLoaded.list();

        System.out.println("Catalog below.");
        catalog.list();
    }
}