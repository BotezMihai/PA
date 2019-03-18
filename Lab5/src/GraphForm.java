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
    //JSpinner verticesField = new JSpinner( new SpinnerNumberModel(0,1000));
   public GraphForm()
   {
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       this.setLocation((screenSize.width - 400) / 2, (screenSize.height - 300) / 2);

      init();


   }
    private void init() {
       // tf1=new JTextField();
        JLabel label = new JLabel("Enter name:");
        JTextField Name = new JTextField(20);
        JLabel labelType = new JLabel("Enter type:");
        JTextField textType = new JTextField(20);
        JLabel labelPath = new JLabel("Enter path:");
        JTextField textPath = new JTextField(20);
        JLabel labelImg = new JLabel("Enter path of image:");
        JTextField textImg = new JTextField(20);
        JLabel labelVertices = new JLabel("Number of vertices:");
        JTextField textVertices = new JTextField(20);
        JLabel labelNodes = new JLabel("Number of nodes:");
        JTextField textNodes = new JTextField(20);
        this.add(label);
        this.add(Name);
        this.add(labelType);
        this.add(textType);
        this.add(labelPath);
        this.add(textPath);
        this.add(labelImg);
        this.add(textImg);
        this.add(labelVertices);
        this.add(textVertices);
        this.add(labelNodes);
        this.add(textNodes);

        // addButton.addActionListener(...);
    }
    private void addGraph() {
       // frame.list.addGraph(...);
    }
}
