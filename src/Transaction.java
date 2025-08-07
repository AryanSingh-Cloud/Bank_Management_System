package Bank_Management_System.src;
import javax.swing.*; //JFRAME JO HOTA HAI WO SWING KE UNDER HOTA HAI JO JAVA KA EXTENDED PACKAGE HOTA HAI
import java.awt.*;// image and font class awt package me hota hai, toh usko import karna hoga
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton Deposit,CashWithdrawal,FastCash,PinChange,MiniStatement,BalanceEnquiry,Exit;
    String pinnumber;
    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg"); 
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);//This extracts the raw Image object from i1 and scales it to 100x100 pixels.Note: getScaledInstance() returns an Image, not an ImageIcon.
        ImageIcon i3 = new ImageIcon(i2);//Here, you're converting the scaled Image (i2) back into an ImageIcon (i3).  This is necessary because JLabel needs an Icon, not a raw Image.
        JLabel image = new JLabel(i3);//PLACE THE IMAGE IN A LABEL
        image.setBounds(0, 0, 780, 780); // very important: set bounds for image label
        add(image);//ADD LABEL TO THE FRAME

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(178,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);//TO ADD THE TEXT ON THE IMAGE

        Deposit = new JButton("Deposit");
        Deposit.setBounds(135,358,150,29);
        image.add(Deposit);

        CashWithdrawal = new JButton("Cash Withdrawal");
        CashWithdrawal.setBounds(296,358, 150, 29);
        image.add(CashWithdrawal);

        FastCash = new JButton("Fast Cash");
        FastCash.setBounds(135,390, 150, 29);
        image.add(FastCash);

        PinChange = new JButton("Pin Change");
        PinChange.setBounds(135, 423, 150, 29);
        image.add(PinChange);

        MiniStatement = new JButton("Mini Statement");
        MiniStatement.setBounds(296, 390, 150, 29);
        image.add(MiniStatement);

        BalanceEnquiry = new JButton("Balance Enguiry");
        BalanceEnquiry.setBounds(296, 423, 150, 29);
        image.add(BalanceEnquiry);

        Exit = new JButton("Exit");
        Exit.setBounds(296, 454, 150, 24);
        image.add(Exit);

          // Register ActionListeners
          Deposit.addActionListener(this);
          CashWithdrawal.addActionListener(this);
          FastCash.addActionListener(this);
          PinChange.addActionListener(this);
          MiniStatement.addActionListener(this);
          BalanceEnquiry.addActionListener(this);
          Exit.addActionListener(this);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Transaction("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Exit) {
            System.exit(0);
        } else if (ae.getSource() == Deposit) {
            new Deposit(pinnumber).setVisible(true);
         } else if (ae.getSource() == CashWithdrawal) {
             new Withdrawal(pinnumber).setVisible(true);
         } else if (ae.getSource() == FastCash) {
             new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == PinChange) {
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == BalanceEnquiry) {
            new BalanceEnquiry(pinnumber).setVisible(true);
         } else if (ae.getSource() == MiniStatement) {
             new MiniStatement(pinnumber).setVisible(true);
        }
    }

}
  