package MVC;


import java.awt.TextField;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class LoginV extends JFrame {
   JLabel ljudul, luname, lpw;
   TextField txuname;
   JPasswordField txpw;
   JButton login;
   
    public LoginV(){
        setTitle("LOGIN");
        ljudul = new JLabel("LOGIN ADMIN");
        luname = new JLabel("Username:");
        lpw = new JLabel("Password:");
        txuname = new TextField();
        txpw = new JPasswordField();
        login = new JButton("Login");
        
        setLayout(null);
        add(ljudul);
        add(luname);
        add(lpw);
        add(txuname);
        add(txpw);
        add(login);
        
        ljudul.setBounds(110, 30, 90, 20);
        luname.setBounds(40, 80, 70, 20);
        txuname.setBounds(120, 80, 120, 20);
        lpw.setBounds(40, 110, 70, 20);
        txpw.setBounds(120, 110, 120, 20);
        login.setBounds(105, 160, 80, 20);
        
        setSize(300,275);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getUname(){
        return txuname.getText();
    }
    
    public String getPw(){
         String pw = new String(txpw.getPassword());
         return pw;
    }
}

