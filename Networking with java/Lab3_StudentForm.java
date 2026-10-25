
import javax.swing.*;
import java.awt.*;

public class Lab3_StudentForm extends JFrame {

    Lab3_StudentForm() {
        setTitle("Student Form");
        setSize(500, 350);
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField name = new JTextField();
        JTextField id = new JTextField();
        JTextField dept = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();

        add(new JLabel("Name:"));
        add(name);
        add(new JLabel("ID:"));
        add(id);
        add(new JLabel("Department:"));
        add(dept);
        add(new JLabel("Email:"));
        add(email);
        add(new JLabel("Phone Number:"));
        add(phone);

        JButton btn = new JButton("Submit");
        add(new JLabel(""));
        add(btn);

        btn.addActionListener(e -> {
            String em = email.getText().trim();
            String ph = phone.getText().trim();

            if (name.getText().trim().isEmpty() ||
                id.getText().trim().isEmpty() ||
                dept.getText().trim().isEmpty() ||
                em.isEmpty() || ph.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all fields!");
            }
            else if (!em.matches(
                "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
                JOptionPane.showMessageDialog(this, "Invalid Email!");
            }
            else if (!ph.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "Enter 11 digit phone!");
            }
            else {
                JOptionPane.showMessageDialog(this,
                    "Name: " + name.getText() +
                    "\nID: " + id.getText() +
                    "\nDepartment: " + dept.getText() +
                    "\nEmail: " + em +
                    "\nPhone: " + ph);
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab3_StudentForm();
    }
}
