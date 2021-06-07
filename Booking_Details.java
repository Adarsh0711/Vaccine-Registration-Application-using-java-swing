package fines;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Booking_Details extends JFrame implements ActionListener{

    JButton b1;
    JLabel l1;
    Booking_Details(String password){
        super("Slot Booking Details");
        getContentPane().setBackground(Color.cyan);
        setSize(400,450);
        setLocation(600,200);

        l1 = new JLabel();
        add(l1);

        JLabel l2 = new JLabel("Please visit in the alloted timings only");
        l2.setBounds(30, 20, 400, 20);
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 120, 300, 20);
        add(l4);

        JLabel l5 = new JLabel();
        l5.setBounds(20, 160, 300, 20);
        add(l5);

        JLabel l6 = new JLabel();
        l6.setBounds(20, 200, 300, 20);
        add(l6);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where password = '"+password+"'");
            while(rs.next()){
                l3.setText("User Name:    " + rs.getString("applicationno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{

            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM registrations where password = '"+password+"'");
            while(rs.next()){
                l4.setText("Center:    " + rs.getString("Center"));
                l5.setText("Date:    " + rs.getString("Date"));
                l6.setText("Time:    " + rs.getString("Time"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        l1.setBounds(20, 140, 400, 200);

        b1.setBounds(20, 340, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    public static void main(String[] args){
        new Booking_Details("").setVisible(true);
    }

}
