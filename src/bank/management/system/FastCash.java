package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pinNumber;
    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;


    FastCash(String pinNumber){

        this.pinNumber = pinNumber;

        //Setting the custom layout
        setLayout(null);

        //Setting atm pic as background
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel image = new JLabel(image3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        //Labels
        //1. Heading
        JLabel text = new JLabel("Select Withdrawal amount");
        text.setBounds(230, 330, 700, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        //Buttons
        //1. Deposit button
        hundred = new JButton("Rs. 100");
        hundred.setBounds(175, 450, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

        //2. Withdrawal button
        fiveHundred = new JButton("Rs. 500");
        fiveHundred.setBounds(350, 450, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        //3. Fast cash button
        thousand = new JButton("Rs. 1000");
        thousand.setBounds(175, 485, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);

        //4. Fast cash button
        twoThousand = new JButton("Rs. 2000");
        twoThousand.setBounds(350, 485, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        //5. Pin change button
        fiveThousand = new JButton("Rs. 5000");
        fiveThousand.setBounds(175, 520, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        //6. Balance Enquiry button
        tenThousand = new JButton("Rs. 10000");
        tenThousand.setBounds(350, 520, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        //7. Back button
        back = new JButton("Back");
        back.setBounds(350, 560, 150, 30);
        back.addActionListener(this);
        image.add(back);

        //Creating the frame
        setSize(900, 900);
        setBounds(300, 0, 900, 900);
        setUndecorated(true);
        setVisible(true);

        //Exiting upon closing of application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        Date date = new Date();
        Conn c = new Conn();
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String btnText = ((JButton) e.getSource()).getText();
            String amount = btnText.substring(4, btnText.length());
            try{
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                String query = "INSERT INTO bank VALUES ('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. "+amount+" withdrawn successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch(Exception error){
                System.out.println(error);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
