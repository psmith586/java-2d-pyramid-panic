package PyramidPanic.Display;

import javax.swing.*;
import java.awt.*;

public class DisplayWindow {

    private JFrame frame;
    private Canvas canvas;
    private int width, height;
    private String title;

    public DisplayWindow(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        buildWindow();
    }

    public void buildWindow(){
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas(){ return canvas; }

    public JFrame getFrame(){ return frame; }
}
