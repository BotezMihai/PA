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
      init();


   }
    private void init() {
       // tf1=new JTextField();
        JLabel label = new JLabel("Enter username:");
        JTextField userName = new JTextField(20);

        this.add(label);
        this.add(userName);
        // addButton.addActionListener(...);
    }
    private void addGraph() {
       // frame.list.addGraph(...);
    }
}
