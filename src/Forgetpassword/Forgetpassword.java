package Forgetpassword;

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

public class Forgetpassword {

    @FXML
    Button check=new Button();
    @FXML
    Button back=new Button();
    @FXML
    Button reset=new Button();
    @FXML
    Button submit=new Button();
    @FXML
    TextField customer=new TextField();
    @FXML
    TextField email=new TextField();
    @FXML
    TextField phone=new TextField();
    @FXML
    PasswordField password=new PasswordField();
    @FXML
    void Check(ActionEvent actionEvent) {
        List<List<String>> admin= admininfo.admin();

        String list="";
        for(List<String> s: admin){

            for(String x:s){
                // System.out.println(x);
                list=list+x+"\n\n";

            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Database Admin List");
        alert.setHeaderText("Contact with one of the following list");
        alert.setContentText(list);
        alert.showAndWait();

    }
    @FXML
    void Submit(ActionEvent actionEvent) {
       String customerid=customer.getText();
       String Email=email.getText();
       String Phone=phone.getText();
       String pass=password.getText();
       if(customerid.isEmpty()||Email.isEmpty()||Phone.isEmpty()||pass.isEmpty())
       {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Empty Fields");
           alert.setHeaderText("Fiil Up All Fields");
           alert.setContentText("Fill Up All Fields to Reset your password");
           alert.showAndWait();
       }
      //
       if(Email.equals(admininfo.getEmail(customerid))){

           if(Phone.endsWith(admininfo.getPhone(customerid))){
               if(admininfo.updatePass(pass,customerid)){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Password Reset Operation Successful");
                   alert.setHeaderText("Password Reset Operation Successful");
                   alert.setContentText("Your New Password: "+pass+"\nPlease Remember This Password.");
                   alert.showAndWait();
               }else{
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Password Reset Operation Unsuccessful");
                   alert.setHeaderText("Password Reset Operation Unsuccessfu");
                   alert.setContentText("We can not reset your password.\nConnect nearby branch.");
                   alert.showAndWait();

               }

           }
           else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Wrong Phone Number");
               alert.setHeaderText("Wrong Phone Number");
               alert.setContentText("Give the Right Phone Number to Reset Your Password");
               alert.showAndWait();
           }

       }else{
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Wrong Email");
           alert.setHeaderText("Wrong Email Address");
           alert.setContentText("Give the Right Email Address to Reset Your Password");
           alert.showAndWait();
       }

    }
    @FXML
    void Reset(ActionEvent actionEvent) {
       password.clear();
       customer.clear();
       email.clear();
       phone.clear();
    }
    @FXML
    void Back(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Main/Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Home Page");
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {





    }
}
