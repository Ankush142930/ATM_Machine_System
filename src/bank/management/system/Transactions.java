package bank.management.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    Transactions(String pinNumber){

        this.pinNumber = pinNumber;

        //Setting custom layout
        setLayout(null);


        //Setting the background image of the ATM
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Labels
        JLabel heading = new JLabel(" Please select your transaction");
        heading.setBounds(215, 330, 700, 35);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System", Font.BOLD, 16));
        image.add(heading);

        //Buttons
        //1. Deposit button
        deposit = new JButton("Deposit");
        deposit.setBounds(175, 450, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        //2. Withdrawal button
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(350, 450, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        //3. Fast cash button
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(175, 485, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        //4. Fast cash button
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(350, 485, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        //5. Pin change button
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(175, 520, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        //6. Balance Enquiry button
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(350, 520, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        //7. Exit button
        exit = new JButton("Exit");
        exit.setBounds(350, 560, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        //Creating the Transactions frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

        //Exiting the frame upon closing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == exit){
                System.exit(0);
            } else if(e.getSource() == deposit){
                setVisible(false);
                new Deposit(pinNumber).setVisible(true);
            } else if(e.getSource() == withdrawal){
                setVisible(false);
                new Withdrawal(pinNumber).setVisible(true);
            } else if(e.getSource() == fastCash){
                setVisible(false);
                new FastCash(pinNumber).setVisible(true);
            } else if(e.getSource() == pinChange){
                setVisible(false);
                new PinChange(pinNumber).setVisible(true);
            } else if(e.getSource() == balanceEnquiry){
                setVisible(false);
                new BalanceEnquiry(pinNumber).setVisible(true);
            } else if(e.getSource() == miniStatement){
                setVisible(false);
                new MiniStatement(pinNumber).setVisible(true);
            }
        } catch (Exception error){
            System.out.println(error);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
