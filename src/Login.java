package Bank_Management_System.src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.sql.ResultSet; // resultset is present in sql package
import javax.swing.*;
import com.mysql.cj.protocol.Resultset;

class login1 extends JFrame implements ActionListener {
    JButton signin, clear, signup;
    JTextField cardtf, pintf;

    login1() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 200, 40);
        add(cardno);

        cardtf = new JTextField();
        cardtf.setBounds(280, 160, 250, 30);
        add(cardtf);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 200, 40);
        add(pin);

        pintf = new JTextField();
        pintf.setBounds(280, 220, 250, 30);
        add(pintf);

        signin = new JButton("SIGN IN");
        signin.setBounds(280, 300, 100, 30);
        signin.addActionListener(this);
        add(signin);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBounds(280, 350, 250, 30);
        signup.addActionListener(this);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 480);
        setVisible(true);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardtf.setText("");
            pintf.setText("");
        } else if (ae.getSource() == signin) {
           conn c = new conn(); //FIRSTLY CONNECTION ESTABLISH KARNA HOGA
           String cardnumber = cardtf.getText(); //USER NE JO CARDNUMBER INPUT KARA HAI WO NIKALNA HAI
           String pinnumber = pintf.getText(); //USER NE JO PIN NUMBER INPUT KARA HAI WO NIKALNA HAI
           //MATCHING THE USER ENTER CARDNO AND PIN WITH DATABASE CARDNO AND PINNO(ACTUAL DATA)
           String query = "select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'"; //'"++"' THIS FOR CONCATINATION
           
           try{
            ResultSet rs = c.s.executeQuery(query); // STORE RESULT IN RESULT SET (MATCH OR NOT)
            if(rs.next()){ //THIS MEAN IF MATCH 
               setVisible(false); //CLOSE PRESENT FRAME
               new Transaction(pinnumber).setVisible(true);//PINNUMBER CHAHIYE HOGA AAGE KYUKI PINNUMBER SE PATA CHALEGA KI YEH KISKA ACCOUNT HAI
            }else{
                JOptionPane.showMessageDialog(null, "Incorret Card Number or Pin"); //IF NOT MATCH JOPTION PANE WILL APPEAR WITH THIS MESSAGE
            }

           }catch(Exception e){
            System.out.println(e);
           }

        } else if (ae.getSource() == signup) {
            setVisible(false); //isse current page(login page) close hoo jaayega
            new signup1().setVisible(true); // signup page ka object banaya and yeh jaise call hoga signup page ka constructor call hoga
                                               //and visible true hai toh wo wala page open hoga
        }

    }
}
public class Login {
    public static void main(String[] args) {
        login1 l = new login1();
       
    }

}
