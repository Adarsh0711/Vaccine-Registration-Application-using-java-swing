package fines;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Registrations extends JFrame implements ActionListener {
    String pasword;

    JLabel l1,l2,l3,l4,l5,l6,l12,l13;
    JButton b;
    JComboBox c1,c2,c3,c4,c5;

    Registrations(String password){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fines/icons/abc.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(170, 0, 100, 100);
        add(l14);


        this.pasword = password;
        setTitle("Book Your Slot");

        l1 = new JLabel("Slot Booking");
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("Center:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Age Group:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l4 = new JLabel("Date");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));

        l5 = new JLabel("Time");
        l5.setFont(new Font("Raleway", Font.BOLD, 18));

        l6 = new JLabel("Number of people:");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));


        b = new JButton("Book the slot");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.BLACK);


        String Center[] = {"Center A","Center B","Center C","Center D","Center E","Center F"};
        c1 = new JComboBox(Center);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String age_group[] = {"0-18","18-45","above 45"};
        c2 = new JComboBox(age_group);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String Date[] = {"May 17","May 18","May 19","May 20","May 21","May 23","May 24"};
        c3 = new JComboBox(Date);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));

        String Time[] = {"6 AM","6:30 AM","7 AM","7:30 AM","8 AM","8:30 AM","9 AM","9:30 AM","10 AM"};
        c4 = new JComboBox(Time);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));

        String Number[] = {"1","2","3","4"};
        c5 = new JComboBox(Number);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));
        setLayout(null);

        l1.setBounds(280,30,600,40);
        add(l1);

        l2.setBounds(100,120,100,30);
        add(l2);

        c1.setBounds(350,120,320,30);
        add(c1);

        l3.setBounds(100,170,200,30);
        add(l3);

        c2.setBounds(350,170,320,30);
        add(c2);

        l4.setBounds(100,220,100,30);
        add(l4);

        c3.setBounds(350,220,320,30);
        add(c3);

        l5.setBounds(100,270,150,30);
        add(l5);

        c4.setBounds(350,270,320,30);
        add(c4);

        l6.setBounds(100,320,200,30);
        add(l6);

        c5.setBounds(350,320,320,30);
        add(c5);

        b.setBounds(400,400,200,30);
        add(b);

        b.addActionListener(this);

        getContentPane().setBackground(Color.pink);

        setSize(850,500);
        setLocation(400,120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String Center = (String) c1.getSelectedItem();
        String age_group = (String) c2.getSelectedItem();
        String Date = (String) c3.getSelectedItem();
        String Time = (String) c4.getSelectedItem();
        String Number = (String) c5.getSelectedItem();
        try{
            Conn c1 = new Conn();
            String q1 = "insert into Registrations values('"+pasword+"','"+Center+"','"+age_group+"','"+Date+"','"+Time+"','"+Number+"')";
            c1.s.executeUpdate(q1);
            new Booking_Details(pasword).setVisible(true);
            setVisible(false);
        }
       catch(Exception ex){
        ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Registrations("").setVisible(true);
    }
}


