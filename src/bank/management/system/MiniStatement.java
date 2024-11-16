package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNumber;
    JButton back;

    MiniStatement(String pinNumber){

        this.pinNumber = pinNumber;

        //Setting custom layout
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
        JLabel text = new JLabel("Your Last 5 Transactions");
        text.setBounds(240, 330, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //2. Card Number
        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(200, 365, 300, 30);
        cardNumber.setForeground(Color.white);
        cardNumber.setFont(new Font("System", Font.BOLD, 16));
        image.add(cardNumber);

        //Logic to query card Number and display it
        Conn c = new Conn();
        String cardNumberQuery = "SELECT * FROM login WHERE pinNumber = '"+pinNumber+"'";
        try{
            ResultSet rs = c.s.executeQuery(cardNumberQuery);
            while(rs.next()){
                String card = rs.getString("cardNumber");
                String lastDigits = card.substring(card.length()-4, card.length());
                cardNumber.setText("Card Number: XXXX-XXXX-XXXX-"+lastDigits+"" );
            }

        } catch(Exception error){
            System.out.println(error);
        }

        //3. Logic to query last 5 transactions and display it
        JLabel statements = new JLabel();
        statements.setBounds(200, 395, 700, 100);
        statements.setFont(new Font("System", Font.BOLD, 12));
        statements.setForeground(Color.white);
        image.add(statements);
        int transactions = 0;
        String transactionsQuery = "SELECT * FROM bank WHERE pinNumber = '"+pinNumber+"' ORDER BY date DESC LIMIT 0,5";
        try{
            ResultSet rs2 = c.s.executeQuery(transactionsQuery);
            while(rs2.next()){
                statements.setText(statements.getText() + "<html>" + rs2.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("type") + (rs2.getString("type").equals("Deposit") ?"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") + rs2.getString("amount") + "<br>" +  "<html>");
                transactions++;
            }

            if(transactions == 0){
                statements.setText("!!! You have not done transactions yet !!!");
            }
        } catch(Exception error){
            System.out.println(error);
        }

        //4. Logic to query current balance and display it
        JLabel balanceLabel = new JLabel();
        balanceLabel.setBounds(220, 465, 700, 100);
        balanceLabel.setFont(new Font("System", Font.BOLD, 18));
        balanceLabel.setForeground(Color.white);
        image.add(balanceLabel);
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

        balanceLabel.setText("Current Balance: Rs. "+balance+"");

        //Buttons
        //1. Back button
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

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
