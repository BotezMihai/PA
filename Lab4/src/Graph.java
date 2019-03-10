/**
 * @author Dragomir Cristian
 * @author Mihai Botez
 */
public class Graph {
    private String name;
    private String description;
    private String definition;
    private String imageLocation;

    public Graph(String name, String definition, String imageLocation){
        this.name = name;
        this.definition = definition;
        this.imageLocation = imageLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
