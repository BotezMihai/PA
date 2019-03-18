import javax.swing.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
public class GraphForm extends JPanel {

    private  CatalogFrame frame;
    JLabel titleLabel = new JLabel("Name of the graph");
    JTextField tf1,tf2,tf3;


    private JLabel labelUsername = new JLabel("Enter name: ");
   private JLabel  labelType=new JLabel("Enter type: ");
    private JTextField textUsername = new JTextField(20);
    private JTextField textType = new JTextField(20);
    private JLabel labelPath = new JLabel("Enter path: ");
    private JTextField textPath = new JTextField(20);
    private JLabel labelPathImg = new JLabel("Enter path of image: ");
    private JTextField textPathImg = new JTextField(20);
    private JLabel labelVertices = new JLabel("Enter the numbers of vertices: ");
    private JTextField textVertices = new JTextField(20);
    private JLabel labelNodes = new JLabel("Enter the numbers of nodes: ");
    private JTextField textNodes = new JTextField(20);
    private JButton buttonLogin = new JButton("Add");
   public GraphForm()
   {


      init();


   }
    private void init() {

    this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(labelUsername, constraints);

        constraints.gridx = 1;
        this.add(textUsername, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(labelType, constraints);

        constraints.gridx = 1;
        this.add(textType, constraints);
        //path
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(labelPath, constraints);

        constraints.gridx = 1;
        this.add(textPath, constraints);
        //img path
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(labelPathImg, constraints);

        constraints.gridx = 1;
        this.add(textPathImg, constraints);
        //vertices
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(labelVertices, constraints);

        constraints.gridx = 1;
        this.add(textVertices, constraints);
        //nodes
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.add(labelNodes, constraints);

        constraints.gridx = 1;
        this.add(textNodes, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(buttonLogin, constraints);






    }
    private void addGraph() {
       // frame.list.addGraph(...);
    }
}
