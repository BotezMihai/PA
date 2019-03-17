import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Main {
    public static void main(String[] args)  throws IOException {
       Catalog catalog = new Catalog("d:/graphs");
       /*
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
        */
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

      while(true)
      {

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
          if(commandLine.matches("add[ ]*\\\"[a-zA-Z0-9]+\\\"\\,[ ]*\\\"[a-zA-Z0-9]+\\\"[ ]*\\,[ ]*\\\"[a-zA-Z0-9]+\\\"[ ]*\\,[ ]*\\\"[a-zA-Z0-9]+\\\""))
              {   String name=new String();
                String smthAbout=new String();
                String description=new String();
                String imageLocation=new String();
                 String[] values=commandLine.split(",");
                 int firstPosition=values[0].indexOf("\"");
                 name=values[0].substring(firstPosition+1,values[0].length()-1);
                 smthAbout=values[1].substring(1,values[1].length()-1);
                 description=values[2].substring(1,values[2].length()-1);
                 imageLocation=values[3].substring(1,values[3].length()-1);
                  //System.out.println(name+smthAbout+description+imageLocation);
                  new AddCommand(name,smthAbout,description,imageLocation);
          }


      }
    }
}