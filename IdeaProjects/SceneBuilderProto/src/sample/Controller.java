package sample;

import javafx.scene.control.TextField;

public class Controller
{
    public TextField userName, passwd;
    public void loginButtonClicked()
    {
        System.out.println("Login Button Clicked");
        System.out.println("userName: "+userName.getText()+"\nPassword: "+passwd.getText()+"\n");
    }
}
