package Bank_Management_System.src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class PinChange extends JFrame implements ActionListener {
    JButton Change, Back;
    JPasswordField newpin, repin; // JtextField se JPasswordfield karna hai, kyuki jo password hum enter karenge wo kisi ko dikhna nhi chahiye
    String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(215, 250, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel newpinn = new JLabel("New Pin");
        newpinn.setBounds(150, 290, 150, 35);
        newpinn.setForeground(Color.WHITE);
        newpinn.setFont(new Font("System", Font.BOLD, 16));
        image.add(newpinn);

        newpin = new JPasswordField();
        newpin.setBounds(290, 290, 150, 25);
        image.add(newpin);

        JLabel repinn = new JLabel("Re-Enter New Pin");
        repinn.setBounds(150, 325, 150, 35);
        repinn.setForeground(Color.WHITE);
        repinn.setFont(new Font("System", Font.BOLD, 15));
        image.add(repinn);

        repin = new JPasswordField();
        repin.setBounds(290, 325, 150, 25);
        image.add(repin);

        Change = new JButton("Change");
        Change.setBounds(296, 422, 150, 29);
        image.add(Change);
        Change.addActionListener(this);

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
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String rpin = newpin.getText();
            String rrpin = repin.getText();
            if (!rpin.equals(rrpin)) {
                JOptionPane.showMessageDialog(null, "Entered Pin Does Not Match");
                return; // return se aage nahi badhta, wapas peeche chala jata hai
            }
            if (e.getSource() == Change) {
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return;
                }
                if (rrpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter Pin");
                    return;
                }
                conn c = new conn();
                String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                String query3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            }
        } catch (Exception ae) {
            System.out.println(ae);
        } finally {
            if (e.getSource() == Back) {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }
        }
    }
}
