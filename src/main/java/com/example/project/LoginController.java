package com.example.project;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void onLoginButton(ActionEvent event) {
        try{
            Connection conn = DBConnect.connect();
            String update = "SELECT EXISTS (SELECT * from users where (username='" +
                    username.getText()+"') and (password='" +
                    password.getText()+"'));";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            ResultSet result = st.executeQuery(update);
            result.next();
            if(result.getInt(1)==1) {
                Connection conn_user = DBConnect.connect();
                Account.username = username.getText();
                Account.password = password.getText();

                String user = "SELECT * from users where (username='" +
                        username.getText() + "') and (password='" +
                        password.getText() + "');";
                Statement st_user;
                System.out.println(user);
                st_user = conn_user.createStatement();
                ResultSet res = st_user.executeQuery(user);
                res.next();

            }

        }catch(SQLException s){
            s.printStackTrace();
        }
    }



}
