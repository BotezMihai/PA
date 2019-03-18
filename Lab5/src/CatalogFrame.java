import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CatalogFrame extends JFrame {
    GraphForm form;
   // CatalogList list;
   // ControlPanel control;

    public CatalogFrame() {
        super("Visual Graph Manager");
        init();
        form=new GraphForm();
        form.setLayout(new GridBagLayout());
        this.add(form,BorderLayout.PAGE_START);
        
    }
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

}