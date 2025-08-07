package Bank_Management_System.src;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*; // for Date
import java.util.Date;

import javax.swing.*; 
import java.sql.*; // for database

public class Withdrawal extends JFrame implements ActionListener {
    JButton Withdraw, Back;
    JTextField AmountWithdrawtf;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(150,250,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        AmountWithdrawtf = new JTextField();
        AmountWithdrawtf.setBounds(150, 295, 280, 25);
        image.add(AmountWithdrawtf);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBounds(296, 422, 150, 29);
        image.add(Withdraw);
        Withdraw.addActionListener(this);

        Back = new JButton("Back");
        Back.setBounds(296, 453, 150, 24);
        image.add(Back);
        Back.addActionListener(this);

        setSize(780, 780);
        setLocation(300, 0);
        setLayout(null);
        setUndecorated(true); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else if (e.getSource() == Withdraw) {
            try {
                String Amount = AmountWithdrawtf.getText();
                Date date = new Date();

                if (Amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    // Check available balance before withdrawal
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
                    
                    int balance = 0;
                    while (rs.next()) {//rows ko loop karta hai
                        String type = rs.getString("type");
                        String amt = rs.getString("amount");

                        if (type.equals("Deposit")) {
                            balance += Integer.parseInt(amt);
                        } else if (type.equals("Withdrawal")) {
                            balance -= Integer.parseInt(amt);
                        }
                    }

                    int withdrawAmt = Integer.parseInt(Amount);
                    if (balance < withdrawAmt) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {
                        String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + Amount + "')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " + Amount + " Withdrawn Successfully");
                    }
                }

            } catch (Exception i) {
                System.out.println(i);
            }
        }
    }
}
