import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Catalog {
    private ArrayList<Graph> catalog = new ArrayList<>();
    private String filename;

    public Catalog(String path)
    {
        filename=path;
    }
    public void add(Graph graph){
        this.catalog.add(graph);
    }

    public void list(){
        for (Graph graph: catalog) {
            System.out.println(graph.toString());
        }
    }


   public void open (String name)
   {
       String path=new String();
       for(Graph i: catalog)
       {
           if(name.equals(i.getName()))
                path=i.getImageLocation();

       }

       try{
           Desktop desktop = Desktop.getDesktop();
           File image = new File(path);
           desktop.open(image);
       } catch (IOException e) {
           System.out.println("There was a problem opening the image.");
       }


   }




}
