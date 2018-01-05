package Workspace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Bookkeeper {


    @FXML
    private Button edit=new Button();

    @FXML
    private Button back=new Button();

    @FXML
    private Button insert=new Button();

    @FXML
    private Button newbook=new Button();

    @FXML
    void Back(ActionEvent event) {
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
    void Edit(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) edit.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("editreq.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Request");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Insert(ActionEvent event) {

        Stage stage;
        Parent root;
        stage = (Stage) insert.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("newbookinsert.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Insert New Book");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Newbook(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) newbook.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("newbook.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
