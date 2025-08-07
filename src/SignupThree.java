package Bank_Management_System.src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton Submit,Cancel;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        //MY SCREEN IS SMALL SO I AM NOT ABLE TO VIEW SUBMIT AND CANCEL BUTTON
        //TO SOLVE THIS I HAVE USE JSCROLLBAR, FOR JSCROLL BAR WE NEED JPANE
        JPanel panel = new JPanel();
        panel.setLayout(null); // Use null layout to allow setBounds
        panel.setPreferredSize(new Dimension(850, 1000)); // Size of entire content (bigger than JFrame height)
        panel.setBackground(Color.WHITE);
        //Wrap the panel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show scrollbar
        setContentPane(scrollPane); //this adds the panel inside scrollPane into the JFrame

        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        panel.add(l1); 
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100,140,200,30);
        panel.add(l2);
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100,300,200,30);
        panel.add(l3);
    
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330,300,250,30);
        panel.add(l4);
    
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100,330,200,20);
        panel.add(l5);
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(330,330,500,20);
        panel.add(l6);
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100,370,200,30);
        panel.add(l7);
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(330,370,200,30);
        panel.add(l8);
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(100,400,200,20);
        panel.add(l9);
        
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100,450,200,30);
        panel.add(l10);
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(700,10,70,30);
        panel.add(l11);
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(770,10,40,30);
        panel.add(l12);
        
        Submit = new JButton("Submit");
        Submit.setFont(new Font("Raleway", Font.BOLD, 14));
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(250,720,100,30);
        panel.add(Submit);
        
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(420,720,100,30);
        panel.add(Cancel);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        panel.add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        panel.add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        panel.add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        panel.add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        panel.add(c5);
    
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        panel.add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,680,600,20);
        panel.add(c7);
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,150,30);
        panel.add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,300,30);
        panel.add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,30);
        panel.add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,30);
        panel.add(r4);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        //setLayout(null);//jab tak yeh null nahi hoga tab tak setbounds nahi chalega
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Submit.addActionListener(this);
        Cancel.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Saving Account";
        }
        else if(r2.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            atype = "Current Account";
        }else if(r4.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==Submit){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    conn c1 = new conn();
                    String query1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(query1);
                    c1.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);

                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            
            }else if(ae.getSource()==Cancel){
                System.exit(0);
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
    public class SignupThree{
    public static void main(String[] args){
        Signup3 s3 = new Signup3("");
    }
    }