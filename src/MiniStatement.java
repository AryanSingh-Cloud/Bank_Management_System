package Bank_Management_System.src;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        setLayout(null);

        // Label to display mini statement (transaction history)
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 300);
        add(mini);

        // Bank name
        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(150, 20, 200, 20);
        add(bank);

        // Card number label
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Balance label
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            conn c = new conn(); // conn class se connection banaya
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pinnumber + "'");

            while (rs.next()) {
                // Card number ko partially hide kiya gaya hai
                card.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            conn c = new conn();
            int bal = 0; // balance

            // bank table me se pin ke according saari entries nikal rahe
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                // statement ke format me transaction list
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                // Deposit hai toh balance me add karo warna minus
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            balance.setText("Your current account balance is Rs " + bal);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
