package Bank_Management_System.src;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*; //date is present in this package

import javax.swing.*; 

class Deposit extends JFrame implements ActionListener{
    JButton Deposit,Back;
    JTextField AmountDeposittf;
    String pinnumber;
    Deposit(String pinnumber) { //PIN NUMBER AGER MATCH HOGA TOH HE DEPOSIT HOGA AND USS ACCOUNT ME DEPOSIT HOGA
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(150,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        AmountDeposittf = new JTextField();
        AmountDeposittf.setBounds(150, 295, 280, 25);
        image.add(AmountDeposittf);

        Deposit = new JButton("Deposit");
        Deposit.setBounds(296, 422, 150, 29);
        image.add(Deposit);
        Deposit.addActionListener(this);

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
        new Deposit("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Back){
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
        }else if(e.getSource() == Deposit){ //getSource se pata chalta hai ki kon sa button click hua
            try{
                String Amount = AmountDeposittf.getText();
                Date date = new Date();
                if(AmountDeposittf.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                }else{
                conn c = new conn();
                String query = "insert into bank value('"+pinnumber+"', '"+date+"','Deposit','"+Amount+"')";
                c.s.executeUpdate(query); 
                JOptionPane.showMessageDialog(null, "Rs "+Amount+" Deposited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
            }catch(Exception i){
                System.out.println(i);
            }
        }
    }
}