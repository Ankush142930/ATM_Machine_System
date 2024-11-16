package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signIn, clear, signUp;
    JTextField cardNumberTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        //In order to set out own custom layout
        setLayout(null);

        //For adding bank icon image we ImageIcon class and ClassLoader
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        //Fpr adding content to the frame
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200, 40, 400, 40);
        add(text);

        //Card Number text
        JLabel cardNo = new JLabel("Card No.:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 30));
        cardNo.setBounds(200, 150, 150, 40);
        add(cardNo);

        //Adding text field for card number
        cardNumberTextField = new JTextField();
        cardNumberTextField.setFont(new Font("Arial", Font.PLAIN, 25));
        cardNumberTextField.setBounds( 375, 150, 250, 40 );
        add(cardNumberTextField);

        //PIN text
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 30));
        pin.setBounds(200, 220, 150, 40);
        add(pin);

        //Adding text field for PIN
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 25));
        pinTextField.setBounds( 375, 220, 250, 40 );
        add(pinTextField);

        //Changing the color of the frame
        getContentPane().setBackground(Color.white);

        //Adding sign in button to the frame
        signIn = new JButton("Sign In");
        signIn.setBounds(375, 275, 100, 30);
        signIn.setBackground(Color.black);
        signIn.setForeground(Color.white);
        signIn.addActionListener(this);
        add(signIn);

        //Adding clear button to the frame
        clear = new JButton("Clear");
        clear.setBounds(525, 275, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        //Adding sign up button to the frame
        signUp = new JButton("Sign Up");
        signUp.setBounds(375, 320, 250, 30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        //Creation of frame for the application
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

        //Exiting upon closing of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear){
            cardNumberTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == signIn){
            Conn c = new Conn();
            String cardNumber = cardNumberTextField.getText();
//            String pinNumber = pinTextField.getText();
            String pinNumber = String.valueOf(pinTextField.getPassword());

            String query = "SELECT pinNumber FROM login WHERE cardNumber = '"+cardNumber+"' AND pinNumber = '"+pinNumber+"'";
            try{
                ResultSet set = c.s.executeQuery(query);
                if(set.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
            } catch(Exception error){
                System.out.println(error);
            }
        } else {
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


//Test Value: card Number  = 1244940134260434 pin Number = 9382