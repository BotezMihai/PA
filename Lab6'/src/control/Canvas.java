package control;

import node.NodeShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.event.MouseAdapter;

import static control.DrawingFrame.on;
import static control.DrawingFrame.onDelete;

public class Canvas extends JPanel {


    private BufferedImage image;
    private Graphics2D graphics;
    private int currentMouseX, currentMouseY;
    int[] cord=new int[4];
    int l=0;

    public Canvas() {
        this.setBorder(BorderFactory.createTitledBorder("Drawing paper:"));
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentMouseX = e.getX();
                currentMouseY = e.getY();
                if(onDelete==1)
                {
    System.out.println(e.getSource());

                }
                if(on==1) {
                    cord[l] = currentMouseX;
                    l++;
                    cord[l] = currentMouseY;
                    l++;
                    for (int i = 0; i < 4; i++)
                        System.out.println(cord[i]);
                    if (l == 4) {
                        graphics.setColor(Color.blue);
                        System.out.println("sunt in if");
                        graphics.drawLine(cord[0], cord[1], cord[2], cord[3]);
                       // graphics.drawLine(10,15,20,25);
                       repaint();
                        l = 0;
                    }
                }
                if (graphics != null && on==0 && onDelete==0) {
                    int stroke = Integer.parseInt(DrawingFrame.form.shapesSize.getText());
                    String color = (String) DrawingFrame.form.colorsValue.getSelectedItem();
                    drawShapeAt(currentMouseX, currentMouseY, stroke, color);
                    repaint();
                }
//
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = new BufferedImage(470, 230, BufferedImage.TYPE_INT_ARGB);
            graphics = image.createGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }

    public void drawShapeAt(int x, int y, int stroke, String color) {
        Random rand = new Random();
        graphics.setColor(new Color(rand.nextInt(0xFFFFFF)));
        NodeShape node = new NodeShape(x, y, stroke);
        graphics.fill(node);
        if (color.equals("red"))
            graphics.setPaint(Color.red);
        else if (color.equals("blue"))
            graphics.setPaint(Color.blue);
        else if (color.equals("pink"))
            graphics.setPaint(Color.pink);
        else if (color.equals("orange"))
            graphics.setPaint(Color.orange);
        else if (color.equals("black"))
            graphics.setPaint(Color.black);
        else if (color.equals("white"))
            graphics.setPaint(Color.white);
        graphics.draw(node);

    }
//    public void drawALine(){
//
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int currentMouseX1,currentMouseY1;
//                currentMouseX = e.getX();
//                currentMouseY = e.getY();
//                System.out.println(currentMouseX);
//                System.out.println(currentMouseY);
//                secondPoint(currentMouseX,currentMouseY);
//
//            }
//        });
//
//    }
//    public void secondPoint(int x, int y)
//    {
//
//
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int currentMouseX,currentMouseY;
//                currentMouseX = e.getX();
//                currentMouseY = e.getY();
//                graphics.setColor(Color.blue);
//       graphics.drawLine(currentMouseX,currentMouseY,x,y);
//       repaint();
//
//            }
//        });
//
//    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
