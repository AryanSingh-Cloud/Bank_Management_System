package Bank_Management_System.src;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset; 
class BalanceEnquiry extends JFrame implements ActionListener {
    JButton Back;
    String pinnumber;
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg"); 
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);
        //YEH HUMNE CONSTRUCTOR KE UNDER ISS LEYE RAKHA KI JAISE WINDWO OPEN HOO,BALANCE SCREEN PER DISPLAY HOO
        int balance = 0;
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            while(rs.next()){ 
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount")); 
                }else{
                    balance -= Integer.parseInt(rs.getString("amount")); 
                }
            }
        }catch(Exception ee){
            System.out.println(ee);
            
        } 
            JLabel text = new JLabel("Your Current Account Balance is Rs "+balance);
            text.setBounds(150,250,700,35);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD, 14));
            image.add(text);

        Back = new JButton("Back");
        Back.setBounds(296, 454, 150, 24);
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
        new BalanceEnquiry("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}

