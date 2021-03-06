package Main;


import Customer.User;
import Customer.Users;
import Employee.Employee;
import Publisher.Publisher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static Book.SearchBook.end;
import static Book.SearchBook.start;


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
    Button forgetpassword=new Button();
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
          //    System.out.println(combotext+" "+userName+" "+password);
            boolean success = new Users().validateLogin(combotext,userName, password);
            if (success)
            {
                // successful login
                try
                {

                    switch (combotext) {
                        case "Customer": {

                            User.userkey = userName;
                            Stage stage;
                            Parent root;
                            stage = (Stage) loginbutton.getScene().getWindow();
                            //load up OTHER FXML document
                            try {
                                start=0;
                                end=0;
                                root = FXMLLoader.load(getClass().getResource("../Customer/customer.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.setTitle("Customer Account");
                                stage.show();


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        case "Publisher": {
                            Publisher.publisherkey = userName;
                            Stage stage;
                            Parent root;
                            stage = (Stage) loginbutton.getScene().getWindow();
                            //load up OTHER FXML document
                            try {
                                root = FXMLLoader.load(getClass().getResource("../Publisher/publisher.fxml"));
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.setTitle("Publisher Account");
                                stage.show();


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        }
                        default: {
                            Employee.employeekey = userName;
                            Stage stage;
                            Parent root;
                            stage = (Stage) loginbutton.getScene().getWindow();
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
                            break;
                        }
                    }
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
            root = FXMLLoader.load(getClass().getResource("../Createaccount/newaccount.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("New Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Forgetpassword(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) forgetpassword.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Forgetpassword/forgetpassword.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Forget Password");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
