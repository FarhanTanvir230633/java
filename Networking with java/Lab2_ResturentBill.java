
import javax.swing.*;
import java.awt.*;

public class Lab2_ResturentBill {
    public static void main(String[] args) {

        double burger = 150;
        double pizza = 300;
        double coffee = 100;

        int b = Integer.parseInt(
            JOptionPane.showInputDialog("Enter Burger quantity:"));

        int p = Integer.parseInt(
            JOptionPane.showInputDialog("Enter Pizza quantity:"));

        int c = Integer.parseInt(
            JOptionPane.showInputDialog("Enter Coffee quantity:"));

        double burgerTotal = burger * b;
        double pizzaTotal = pizza * p;
        double coffeeTotal = coffee * c;

        double subtotal = burgerTotal + pizzaTotal + coffeeTotal;

        double discount = 0;
        if (subtotal >= 1000) {
            discount = subtotal * 0.10;
        }

        double afterDiscount = subtotal - discount;
        double vat = afterDiscount * 0.05;
        double totalBill = afterDiscount + vat;

        String bill = "========================================\n";
        bill += "           RESTAURANT BILL\n";
        bill += "========================================\n\n";

        bill += "Food Item       Qty     Price     Total\n";
        bill += "----------------------------------------\n";

        bill += String.format(
            "%-15s %-7d %-9.2f %.2f Tk\n",
            "Burger", b, burger, burgerTotal);

        bill += String.format(
            "%-15s %-7d %-9.2f %.2f Tk\n",
            "Pizza", p, pizza, pizzaTotal);

        bill += String.format(
            "%-15s %-7d %-9.2f %.2f Tk\n",
            "Coffee", c, coffee, coffeeTotal);

        bill += "----------------------------------------\n";

        bill += String.format("Subtotal           : %.2f Tk\n", subtotal);
        bill += String.format("Discount (10%%)     : %.2f Tk\n", discount);
        bill += String.format("After Discount     : %.2f Tk\n", afterDiscount);
        bill += String.format("VAT (5%%)           : %.2f Tk\n", vat);

        bill += "========================================\n";
        bill += String.format("TOTAL BILL         : %.2f Tk\n", totalBill);
        bill += "========================================\n\n";
        bill += "       Thank You! Visit Again.";

        JTextArea textArea = new JTextArea(bill);
        textArea.setFont(
            new Font("Monospaced", Font.PLAIN, 18));
        textArea.setEditable(false);
        textArea.setRows(18);
        textArea.setColumns(45);
        textArea.setMargin(new Insets(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(650, 480));

        JOptionPane.showMessageDialog(
            null,
            scrollPane,
            "Restaurant Bill",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
