import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel classNameLabel = new JLabel("Class name");
    private final JTextField classNameField = new JTextField(30);
    private final JLabel textLabel = new JLabel("Default text");
    private final JTextField textField = new JTextField(10);
    private final JButton createButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        add(classNameLabel); add(classNameField); add(textLabel); add(textField); add(createButton);
        createButton.addActionListener(e -> {
            JComponent comp = createDynamicComponent(classNameField.getText());
            try {
                setComponentText(comp, textField.getText());
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            frame.designPanel.addAtRandomLocation(comp);
        });
    }

    private JComponent createDynamicComponent(String className) {
	   //implement this method
        if(className.contains("JButton"))
            return new JButton();
        if(className.contains("JPanel"))
            return new JPanel();
        if(className.contains("JLabel"))
            return new JLabel();
        if(className.contains("JTextField"))
            return new JTextField();
        return null;
    }
    private void setComponentText(JComponent comp, String text) throws InvocationTargetException, IllegalAccessException {
	   //implement this method
        Method[] methods = comp.getClass().getMethods();
        for(int index = 0; index<methods.length; index++)
            if(methods[index].getName().equals("setText"))
                methods[index].invoke(comp,text);
    }
}