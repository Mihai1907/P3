package com.example.project;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddController {

    @FXML
    private Button addVolunteer;

    @FXML
    private Button back;

    @FXML
    private TextField department;

    @FXML
    private TextField email;

    @FXML
    private TextField faculty;

    @FXML
    private Button listOfVolunteersButton;

    @FXML
    private TextField name;

    @FXML
    private Label addStatus;

    @FXML
    void addVolunteer(ActionEvent event) {
        try{
            Connection conn = DBConnect.connect();
            String update = "INSERT INTO volunteers VALUES('"+
                    name.getText()+"', '"+
                    email.getText()+"', '"+
                    faculty.getText()+"', '"+
                    department.getText()+"' );";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            st.executeUpdate(update);
            addStatus.setText("Successfully added!");

        }catch(SQLException s){
            s.printStackTrace();
        }
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage scene = (Stage) back.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, 500, 500));
        scene.setTitle("Logging In");
    }

    @FXML
    void goToList(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("list_of_volunteers.fxml"));

        Stage scene = (Stage) back.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, 500, 500));
        scene.setTitle("List of volunteers");
    }


}