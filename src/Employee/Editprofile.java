package Employee;

import Createaccount.InsertCustomerdata;
import Main.Getlistofsecondaryitems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;
import static Publisher.Publisher.publisherkey;

public class Editprofile {
    @FXML
    ComboBox Location=new ComboBox();
    @FXML
    TextField phone=new TextField();
    @FXML
    TextField email=new TextField();
    @FXML
    PasswordField Password=new PasswordField();
    @FXML
    Button backbutton=new Button();
    @FXML
    Button submit=new Button();
    @FXML
    Button reset=new Button();
    @FXML
    void Reset(ActionEvent event) {
        Password.clear();
        phone.clear();
        email.clear();

    }
    @FXML
    void Submit(ActionEvent event) {

        String userpass=Password.getText();
        String locationid=null;
        String P=phone.getText();
        String e=email.getText();

        try{
            locationid= Location.getValue().toString();
            locationid= InsertCustomerdata.getLocation(locationid);
            // System.out.println(locationid);
            employeeutil.setName(locationid,employeekey,"Location_id");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Address changed");
            alert.setHeaderText("Address changed");
            alert.setContentText("Address updated successful.");
            alert.showAndWait();

        }catch (Exception ex){


        }

        if(userpass.length()!=0){
            employeeutil.setName(userpass,employeekey,"Password");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Password changed");
            alert.setHeaderText("Password changed");
            alert.setContentText("Password updated successfully.");
            alert.showAndWait();
        }
        if(P.length()!=0){
            employeeutil.setName(P,employeekey,"Phone_number");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Phone Number changed");
            alert.setHeaderText("Phone Number changed");
            alert.setContentText("Phone Number updated successfully.");
            alert.showAndWait();
        }

        if(e.length()!=0){
            employeeutil.setName(e,employeekey,"Email");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Email changed");
            alert.setHeaderText("Email changed");
            alert.setContentText("Email updated successfully.");
            alert.showAndWait();
        }




    }
    @FXML
    void Backbutton(ActionEvent actionEvent){
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee Account");

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        ObservableList<String> locationlist =
                FXCollections.observableArrayList();
        List<List<String>> locations= Getlistofsecondaryitems.getAllLocation();


        for(List<String> s: locations){

            for(String x:s){
                //  System.out.println(x);
                locationlist.add(x);
            }
        }
        Location.setItems(locationlist);



    }
}
