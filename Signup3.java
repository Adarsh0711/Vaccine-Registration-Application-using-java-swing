package fines;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l10,l11,l12;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    JTextField t1,t2;
    Signup3(String formno){
        this.formno = formno;
        setTitle("VACCINE REGISTRATION FORM - PAGE 3");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fines/icons/abc.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("User Name:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));

        l3 = new JLabel("Password:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));

        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));

        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);

        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));

        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));



        c1 = new JCheckBox("Health CheckUp");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));

        c2 = new JCheckBox("Covid-19 Test");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));

        c3 = new JCheckBox("Vaccination");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));

        c4 = new JCheckBox("Vaccination for family");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));

        c5 = new JCheckBox("Oxygen Services");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));

        c6 = new JCheckBox("Request for Home Vaccination");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));

        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));

        setLayout(null);

        l11.setBounds(700,10,70,30);
        add(l11);

        l12.setBounds(770,10,40,30);
        add(l12);

        l1.setBounds(280,40,400,40);
        add(l1);

        l2.setBounds(100,120,200,30);
        add(l2);

        l3.setBounds(100,170,100,30);
        add(l3);

        l10.setBounds(100,240,200,30);
        add(l10);

        c1.setBounds(100,280,200,30);
        add(c1);

        c2.setBounds(350,280,200,30);
        add(c2);

        c3.setBounds(100,320,200,30);
        add(c3);

        c4.setBounds(350,320,400,30);
        add(c4);

        c5.setBounds(100,360,200,30);
        add(c5);

        c6.setBounds(350,360,400,30);
        add(c6);

        c7.setBounds(100,450,600,20);
        add(c7);

        b1.setBounds(250,500,100,30);
        add(b1);

        b2.setBounds(420,500,100,30);
        add(b2);

        t1.setBounds(350,120,320,30);
        add(t1);

        t2.setBounds(350,170,320,30);
        add(t2);

        getContentPane().setBackground(Color.lightGray);

        setSize(850,600);
        setLocation(400,120);
        setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae){
        String applicationno = t1.getText();
        String password = t2.getText();

        String facility = "";
        if(c1.isSelected()){
            facility = facility + "Health CheckUp";
        }
        if(c2.isSelected()){
            facility = facility + "Covid-19 Test";
        }
        if(c3.isSelected()){
            facility = facility + "Vaccination";
        }
        if(c4.isSelected()){
            facility = facility + "Vaccination for family";
        }
        if(c5.isSelected()){
            facility = facility + "Oxygen Services";
        }
        if(c6.isSelected()){
            facility = facility + "Request for Home Vaccination";
        }
        try{
            Conn c1 = new Conn();
            if(password.length()>=5 && password.length()<=20) {
                String q1 = "insert into signup3 values('" + formno + "','" + applicationno + "','" + password + "','" + facility + "')";
                String q2 = "insert into login values('" + formno + "','" + applicationno + "','" + password + "')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Application_No: " + applicationno + "\n Password:" + password);
                new Login().setVisible(true);
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid Password");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }

}


