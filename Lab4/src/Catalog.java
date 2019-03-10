import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Catalog {
    private ArrayList<Graph> catalog = new ArrayList<>();
    private String filename;

    public void add(Graph graph){
        this.catalog.add(graph);
    }

    public void list(){
        for (Graph graph: catalog) {
            System.out.println(graph.toString());
        }
    }


    public void open(String imageName){
        try{
            Desktop desktop = Desktop.getDesktop();
            File image = new File(imageName);
            desktop.open(image);
        } catch (IOException e) {
            System.out.println("There was a problem opening the image.");
        }

    }





}
