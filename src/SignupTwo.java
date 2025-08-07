package Bank_Management_System.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField aadharField, panField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religionBox, categoryBox, incomeBox, educationBox, occupationBox;
    String formno;

    // Constructor
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Header
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        // Religion Dropdown
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBounds(300, 140, 400, 30);
        add(religionBox);

        // Category Dropdown
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        categoryBox = new JComboBox<>(valCategory);
        categoryBox.setBounds(300, 190, 400, 30);
        add(categoryBox);

        // Income Dropdown
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String[] valIncome = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        incomeBox = new JComboBox<>(valIncome);
        incomeBox.setBounds(300, 240, 400, 30);
        add(incomeBox);

        // Education
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String[] educationValues = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        educationBox = new JComboBox<>(educationValues);
        educationBox.setBounds(300, 315, 400, 30);
        add(educationBox);

        // Occupation Dropdown
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String[] occupationValues = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationBox = new JComboBox<>(occupationValues);
        occupationBox.setBounds(300, 390, 400, 30);
        add(occupationBox);

        // PAN field
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 14));
        panField.setBounds(300, 440, 400, 30);
        add(panField);

        // Aadhar field
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharField.setBounds(300, 490, 400, 30);
        add(aadharField);

        // Senior Citizen radio buttons
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        // Button group to allow only one selection
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        // Existing account radio buttons
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        // Button group to allow only one selection
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(eyes);
        accountGroup.add(eno);

        // Next button
        next = new JButton("Next");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        add(next);

        next.addActionListener(this);

        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    // On button click
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();

        String pan = panField.getText();
        String aadhar = aadharField.getText();

        // Handle Radio Button selection using if-else
        String seniorCitizen = "";
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = "";
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        try {
            conn c = new conn();
            String query = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query);

            // Proceed to next page
            setVisible(false);
            new Signup3(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
