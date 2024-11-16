package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinNumber;
    JButton back;

    BalanceEnquiry(String pinNumber){

        this.pinNumber = pinNumber;

        //Setting custom Layout
        setLayout(null);

        //Setting atm picture in the background
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Labels
        //1. Heading
        JLabel text = new JLabel("Balance Enquiry");
        text.setBounds(270, 330, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);


        //Logic for displaying Balance
        Conn c = new Conn();
        String query = "SELECT * FROM bank WHERE pinNumber = '"+pinNumber+"'";
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if(rs.getString("type").equals("Withdrawal")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception error){
            System.out.println(error);
        }

        //2. Balance
        JLabel bal = new JLabel("Your account balance is:");
        bal.setBounds(225, 400, 300, 30);
        bal.setForeground(Color.white);
        bal.setFont(new Font("System", Font.BOLD, 18));
        image.add(bal);
        JLabel bal2 = new JLabel("Rs. " + balance);
        bal2.setBounds(280, 460, 300, 30);
        bal2.setForeground(Color.white);
        bal2.setFont(new Font("System", Font.BOLD, 25));
        image.add(bal2);

        //Buttons
        //1. Back button
        back = new JButton("Back");
        back.setBounds(350, 560, 150, 30);
        back.addActionListener(this);
        image.add(back);



        //Creating the frame
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

        //Exiting upon closing application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
