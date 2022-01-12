package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListController {

    @FXML
    private Button addNew;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Volunteer, String> department;

    @FXML
    private TableColumn<Volunteer, String> email;

    @FXML
    private TableColumn<Volunteer, String> faculty;

    @FXML
    private TextField searchBox;

    @FXML
    private TableColumn<Volunteer, String> name;

    @FXML
    private TableView<Volunteer> pills_table;

    @FXML
    private Button search;

    @FXML
    void addNewVol(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("list_of_volunteers.fxml"));

        Stage scene = (Stage) search.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, 400, 400));
        scene.setTitle("List of Volunteers");
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage scene = (Stage) search.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, 400, 400));
        scene.setTitle("Logging in");
    }

    @FXML
    void goSearch(ActionEvent event) {
        ObservableList<Volunteer> resultArray = FXCollections.observableArrayList();

        try{
            Connection conn = DBConnect.connect();
            String update = "SELECT * FROM pill WHERE"+
                    " Name LIKE '%"+name.getText()+
                    "%' OR Faculty LIKE '%"+faculty.getText()+
                    "%' OR Email LIKE '%"+email.getText()+
                    "%' OR Department LIKE '%"+department.getText()+"%';";

            if(searchBox.getText().equals("")) {
                update = "SELECT * FROM pill";
            }

            Statement st;
            st = conn.createStatement();
            ResultSet result = st.executeQuery(update);
            while(result.next()) {
                resultArray.add(new Volunteer(result.getString("Name"),
                        result.getString("Email"),
                        result.getString("Faculty"),
                        result.getString("Department")
                ));
            }

        }catch(SQLException s){
            s.printStackTrace();
        }

        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        faculty.setCellValueFactory(new PropertyValueFactory<>("Faculty"));
        department.setCellValueFactory(new PropertyValueFactory<>("Department"));

        pills_table.setItems(resultArray);
    }
}


