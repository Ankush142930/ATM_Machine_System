package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pinNumber;
    JTextField amountTextField;
    JButton withdrawal, back;

    Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;

        //Setting the custom layout
        setLayout(null);

        //Setting the atm pic in background
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Labels
        //Labels
        //1. Heading
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(190, 330, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //TextFields
        //1. Amount Text Field
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("System", Font.BOLD, 22));
        amountTextField.setBounds(190, 400, 285, 40);
        image.add(amountTextField);

        //Buttons
        //1. Withdrawal Button
        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(350, 520, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);


        //2. Back Button
        back = new JButton("Back");
        back.setBounds(350, 560, 150, 30);
        back.addActionListener(this);
        image.add(back);

        //Creating the frame
        setSize(900, 900);
        setBounds(300, 0, 900, 900);
        setUndecorated(true);
        setVisible(true);

        //Exiting upon closing the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == withdrawal){
            String amount = amountTextField.getText();
            Date date = new Date();

            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please the amount to be withdrawn");
            } else {
                try{
                    Conn c = new Conn();

                    ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '"+pinNumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else{
                            balance -= Integer.parseInt(rs.getString("amount"));

                        }
                    }

                    System.out.println(balance);
                    if(e.getSource() != back && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient balance");
                        return;
                    }

                    String query = "INSERT INTO bank VALUES ('" + pinNumber + "', '" + date + "', 'Withdrawal','" + amount + "')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. '" + amount + "' withdrawn successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception error){
                    System.out.println(error);
                }
            }
        } else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
