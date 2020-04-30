/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author ASUS
 */
public class LoginMVC {
    LoginV loginview = new LoginV();
    LoginC logincontroller = new LoginC(loginview);
}
