package commands;

import catalog.Catalog;

public class LoadCommand extends Command {
    private String catalogName;

    public LoadCommand(String catalogName) {
        this.catalogName = catalogName;
    }

    public void doCommand(Catalog catalog) {
        catalog.load(catalogName);
    }
}
