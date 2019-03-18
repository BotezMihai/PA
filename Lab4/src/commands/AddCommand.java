package commands;

import catalog.Catalog;
import catalog.Graph;

public class AddCommand extends Command{
    private String name;
    private String smthAbout;
    private String description;
    private String imageLocation;

    public AddCommand(String name, String smthAbout, String description, String imageLocation) {
        this.name = name;
        this.smthAbout = smthAbout;
        this.description = description;
        this.imageLocation = imageLocation;
    }

    public void doCommand (Catalog catalog){
        catalog.add(new Graph(this.name,this.description,this.imageLocation));
    }

}
