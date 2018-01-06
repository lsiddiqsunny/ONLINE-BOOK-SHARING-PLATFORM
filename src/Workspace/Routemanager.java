package Workspace;

import Employee.employeeutil;
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

public class Routemanager {
    @FXML
    private ComboBox<String> driver=new ComboBox<>();

    @FXML
    private Button workdriver=new Button();

    @FXML
    private ComboBox<String > mechanic;

    @FXML
    private Button back=new Button();

    @FXML
    private Button workmechanic=new Button();

    @FXML
    private Button situation=new Button();
    @FXML
    TextArea mechanicdetails=new TextArea();
    @FXML
    TextArea driverdetails=new TextArea();

    @FXML
    void Workmechanic(ActionEvent event) {
        String x=mechanicdetails.getText();
        if(x!=null){
            String p=mechanic.getValue();
            if(p!=null){
                String[]  y=p.split("-");
                p=y[0];
              //  System.out.println(p);
                employeeutil.updateuserwork(x,p,employeekey);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Order Assigned");
                alert.setHeaderText("Order Assigned");
                alert.setContentText("Order assigned to the mechanic");
                alert.showAndWait();
            }
        }

    }

    @FXML
    void Workdriver(ActionEvent event) {
        String x=driverdetails.getText();
        if(x!=null){
            String p=driver.getValue();
            if(p!=null){
                String[]  y=p.split("-");
                p=y[0];
                //  System.out.println(p);
                employeeutil.updateuserwork(x,p,employeekey);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Order Assigned");
                alert.setHeaderText("Order Assigned");
                alert.setContentText("Order assigned to the driver");
                alert.showAndWait();
            }
        }
    }

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
    void Situation(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) situation.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("works.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Work Situation");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {

        ObservableList<String> typelist =
                FXCollections.observableArrayList();
        List<List<String>> types= employeeutil.getDriver(employeeutil.getuserBranch(employeekey));


        for(List<String> s: types){
            String p="";
            int co=0;
            for(String x:s){

                if(co==0)
                    p=x+"-";
                else p=p+x;
                co++;
            }
            typelist.add(p);
        }
        driver.setItems(typelist);
        ObservableList<String> typelist1 =
                FXCollections.observableArrayList();
        List<List<String>> types1= employeeutil.getMechanic(employeeutil.getuserBranch(employeekey));


        for(List<String> s: types1){
            String p="";
            int co=0;
            for(String x:s){

                if(co==0)
                    p=x+"-";
                else p=p+x;
                co++;
            }
            typelist1.add(p);
        }
        mechanic.setItems(typelist1);


    }
}
