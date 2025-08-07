package Bank_Management_System.src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
class signup1 extends JFrame implements ActionListener{
  //SABKO GLOBAL KARNA HAI,PEHLE LOCAL THA
  long random; //----random ke under form number
  JTextField nametf,fnametf,emailtf,addrtf,citytf,statetf,pincodetf;
  JDateChooser datechooser;
  JButton next;
  JRadioButton male,female,married,unmarried,other;
    signup1(){
      super("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

      Random ran = new Random();
      long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

      JLabel formno = new JLabel("APPLICATION FORM NO. " +random);
      formno.setFont(new Font("Raleway",Font.BOLD,38));
      formno.setBounds(140, 20, 600, 40);
      add(formno);

      JLabel personaldetail = new JLabel("Page 1: Personal Details");
      personaldetail.setFont(new Font("Raleway",Font.BOLD,22));
      personaldetail.setBounds(290, 80, 300, 30);
      add(personaldetail);

      JLabel name = new JLabel("Name:");
      name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100, 140, 100, 30);
      add(name);

      nametf = new JTextField();
      nametf.setFont(new Font("Raleway",Font.BOLD,14));
      nametf.setBounds(300, 140, 400, 30);
      add(nametf);

      JLabel fname = new JLabel("Father's Name:");
      fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100, 190, 150, 30);
      add(fname);

      fnametf = new JTextField();
      fnametf.setFont(new Font("Raleway",Font.BOLD,14));
      fnametf.setBounds(300, 190, 400, 30);
      add(fnametf);

      JLabel dob = new JLabel("Date of Birth:");
      dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100, 240, 150, 30);
      add(dob);

      datechooser = new JDateChooser();
      datechooser.setBounds(300, 240, 400, 30);
      add(datechooser);

      JLabel gender = new JLabel("Gender:");
      gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100, 290, 100, 30);
      add(gender);

      male = new JRadioButton("Male");
      male.setBounds(300, 290, 60, 30);
      male.setBackground(Color.WHITE);
      add(male);

      female = new JRadioButton("Female");
      female.setBounds(450, 290, 100, 30);
      female.setBackground(Color.WHITE);
      add(female);

      ButtonGroup gendergroup = new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);
      
      JLabel email = new JLabel("Email Address:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100, 340, 150, 30);
      add(email);

      emailtf = new JTextField();
      emailtf.setFont(new Font("Raleway",Font.BOLD,14));
      emailtf.setBounds(300, 340, 400, 30);
      add(emailtf);

      JLabel maritalstatus = new JLabel("Marital Status:");
      maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
      maritalstatus.setBounds(100, 390, 150, 30);
      add(maritalstatus);

      married = new JRadioButton("Married");
      married.setBounds(300, 390, 100, 30);
      married.setBackground(Color.WHITE);
      add(married);

      unmarried = new JRadioButton("Unmarried");
      unmarried.setBounds(450, 390, 100, 30);
      unmarried.setBackground(Color.WHITE);
      add(unmarried);

      other = new JRadioButton("Other");
      other.setBounds(650, 390, 100, 30);
      other.setBackground(Color.WHITE);
      add(other);

      ButtonGroup maritalstatusgroup = new ButtonGroup();
      maritalstatusgroup.add(married);
      maritalstatusgroup.add(unmarried);
      maritalstatusgroup.add(other);

      JLabel addr = new JLabel("Address:");
      addr.setFont(new Font("Raleway",Font.BOLD,20));
      addr.setBounds(100, 440, 100, 30);
      add(addr);

      addrtf = new JTextField();
      addrtf.setFont(new Font("Raleway",Font.BOLD,14));
      addrtf.setBounds(300, 440, 400, 30);
      add(addrtf);

      JLabel city = new JLabel("City:");
      city.setFont(new Font("Raleway",Font.BOLD,20));
      city.setBounds(100, 490, 100, 30);
      add(city);

      citytf = new JTextField();
      citytf.setFont(new Font("Raleway",Font.BOLD,14));
      citytf.setBounds(300, 490, 400, 30);
      add(citytf);

      JLabel state = new JLabel("State:");
      state.setFont(new Font("Raleway",Font.BOLD,20));
      state.setBounds(100, 540, 100, 30);
      add(state);

      statetf = new JTextField();
      statetf.setFont(new Font("Raleway",Font.BOLD,14));
      statetf.setBounds(300, 540, 400, 30);
      add(statetf);

      JLabel pincode = new JLabel("Pin Code:");
      pincode.setFont(new Font("Raleway",Font.BOLD,20));
      pincode.setBounds(100, 590, 100, 30);
      add(pincode);

      pincodetf = new JTextField();
      pincodetf.setFont(new Font("Raleway",Font.BOLD,14));
      pincodetf.setBounds(300, 590, 400, 30);
      add(pincodetf);

      next = new JButton("Next");
      next.setBounds(600, 640, 100, 40);
      next.setFont(new Font("Raleway",Font.BOLD,14));
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      add(next);
    //YEH CONSTRUCTOR KE UNDER HAI TOH JAISE HE CONSTRUCTOR CALL HOGA TOH YEH BHI CALL HOGA AND CHOTI SI WINDOW NAHI OPEN HOGI PURI WINDWO OPEN HOGI
    setSize(850,850);
    setLocation(350,10);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
      //Idhare humare pass keval ek he button hai toh uske leye humko if else ki zaroorat nahi hai; aise bhi kaam hoo jaayega
      String formno = "" + random; //string use kar hai kyuki database me keval string he allow hai and ""+ -- long value string me convert hoo jati hai
      String name = nametf.getText();
      String fname = fnametf.getText();
      String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText(); //JTextField humne iss leye concat karwaya kyuki gettext keval JTextField per he use hota hai;
      String gender = null;
      if(male.isSelected()){ 
          gender = "Male";
      }else if(female.isSelected()){ 
          gender = "Female";
      }
          
      String email = emailtf.getText();
      String marital = null;
      if(married.isSelected()){ 
          marital = "Married";
      }else if(unmarried.isSelected()){ 
          marital = "Unmarried";
      }else if(other.isSelected()){ 
          marital = "Other";
      }
         
      String address = addrtf.getText();
      String city = citytf.getText();
      String pincode = pincodetf.getText();
      String state = statetf.getText();
      //DATABASE ME HIT MARNA HAI USKE LEYE TRY AND CATCH
      //sql ek external entity hai toh run time me error aane ke chances bahut high that is why try and catch is used
      try{
        //VALIDATION
        if(nametf.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Fill all the required fields");//ager name nahi daala and next per click kar deya toh
        }                                                                                             //joptionpane show karna like popup and usme sort of warning hogi
        else if(fnametf.getText().equals("")){
          JOptionPane.showMessageDialog(null, "Fill all the required fields");  
        }
        else{
          //DATABASE ME CALL MARNA HAI BUT USSE PEHLE CONNECTION ESTABLISH KARNA HOGA
          conn c1 = new conn(); //--- CONNECTION ESTABLISH KARNA HAI
          String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
          c1.s.executeUpdate(query); // conn class ki help se execute karna hai
          setVisible(false);
          new SignupTwo("formno").setVisible(true);
        }                                                                                     
      }catch(Exception f){
        System.out.println(e);
      }   
    }

}
public class Signupone {
    public static void main(String[] args) {
    signup1 s = new signup1();
    // s.setSize(850,850);
    // s.setLocation(350,10);
    // s.setVisible(true);
    // s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}
}
