package Workspace;

import Createaccount.InsertCustomerdata;
import Employee.employeeutil;
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

public class Addemployee {
    @FXML
    private CheckBox iskeeper=new CheckBox();

    @FXML
    private PasswordField password=new PasswordField();

    @FXML
    private ComboBox<String> manager=new ComboBox<>();

    @FXML
    private Button submit=new Button();

    @FXML
    private TextField phone=new TextField();

    @FXML
    private TextField name=new TextField();

    @FXML
    private Button back=new Button();

    @FXML
    private ComboBox<String> Location=new ComboBox<>();

    @FXML
    private ComboBox<String> job=new ComboBox<>();

    @FXML
    private TextField email=new TextField();

    @FXML
    void Job(ActionEvent event) {
        String x1=employeeutil.getJob(job.getValue());
        //   System.out.println(x1);

        ObservableList<String> locationlist =
                FXCollections.observableArrayList();
        List<List<String>> locations= employeeutil.getAllManager(x1,employeeutil.getuserBranch(employeekey));


        for(List<String> s: locations){

            for(String x:s){
                //  System.out.println(x);
                locationlist.add(x);
            }
        }
        manager.setItems(locationlist);
    }

    @FXML
    void Submit(ActionEvent event) {
        String [] a=new String[9] ;
        a[0] = name.getText();
        a[1] = email.getText();
        a[2]= phone.getText();
        a[3] = password.getText();
        a[4]= InsertCustomerdata.getLocation(Location.getValue());
        a[5]= employeeutil.getJob(job.getValue());
        a[7]=employeeutil.getEmployee(manager.getValue());
        a[6] =employeeutil.getuserBranch(employeekey);
        a[8]=employeeutil.getMinSal(a[5]);
        boolean ok=true;
        for(int i=0;i<9;i++){
            //System.out.println(a[i]);
            if(a[i].length()==0||a[i]==null)
            {   ok=false;  Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fill Up All Data");
                alert.setHeaderText("Please Fill Up All Data");
                alert.setContentText("All Information Is Required.");
                alert.showAndWait(); break;
            }


        }
        if(ok){
            employeeutil.Insertemployee(a);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Account Created");
            alert.setHeaderText("Account Created");
            alert.setContentText("A mail has been to the employee");
            alert.showAndWait();
        }

    }

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("clerk.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
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
        ObservableList<String> joblist =
                FXCollections.observableArrayList();
        List<List<String>> jobs= employeeutil.getAllJob();


        for(List<String> s: jobs){

            for(String x:s){
                //  System.out.println(x);
                joblist.add(x);
            }
        }

        job.setItems(joblist);

    }
}
