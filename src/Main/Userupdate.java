package Main;

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

public class Userupdate {

    @FXML
     PasswordField password=new PasswordField();

    @FXML
    TextField phone=new TextField();

    @FXML
    Button backbutton=new Button();

    @FXML
    TextField name=new TextField();

    @FXML
  Button submitbutton=new Button();

    @FXML
     Button resetbutton=new Button();

    @FXML
    ComboBox branch=new ComboBox();

    @FXML
   TextField email=new TextField();

    @FXML
    ComboBox Location=new ComboBox();

    @FXML
    void submit(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {
        name.clear();
        email.clear();
        phone.clear();
        password.clear();


    }

    @FXML
    void back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("User.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Customer Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void ALERT(String mssg){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update Successful");
        alert.setHeaderText("Update Successful");
        alert.setContentText(mssg+" Updated Successfully.");
        alert.showAndWait();
    }
    void NegALERT(String mssg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Update Failed");
        alert.setHeaderText("Update Failed");
        alert.setContentText(mssg+" Updated Failed.");
        alert.showAndWait();
    }
    @FXML
    void submitupdate(ActionEvent event) {
        String Name=name.getText();
      if(Name.length()!=0){

          if(updatedatabase.setName(Name,User.userkey,"CUSTOMER_NAME")){
              ALERT("Customer Name");
          }
          else{
              NegALERT("Customer Name");
          }
      }
        String Email=email.getText();
        if(Email.length()!=0){

            if(updatedatabase.setName(Email,User.userkey,"email")){
                ALERT("Email");
            }
            else{
                NegALERT("Email");
            }
        }
        String Phone=phone.getText();
        if(Phone.length()!=0){

            if(updatedatabase.setName(Phone,User.userkey,"phone_number")){
                ALERT("Phone Number");
            }
            else{
                NegALERT("Phone Number");
            }
        }
        String Pass=password.getText();
        if(Pass.length()!=0){

            if(updatedatabase.setName(Pass,User.userkey,"password")){
                ALERT("Password");
            }
            else{
                NegALERT("Password");
            }
        }
        try{
            String Loc=Location.getValue().toString();
            Loc=InsertCustomerdata.getLocation(Loc);


                if(updatedatabase.setName(Loc,User.userkey,"Location_id")){
                    ALERT("Location");
                }
                else{
                    NegALERT("Location");
                }


        }catch (Exception e){
            System.out.println(e.toString());
        }
        try{
            String Branch=branch.getValue().toString();
            Branch=InsertCustomerdata.getBranch(Branch);


            if(updatedatabase.setName(Branch,User.userkey,"Branch_id")){
                ALERT("Branch");
            }
            else{
                NegALERT("Branch");
            }


        }catch (Exception e){
            System.out.println(e.toString());
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
        List<List<String>> branches= Getlistofsecondaryitems.getAllBranch();
        ObservableList<String> branchlist =FXCollections.observableArrayList();

        for(List<String> s: branches){

            for(String x:s){
                //  System.out.println(x);
                branchlist.add(x);
            }
        }
        branch.setItems(branchlist);

    }

}
