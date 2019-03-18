package commands;

import catalog.Catalog;

public class ListCommand extends Command{

    public void doCommand(Catalog catalog) {
        catalog.list();
    }

}
