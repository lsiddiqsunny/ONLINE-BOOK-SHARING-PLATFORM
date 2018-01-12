package Workspace;

import Employee.employeeutil;
import Main.Getlistofsecondaryitems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Notice {
    @FXML
    Button notice=new Button();
    @FXML
    Button showactive=new Button();
    @FXML
    Button back=new Button();
    @FXML
    ComboBox joblist=new ComboBox();
    @FXML
    TextArea mssg=new TextArea();
    ObservableList<String> Joblist =
            FXCollections.observableArrayList();
    @FXML
    void Notice(ActionEvent event){

        String job=null;
        try{
            job=joblist.getValue().toString();
            job=employeeutil.getjobid(job);
            System.out.println(job);
            String b=employeeutil.getuserBranch(employeekey);
            String  mg=mssg.getText();
           // System.out.println(mg);
            if(mg.length()>0) {
                employeeutil.noticetojob(mg, employeekey, b, job);


            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Notice Published");
            alert.setHeaderText("Notice Published");
            alert.setContentText("Notice Sent to This Job Holder");
            alert.showAndWait();

        }catch (Exception e){
            String b=employeeutil.getuserBranch(employeekey);
            String  mg=mssg.getText();
            // System.out.println(mg);
            if(mg.length()>0) {
               // employeeutil.noticetoall(mg, employeekey, b);
                if(job==null){
                //    System.out.println("here");
                    employeeutil.NoticeAll(employeekey,b,mg);
                }
               // employeeutil.nullnotice();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Notice Published");
            alert.setHeaderText("Notice Published");
            alert.setContentText("Notice Sent to All");
            alert.showAndWait();
        }
    }
    @FXML
    void Showactive(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("activenotice.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Active Notices");
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
            root = FXMLLoader.load(getClass().getResource("managingderector.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {

        List<List<String>> jobs= employeeutil.getJoblist(employeekey);


        for(List<String> s: jobs){

            for(String x:s){
                //  System.out.println(x);
                Joblist.add(x);
            }
        }
        joblist.setItems(Joblist);




    }

}
