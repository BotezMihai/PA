import javax.swing.*;
import java.awt.*;

public class Toolbar extends JPanel {


private String[] borderColor={"red","blue","pink","orange","black","white"};

    JLabel sizeLabel = new JLabel("Stroke size: ");
    JLabel colorLabel = new JLabel("Border color:");
    JTextField shapesSize = new JFormattedTextField();
   JComboBox colorsValue = new JComboBox(borderColor);


    public Toolbar(DrawingFrame frame) {
        this.setBorder(BorderFactory.createTitledBorder("Toolbar"));
        init();
        this.setLayout(new GridLayout(2,4, 20, 0));
    }

    private void init() {
        colorsValue.setSelectedIndex(1);
        shapesSize.setText("10");
        add(colorLabel);
        add(sizeLabel);
        add(colorsValue);
        add(shapesSize);
    }
}
