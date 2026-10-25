
import javax.swing.*;

public class Lab2_RestaurantBill {
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

        String bill = "===== RESTAURANT BILL =====\n\n";

        bill += "Food Item       Qty    Price\n";
        bill += "-----------------------------\n";
        bill += "Burger          " + b + "      " + burgerTotal + "\n";
        bill += "Pizza           " + p + "      " + pizzaTotal + "\n";
        bill += "Coffee          " + c + "      " + coffeeTotal + "\n";
        bill += "-----------------------------\n";
        bill += "Subtotal        = " + subtotal + " Tk\n";
        bill += "Discount        = " + discount + " Tk\n";
        bill += "After Discount  = " + afterDiscount + " Tk\n";
        bill += "VAT (5%)        = " + vat + " Tk\n";
        bill += "-----------------------------\n";
        bill += "TOTAL BILL      = " + totalBill + " Tk\n";
        bill += "\nThank you for visiting!";

        JOptionPane.showMessageDialog(
            null, bill, "Restaurant Bill",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
