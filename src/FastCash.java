package Bank_Management_System.src;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset; 
class FastCash extends JFrame implements ActionListener {
    JButton rs100,rs500,rs1000,rs5000,rs2000,rs10000,Back;
    String pinnumber;
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon("Bank_Management_System/icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(780, 780, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 780, 780);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(183,250,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(135,358,150,29);
        image.add(rs100);
        rs100.addActionListener(this);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(296,358, 150, 29);
        image.add(rs500);
        rs500.addActionListener(this);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(135,390, 150, 29);
        image.add(rs1000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(135, 423, 150, 29);
        image.add(rs5000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(296, 390, 150, 29);
        image.add(rs2000 );

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(296, 423, 150, 29);
        image.add(rs10000);

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
        new FastCash("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
//I AM GOING TO CREATE DYNAMIC BUTTON, WHICH MEANS KI HUM KOI BHI BUTTON CLICK KARE BAS AMOUNT DATABASE ME SAVE HOGA AND RETURN KAREGA JO BUTTON CLICK KARA HAI USKA LABEL        
//IF ELSE WALA BHI USE KAR SAKTE HAI, BUT WO BAHUT LAMBA KAAM HAI
        else{
           String amount = ((JButton)e.getSource()).getText().substring(3);//getSource ka access aata hai(i mean kon sa button click hua wo pata chalta hai)
                                                                                     //getText se button ka text pata chalta hai
                                                                                    //getsource button object return karta hai,therefore typecast karna hoga Jbutton se.
                                                                                   //substring(3) se rs 500 me se rs 500 me se start ki 3 index minus karke return hoga jo ki 500 hai.
        try{
            conn c = new conn();
            //pehle check karna hoga ki apne bank me balance kitna hai(result set me saari value nikal kar aa jayengi)
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");//yeh match karega ki given pin number wla balance show hoo //query ka result in result set
            //aab balance nikalna hai ki kitna hai
            int balance = 0;
            while(rs.next()){ //rs.next humne har row loop karke dega
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount")); //Integer.parseInt jo hai wo string ko integer ke convert karta hai. yeh mainly amount nikal kar balanace me add karega
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if(e.getSource()!= Back && balance < Integer.parseInt(amount)){ //check karna hai ki back button and withdraw karne wala amount balance se zyada toh nahi hai
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }
            Date date = new Date();
            //withdraw amt update karna hoga database me
            c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
            JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);;
        }catch(Exception ee){
            System.out.println(ee);
            
        }
}
}
}
//AMBIGUOUS EXAMPLE :- LIKE DATE CLASS DO PACKAGE ME HAI SQL AS WELL AS UTIL PACKAGE TOH COMPILER COMFUSE HOO JATA HAI
//KI DATE CLASS KISKA LEE TOH PHIR WO ERROR SHOW KARTA HAI, TOH HUME UTIL.DATE OR SQL.DATE KARKE DECLARE KARNA HOTA HAI
//JISSE USKA PATA CHALE  .java.lang.NumberFormatException: For input string: ""

