package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
    JTextField panTextField, aadharTextField;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JButton next;
    String formNo;

    public SignupTwo(String formNo){

        this.formNo = formNo;

        //Setting the custom layout
        setLayout(null);

        //Changing the title of the frame
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        //Labels
        //1. Form Number
        JLabel form = new JLabel("APPLICATION FORM NO. " + formNo);
        form.setFont(new Font("Raleway", Font.BOLD, 38));
        form.setBounds(140, 20, 600, 40);
        add(form);
        //1. Additional Details
        JLabel additionDetails = new JLabel("Page 2: Addition Details");
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290, 80, 400, 30);
        add(additionDetails);


        //1. Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 140, 200, 30);
        add(religion);
        String[] religions = {"Hindu", "Christian", "Muslim", "Sikh", "Jain", "Buddhist"};
        religionBox = new JComboBox(religions);
        religionBox.setBounds(330, 140, 400, 30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        //2. Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 190, 200, 30);
        add(category);
        String[] categories = {"General", "OBC", "SC/ST", "EWS"};
        categoryBox = new JComboBox(categories);
        categoryBox.setBounds(330, 190, 400, 30);
        categoryBox.setBackground(Color.white);
        add(categoryBox);


        //3. Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 240, 200, 30);
        add(income);
        String[] incomes  = {"Null", "< 1,50,000", "< 3,00,000", "< 5,00,000", "< 8,00,000", "< 10,00,000", "> 10,00,000"};
        incomeBox = new JComboBox(incomes);
        incomeBox.setBounds(330, 240, 400, 30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        //4. Education
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 290, 200, 30);
        add(education);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100, 340, 200, 30);
        add(qualification);
        String[] qualifications = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        qualificationBox = new JComboBox(qualifications);
        qualificationBox.setBounds(330, 340, 400, 30);
        qualificationBox.setBackground(Color.white);
        add(qualificationBox);

        //5. Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        String[] occupations = {"Salaried", "Self-employed", "Business", "Student", "Retired", "Others"};
        occupationBox = new JComboBox(occupations);
        occupationBox.setBounds(330, 390, 400, 30);;
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        //6. PAN Number
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setBounds(330, 440, 400, 30);
        panTextField.setBackground(Color.white);
        panTextField.setForeground(Color.black);
        add(panTextField);

        //7. Aadhar Number
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        aadharTextField = new JTextField();
        aadharTextField.setBounds(330, 490, 400, 30);
        aadharTextField.setBackground(Color.white);
        aadharTextField.setForeground(Color.black);
        add(aadharTextField);

        //8. Senior Citizen or not
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 22));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(330, 540, 100, 30);
        seniorYes.setBackground(Color.white);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450, 540, 100, 30);
        seniorNo.setBackground(Color.white);
        add(seniorNo);
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        //9. Existing account or not
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(330, 590, 100, 30);
        existingYes.setBackground(Color.white);
        add(existingYes);
        existingNo = new JRadioButton("No");
        existingNo.setBounds(450, 590, 100, 30);
        existingNo.setBackground(Color.white);
        add(existingNo);
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);

        //Next Button
        next = new JButton("Next");
        next.setBounds(400, 650, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        //Changing the background color of the frame
        getContentPane().setBackground(Color.white);

        //Creation of the frame
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        //Exit upon closing the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Getting the entered Values
        String religionValue = (String) religionBox.getSelectedItem();
        String incomeValue = (String) incomeBox.getSelectedItem();
        String categoryValue = (String) categoryBox.getSelectedItem();
        String occupationValue = (String) occupationBox.getSelectedItem();
        String qualificationValue = (String) qualificationBox.getSelectedItem();
        String panNumberValue = (String) panTextField.getText();
        String aadharNumberValue = (String) aadharTextField.getText();

        String seniorValue = null;
        if(seniorYes.isSelected()) seniorValue = "Yes";
        else if(seniorNo.isSelected()) seniorValue = "No";

        String existingValue = null;
        if(existingYes.isSelected()) existingValue = "Yes";
        else if(existingNo.isSelected()) existingValue = "No";

        try{
            Conn c = new Conn();
            String query = "INSERT INTO signupTwo VALUES ('"+formNo+"', '"+religionValue+"', '"+categoryValue+"', '"+incomeValue+"', '"+qualificationValue+"', '"+occupationValue+"', '"+panNumberValue+"', '"+aadharNumberValue+"', '"+seniorValue+"', '"+existingValue+"')";
            c.s.executeUpdate(query);

            //linking the next button to signupThree frame
            setVisible(false);
            new SignupThree(formNo).setVisible(true);
        } catch( Exception error){
            System.out.println(error);
        }

    }


    public static void main(String[] args) {
        new SignupTwo("");
    }
}
