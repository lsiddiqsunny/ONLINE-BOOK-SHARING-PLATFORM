package Main;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static Main.newaccount.*;


public class Controller {


    @FXML
    ComboBox loginas=new ComboBox();
    @FXML
    Text loginalert=new Text();
    @FXML
    TextField userid=new TextField();
    @FXML
    PasswordField userpassword=new PasswordField();
    @FXML
    Button loginbutton=new Button();
    @FXML
    Button resetbutton=new Button();
    @FXML
    Button newcustomer=new Button();
    ObservableList<String> loginoptions =
            FXCollections.observableArrayList(
                    "Customer",
                    "Employee",
                    "Publisher"
            );

    @FXML
    public void initialize() {

        loginas.setItems(loginoptions);

    }
    @FXML
    void Login(ActionEvent actionEvent) {
        try {
            String combotext = loginas.getValue().toString();

            String userName=userid.getText();
            String password=userpassword.getText();
            //  System.out.println(combotext+" "+userName+" "+password);
            boolean success = new Users().validateLogin(combotext,userName, password);
            if (success)
            {
                // successful login
                try
                {

                    loginalert.setText("Success");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Correct Credentials");
                    alert.setHeaderText("Correct Credentials");
                    alert.setContentText("Login Successful!");
                    alert.showAndWait();
                } catch (Exception e)
                {
                    loginalert.setText(e.toString());
                }

            } else
            {
                // failed login
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The username and password you provided is not correct.");
                alert.showAndWait();
            }

        }catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incomplete Field");
            alert.setHeaderText("Incomplete Field");
            alert.setContentText("Login as field is incomplete");
            alert.showAndWait();

        }

    }
    @FXML
    void Reset(ActionEvent actionEvent) {
        userid.clear();
        userpassword.clear();
    }
    @FXML
    void newaccount(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) newcustomer.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("newaccount.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("New Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
