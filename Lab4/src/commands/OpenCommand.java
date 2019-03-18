package commands;

import catalog.Catalog;

public class OpenCommand extends Command{
    public void doCommand(Catalog catalog){
        catalog.open(catalog.getFilename());
    }
}
