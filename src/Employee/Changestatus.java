package Employee;


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


public class Changestatus {
    @FXML
    ComboBox <String> newjob=new ComboBox<>();
    ObservableList<String> Joblist =
            FXCollections.observableArrayList();
    public static  String managedkey;
    @FXML
    Button back=new Button();
    @FXML
    TextField salary=new TextField();
    @FXML
    TextField commission=new TextField();
    @FXML
    Button change=new Button();
    @FXML
    Button assign=new Button();
    @FXML
    TextArea details=new TextArea();

    @FXML
    public void Back(javafx.event.ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("employeetable.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee List");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Change(ActionEvent actionEvent) {
        String s=salary.getText();
        if(s.length()>0){
            int maxsal=employeeutil.getusermaxsalary(managedkey);
            int nowsal=Integer.parseInt(s);
            if(nowsal>maxsal){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Crossed maximum salary");
                alert.setHeaderText("Crossed maximum salary");
                alert.setContentText("Highest salary of his/her job is "+maxsal);
                alert.showAndWait();
            }
            else{
                employeeutil.updateusersalary(s,managedkey);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Salary Changed");
                alert.setHeaderText("Salary Changed");
                alert.setContentText("Salary is changed");
                alert.showAndWait();
            }


        }
        String x=commission.getText();
        if(x.length()>0){

            double now=Double.parseDouble(x);
            //  System.out.println(now);
            if(now>=1.00){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Crossed limit");
                alert.setHeaderText("Limit crossed");
                alert.setContentText("Maximum Limit is less than 1.00");
                alert.showAndWait();
            }
            else{
                employeeutil.updateusercommission(x,managedkey);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Commission Changed");
                alert.setHeaderText("Commission Changed");
                alert.setContentText("Commission is Changed");
                alert.showAndWait();
            }
        }
        try{
        String r=newjob.getValue();
        r=employeeutil.getjobid(r);
        employeeutil.updateuserjob(r,managedkey);
      //  System.out.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    public void Assign(ActionEvent actionEvent) {
        String s=details.getText();
        if(s.length()>0){
employeeutil.updateuserwork(s,managedkey,employeekey);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Work ordered");
            alert.setHeaderText("Worked ordered");
            alert.setContentText("Work listed.");
            alert.showAndWait();
        }

    }
    @FXML
    public void initialize() {
        List<List<String>> jobs= employeeutil.getJoblist1(employeeutil.getDepartment(managedkey));


        for(List<String> s: jobs){

            for(String x:s){
                //  System.out.println(x);
                Joblist.add(x);
            }
        }
        newjob.setItems(Joblist);

        salary.setPromptText(salary.getPromptText()+" "+employeeutil.getusersalary(managedkey));
        commission.setPromptText(commission.getPromptText()+" "+employeeutil.getusercommission(managedkey)+"%");
    }
}
