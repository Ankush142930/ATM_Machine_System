package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    String formNo;
    JRadioButton account1, account2, account3, account4;
    JCheckBox service1, service2, service3, service4, service5, service6, service7;
    JButton cancel, submit;

    public SignupThree(String formNo){
        this.formNo = formNo;

        //Setting the custom Layout
        setLayout(null);

        //Labels
        //1. Form Number
        JLabel form = new JLabel("APPLICATION FORM NO. " + formNo);
        form.setFont(new Font("Raleway", Font.BOLD, 38));
        form.setBounds(140, 20, 600, 40);
        add(form);
        //1. Account Details
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(290, 80, 400, 30);
        add(accountDetails);

        //2. Account Type
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);
        account1 = new JRadioButton("Savings Account");
        account1.setFont(new Font("Raleway", Font.BOLD, 16));
        account1.setBounds(100, 180, 200, 20);
        account1.setBackground(Color.white);
        add(account1);
        account2 = new JRadioButton("Fixed Deposit Account");
        account2.setFont(new Font("Raleway", Font.BOLD, 16));
        account2.setBounds(350, 180, 200, 20);
        account2.setBackground(Color.white);
        add(account2);
        account3 = new JRadioButton("Current Account");
        account3.setFont(new Font("Raleway", Font.BOLD, 16));
        account3.setBounds(100, 220, 250, 20);
        account3.setBackground(Color.white);
        add(account3);
        account4 = new JRadioButton("Recurring Deposit Account");
        account4.setFont(new Font("Raleway", Font.BOLD, 16));
        account4.setBounds(350, 220, 250, 20);
        account4.setBackground(Color.white);
        add(account4);
        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(account1);
        accountGroup.add(account2);
        accountGroup.add(account3);
        accountGroup.add(account4);

        //2. Card Number
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBackground(Color.white);
        card.setBounds(100, 300, 200, 30);
        add(card);

        //3. Dummy Card Number
        JLabel cardDummy = new JLabel("XXXX-XXXX-XXXX-2359");
        cardDummy.setFont(new Font("Raleway", Font.BOLD, 22));
        cardDummy.setBackground(Color.white);
        cardDummy.setBounds(330, 300, 300, 30);
        add(cardDummy);

        //3. Card detail Information
        JLabel cardDetail = new JLabel("(Your 16-digit card number)");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBackground(Color.white);
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        //5. PIN Number
        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBackground(Color.white);
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        //6. Dummy PIN Number
        JLabel pinDummy = new JLabel("XXXX");
        pinDummy.setFont(new Font("Raleway", Font.BOLD, 22));
        pinDummy.setBackground(Color.white);
        pinDummy.setBounds(330, 370, 300, 30);
        add(pinDummy);

        //7. PIN detail Information
        JLabel pinDetail = new JLabel("(Your 4-digit PIN number)");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBackground(Color.white);
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        //8. Services Required
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBackground(Color.white);
        services.setBounds(100, 450, 250, 20);
        add(services);
        service1 = new JCheckBox("ATM CARD");
        service1.setFont(new Font("Raleway", Font.BOLD, 16));
        service1.setBackground(Color.white);
        service1.setBounds(100, 500, 200, 30);
        add(service1);
        service2 = new JCheckBox("Internet Banking");
        service2.setFont(new Font("Raleway", Font.BOLD, 16));
        service2.setBackground(Color.white);
        service2.setBounds(350, 500, 200, 30);
        add(service2);
        service3 = new JCheckBox("Mobile Banking");
        service3.setFont(new Font("Raleway", Font.BOLD, 16));
        service3.setBackground(Color.white);
        service3.setBounds(600, 500, 200, 30);
        add(service3);
        service4 = new JCheckBox("Email & SMS Alerts");
        service4.setFont(new Font("Raleway", Font.BOLD, 16));
        service4.setBackground(Color.white);
        service4.setBounds(100, 550, 200, 30);
        add(service4);
        service5 = new JCheckBox("Cheque Book");
        service5.setFont(new Font("Raleway", Font.BOLD, 16));
        service5.setBackground(Color.white);
        service5.setBounds(350, 550, 200, 30);
        add(service5);
        service6 = new JCheckBox("E-Statement");
        service6.setFont(new Font("Raleway", Font.BOLD, 16));
        service6.setBackground(Color.white);
        service6.setBounds(600, 550, 200, 30);
        add(service6);

        //9. Declaration checkbox
        service7 = new JCheckBox("I, hereby declare that all the above details are accurate to the best of my knowledge.");
        service7.setFont(new Font("Raleway", Font.BOLD, 12));
        service7.setBackground(Color.white);
        service7.setBounds(100, 650, 700, 30);
        add(service7);

        //10. Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBounds(300, 700, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        //11. Submit Button
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBounds(450, 700, 100, 40);
        submit.addActionListener(this);
        add(submit);

        //Creation of the JFrame
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        //Setting the background color of the frame
        getContentPane().setBackground(Color.white);

        //Exiting the process upon closing of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            //Getting the entered Values
            String accountTypeValue = null;
            if(account1.isSelected()) accountTypeValue = "Savings Account";
            else if(account2.isSelected()) accountTypeValue = "Fixed Deposit Account";
            else if(account3.isSelected()) accountTypeValue = "Current Account";
            else if(account4.isSelected()) accountTypeValue = "Recurring Deposit Account";

            //Generating a 4-digit random PIN Number
            Random rand = new Random();
            String cardNumber = "" + Math.abs((rand.nextLong() % 90000000L) + 1244940200000000L);
            String pinNumber = "" + Math.abs((rand.nextInt() % 9000L) + 1000L);

            String servicesSelected = "";
            if(service1.isSelected()) servicesSelected += "ATM CARD";
            if(service2.isSelected()) servicesSelected += " Internet Banking";
            if(service3.isSelected()) servicesSelected += " Mobile Banking";
            if(service4.isSelected()) servicesSelected += " Email & SMS Alerts";
            if(service5.isSelected()) servicesSelected += " Cheque Book";
            if(service6.isSelected()) servicesSelected += " E-Statement";

            try{
                if(accountTypeValue.equals("")) JOptionPane.showMessageDialog(null, "Select an account type");
                else {
                    Conn c = new Conn();
                    String signupThreeQuery = "INSERT INTO signupThree VALUES ('" + formNo + "', '" + accountTypeValue + "', '" + cardNumber + "','" + pinNumber + "', '" + servicesSelected + "')";
                    String loginQuery  = "INSERT INTO login VALUES ('" + formNo + "', '" + cardNumber + "','" + pinNumber + "')";
                    c.s.executeUpdate(signupThreeQuery);
                    c.s.executeUpdate(loginQuery);

                    JOptionPane.showMessageDialog(null, "Your Card Number: " + cardNumber + "\nYour PIN: " + pinNumber);

                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            } catch(Exception error){
                System.out.println(error);
            }

        } else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
