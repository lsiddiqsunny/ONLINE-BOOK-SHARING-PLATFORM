package Workspace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Managingderector {
    @FXML
    Button underpeople=new Button();
    @FXML
    Button back=new Button();
    @FXML
    Button work=new Button();
    @FXML
    Button notice=new Button();
    @FXML
    void Notice(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage) notice.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("notice.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Notice");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Back(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Employee/Employee.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Work(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage) work.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Works.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Order List");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Underpeople(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) underpeople.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Employee/employeetable.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee List");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
