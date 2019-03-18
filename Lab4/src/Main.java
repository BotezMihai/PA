import catalog.Catalog;
import catalog.Graph;
import commands.*;
import exceptions.WrongCommandFormatException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Catalog catalog = new Catalog("catalog");
        ArrayList<Catalog> catalogs = new ArrayList<>();
        catalogs.add(catalog);

        catalog.add(new Graph("K4", "complete/k4.tgf", "complete/view/k4.png"));
        catalog.add(new Graph("Petersen", "special/petersen.tgf", "petersen.png"));

        /*
        catalog.open("Petersen");

        catalog.save("catalog.ser");

        Catalog catalogLoaded = new Catalog("d:/graphs");
        catalogLoaded.load("catalog.ser");

        System.out.println("Catalog loaded below.");
        catalogLoaded.list();

        System.out.println("Catalog below.");
        catalog.list();
        */
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.print("shell > ");
            commandLine = console.readLine();
            if (commandLine.equals(""))
                continue;
            if (commandLine.equals("help")) {
                Command.help();
                continue;
            }
            if (commandLine.equals("exit")) {
                break;
            }
            if (commandLine.matches("add[ ]*\\\"[a-zA-Z0-9]+\\\"\\,[ ]*\\\"[a-zA-Z0-9]+\\\"[ ]*\\,[ ]*\\\"[a-zA-Z0-9]+\\\"[ ]*\\,[ ]*\\\"[a-zA-Z0-9]+\\\"")) {
                String[] values = commandLine.split(",");
                int firstPosition = values[0].indexOf("\"");
                String name = values[0].substring(firstPosition + 1, values[0].length() - 1);
                String smthAbout = values[1].substring(2, values[1].length() - 1);
                String description = values[2].substring(2, values[2].length() - 1);
                String imageLocation = values[3].substring(2, values[3].length() - 1);
                //System.out.println(name + smthAbout + description + imageLocation);

                // added the graph in the catalog
                AddCommand addCommand = new AddCommand(name, smthAbout, description, imageLocation);
                addCommand.doCommand(catalog);
            }

            if (commandLine.matches("save[ ]*[a-zA-Z0-9]+")) {
                String[] values = commandLine.split(" ");
                String name = values[1];

                SaveCommand saveCommand = new SaveCommand(name);
                saveCommand.doCommand(catalog);
            }

            if (commandLine.matches("list[ ]*[a-zA-Z0-9]+")) {
                String[] values = commandLine.split(" ");
                String name = values[1];

                for (Catalog aCatalog : catalogs) {
                    if (aCatalog.getFilename().equals(name)) {
                        ListCommand listCommand = new ListCommand();
                        listCommand.doCommand(aCatalog);
                    }
                }


            }

            if (commandLine.matches("load[ ]*[a-zA-Z0-9]+")) {
                String[] values = commandLine.split(" ");
                String name = values[1];
                Catalog newCatalog = new Catalog("newCatalog");

                for (Catalog aCatalog : catalogs) {
                    if (aCatalog.getFilename().equals(name)) {

                        LoadCommand loadCommand = new LoadCommand(name);
                        loadCommand.doCommand(newCatalog);
                    }
                }
            }

            if (commandLine.matches("open[ ]*[a-zA-Z0-9]+")) {
                String[] values = commandLine.split(" ");
                String name = values[1];


                for (Catalog aCatalog : catalogs) {
                    if (aCatalog.getFilename().equals(name)) {
                        OpenCommand openCommand = new OpenCommand();
                        openCommand.doCommand(catalog);
                    }
                }
            }

            if (commandLine.matches("report[ ]*html[ ]*[a-zA-Z0-9]+")) {
                String text = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                        "    <title>Report</title>\n" +
                        "</head>";

                text = text + "\n" + "<body>";
                String[] values = commandLine.split(" ");
                String name = values[2];

                for (Catalog aCatalog : catalogs) {
                    if (aCatalog.getFilename().equals(name)) {
                        String catalogName = "<h1>" + aCatalog.getFilename() + "</h1>";
                        text = text + catalogName;

                        for (Graph graph : aCatalog.getCatalog()) {
                            String graphName = "<p>Graph's name:" + graph.getName() + "</p>";
                            String description = "<p>Graph's description:" + graph.getDescription() + "</p>";
                            String definition = "<p>Graph's definition:" + graph.getDefinition() + "</p>";
                            String imageLocation = "<img src =\"" + graph.getImageLocation() + "\" alt=\"nimic\">";
                            text = text + "\n" + graphName + "\n" + description + "\n" + definition + "\n" + imageLocation;
                        }
                    }
                }

                text = text + "\n" + "</body></html>";
                File file = new File("report.html");
                if (!file.exists()) {
                    file.createNewFile();
                }

                BufferedWriter out = new BufferedWriter(new FileWriter("report.html"));

                try {
                    out.write(text);
                } catch (IOException e) {
                    System.out.println("Exception ");
                } finally {
                    out.close();
                }

            }

        }
    }
}