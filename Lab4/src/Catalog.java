import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Catalog {
    private ArrayList<Graph> catalog = new ArrayList<>();
    private String filename;

    public Catalog(String path) {
        filename = path;
    }

    public Catalog(ArrayList<Graph> catalog, String filename) {
        this.catalog = catalog;
        this.filename = filename;
    }

    public ArrayList<Graph> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Graph> catalog) {
        this.catalog = catalog;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public void add(Graph graph) {
        this.catalog.add(graph);
    }

    public void list() {
        for (Graph graph : catalog) {
            System.out.println(graph.toString());
        }
    }


    public void open(String name) {
        String path = new String();
        for (Graph i : catalog) {
            if (name.equals(i.getName()))
                path = i.getImageLocation();

        }

        try {
            Desktop desktop = Desktop.getDesktop();
            File image = new File(path);
            desktop.open(image);
        } catch (IOException e) {
            System.out.println("There was a problem opening the image.");
            e.printStackTrace();
        }


    }

    public void save(String catalogName) {
        try {
            File file = new File(catalogName);
            if (!file.exists())
                file.createNewFile();

            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.catalog);
            out.writeObject(this.filename);
            out.close();
            fileOut.close();
            System.out.println("The catalog was saved in " + catalogName + ".");

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }

    public void load(String catalogName) {
        try {
            File file = new File(catalogName);
            if (!file.exists())
                file.createNewFile();
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Catalog newCatalog = new Catalog((ArrayList<Graph>) in.readObject(), (String) in.readObject());

            this.catalog = newCatalog.getCatalog();
            this.filename = newCatalog.getFilename();

            in.close();
            fileIn.close();
            System.out.println("The catalog was loaded succesfully.");

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }


}
