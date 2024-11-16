package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    String pinNumber;
    JPasswordField newPinTextField, reEnterNewPinTextField;
    JButton change, back;

    PinChange(String pinNumber){

        this.pinNumber = pinNumber;

        //Setting the custom Layout
        setLayout(null);

        //Setting atm pic as the background
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Labels
        //1. Heading
        JLabel text = new JLabel("Select Withdrawal amount");
        text.setBounds(240, 330, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //2. New pin
        JLabel newPin = new JLabel("New PIN:");
        newPin.setBounds(200, 380, 100, 30);
        newPin.setForeground(Color.white);
        newPin.setFont(new Font("System", Font.BOLD, 18));
        image.add(newPin);

        newPinTextField = new JPasswordField();
        newPinTextField.setBounds(320, 380, 100, 30);
        newPinTextField.setFont(new Font("System", Font.BOLD, 16));
        newPinTextField.setBackground(Color.white);
        image.add(newPinTextField);

        //2. Re-enter New pin
        JLabel reEnterNewPin = new JLabel("Re-enter");
        reEnterNewPin.setBounds(200, 430, 100, 30);
        reEnterNewPin.setForeground(Color.white);
        reEnterNewPin.setFont(new Font("System", Font.BOLD, 18));
        image.add(reEnterNewPin);
        JLabel reEnterNewPin2 = new JLabel("New PIN:");
        reEnterNewPin2.setBounds(200, 460, 100, 30);
        reEnterNewPin2.setForeground(Color.white);
        reEnterNewPin2.setFont(new Font("System", Font.BOLD, 18));
        image.add(reEnterNewPin2);

        reEnterNewPinTextField = new JPasswordField();
        reEnterNewPinTextField.setBounds(320, 460, 100, 30);
        reEnterNewPinTextField.setFont(new Font("System", Font.BOLD, 16));
        reEnterNewPinTextField.setBackground(Color.white);
        image.add(reEnterNewPinTextField);

        //Buttons
        //1. Change button
        change = new JButton("Change");
        change.setBounds(350, 520, 150, 30);
        change.addActionListener(this);
        image.add(change);

        //7. Back button
        back = new JButton("Back");
        back.setBounds(350, 560, 150, 30);
        back.addActionListener(this);
        image.add(back);

        //Creating a frame
        setSize(900, 900);
        setBounds(300, 0, 900, 900);
        setUndecorated(true);
        setVisible(true);

        //Exiting upon closing the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(true);
            new Transactions(pinNumber).setVisible(true);
        } else if(e.getSource() == change){
            String newPin = String.valueOf(newPinTextField.getPassword());
            String reEnterNewPin = String.valueOf(reEnterNewPinTextField.getPassword());

            if(newPin.equals("") || reEnterNewPin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the PIN to proceed");
                newPinTextField.setText("");
                reEnterNewPinTextField.setText("");
                return;
            }

            if(!newPin.equals(reEnterNewPin)){
                JOptionPane.showMessageDialog(null, "The PIN's do not match");
                newPinTextField.setText("");
                reEnterNewPinTextField.setText("");
                return;
            }

            try{
                Conn c = new Conn();
                String query1 = "UPDATE bank SET pinNumber = '"+newPin+"' WHERE pinNumber = '"+pinNumber+"'";
                String query2 = "UPDATE login SET pinNumber = '"+newPin+"' WHERE pinNumber = '"+pinNumber+"'";
                String query3 = "UPDATE signupThree SET pinNumber = '" + newPin + "' WHERE pinNumber = '" + pinNumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN has been successfully update");
                setVisible(false);
                new Transactions(newPin).setVisible(true);
            } catch(Exception error){
                System.out.println(error);
            }
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
