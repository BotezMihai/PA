package commands;

import catalog.Catalog;

public class SaveCommand extends Command{
    private String catalogName;

    public SaveCommand(String catalogName) {
        this.catalogName = catalogName;
    }

    public void doCommand(Catalog catalog) {
        catalog.save(this.catalogName);
    }
}
