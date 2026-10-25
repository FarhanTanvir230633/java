import javax.swing.*;
import java.awt.*;

public class Lab1_DisplayImage extends JFrame {

    Lab1_DisplayImage() {
        ImageIcon image = new ImageIcon("input.jpg");
        JLabel label = new JLabel(image);

        add(label);

        setTitle("Display Image");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Lab1_DisplayImage();
    }
}