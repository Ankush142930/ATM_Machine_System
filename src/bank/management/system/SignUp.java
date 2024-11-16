package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried, other;
    JButton next;

    SignUp(){

        //Changing the default Layout
        setLayout(null);

        //Generation of random object
        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1000L);

        //Labels
        //1. Form Number
        JLabel formNo = new JLabel("APPLICATION FORM NO. " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);

        //2. Page number
        JLabel personalDetails = new JLabel("PAGE 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        //3. Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        //4. Father's Name
        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100, 190, 200, 30);
        add(fName);
        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fNameTextField.setBounds(300, 190, 400, 30);
        add(fNameTextField);

        //5. Date of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));
        add(dateChooser);

        //6. Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.white);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        //7. Email Address
        JLabel email = new JLabel("Email address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        //8. Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(525, 390, 100, 30);
        other.setBackground(Color.white);
        add(other);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        //9. Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        //10. City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        //11. State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        //12. Pincode
        JLabel pincode = new JLabel("Pin code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);


        //Creating the next page button
        next = new JButton("Next");
        next.setBounds(400, 650, 80, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        //Changing the background color of the frame
        getContentPane().setBackground(Color.white);

        //Creating the frame
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        //Exit upon closing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Getting the entered Values
        String formNo = "" + random; // set Form number
        String name = nameTextField.getText(); // set name
        String fName = fNameTextField.getText(); // set father's name
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) gender = "Male";
        else if(female.isSelected()) gender = "Female";

        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()) marital = "Married";
        else if(unmarried.isSelected()) marital =  "Unmarried";
        else if(other.isSelected()) marital = "Other";

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else{
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES ('" + formNo + "', '" + name + "', '" + fName + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }
        } catch(Exception error){
            System.out.println(error);
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
