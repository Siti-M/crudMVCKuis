/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LoginC {
    LoginV loginview;
    public LoginC(LoginV loginview){
        this.loginview = loginview;
        
        loginview.login.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent ae) {
             String uname = loginview.getUname();
             String pw = loginview.getPw();
                
                if(uname.isEmpty() || pw.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi field yang masih kosong! ");
                } else if (uname.equals("admin") && pw.equals("123")){
                    loginview.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    new FMVC();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password Salah");
                }
            }
        });
    }
}
