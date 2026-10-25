
import javax.swing.*;
import java.awt.*;

public class Lab4_Calculator extends JFrame {

    JTextField display;
    double n1;
    String op;

    Lab4_Calculator() {
        setTitle("Calculator");
        setSize(350, 450);
        setLayout(new BorderLayout(5, 10));

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(350, 80));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 8, 8));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            panel.add(btn);
            btn.addActionListener(e -> calculate(b));
        }

        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void calculate(String b) {
        if (b.matches("[0-9]")) {
            display.setText(display.getText() + b);
        }
        else if (b.equals("C")) {
            display.setText("");
            n1 = 0;
            op = null;
        }
        else if (b.equals("=")) {
            try {
                double n2 = Double.parseDouble(display.getText());
                double result = 0;

                if (op.equals("+")) result = n1 + n2;
                else if (op.equals("-")) result = n1 - n2;
                else if (op.equals("*")) result = n1 * n2;
                else if (op.equals("/")) {
                    if (n2 == 0) {
                        display.setText("Cannot divide by zero");
                        return;
                    }
                    result = n1 / n2;
                }

                display.setText("" + result);
            } catch (Exception e) {
                display.setText("Enter a number");
            }
        }
        else {
            try {
                n1 = Double.parseDouble(display.getText());
                op = b;
                display.setText("");
            } catch (Exception e) {
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new Lab4_Calculator();
    }
}
