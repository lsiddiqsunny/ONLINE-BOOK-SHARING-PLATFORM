package Workspace;

import Createaccount.InsertCustomerdata;
import Employee.employeeutil;
import Main.Getlistofsecondaryitems;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Workspace.Pdf.pdf;

public class Report {
    ObservableList<String> Year=
            FXCollections.observableArrayList(
                    "2018"
            );
    ObservableList<String> Month=
            FXCollections.observableArrayList(
                    "January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July","August",
                    "September",
                    "October",
                    "November",
                    "December"
            );
    @FXML
    private JFXComboBox<String> month=new JFXComboBox<>();

    @FXML
    private JFXComboBox<String> year=new JFXComboBox<>();

    @FXML
    private JFXButton show;

    @FXML
    private JFXButton back;

    @FXML
    private JFXComboBox<String> branch=new JFXComboBox<>();
    @FXML
    public void initialize() {

        month.setItems(Month);
        year.setItems(Year);
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

    @FXML
    void Back(ActionEvent event) {
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
    void Show(ActionEvent event) {
        try{
            String m=month.getValue();
            String y=year.getValue();
            String b=branch.getValue();
            if(m.length()==0||y.length()==0||b.length()==0)
            {Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fill Up All data");
                alert.setHeaderText("Give All Data");
                alert.setContentText("Give All Data.");
                alert.showAndWait();
                return ;
            }

            String start="",end="";
           String br= InsertCustomerdata.getBranch(b);


            if(m.equals("January")){
                start="01/01/"+y;
                end="31/01/"+y;
            }
            if(m.equals("February")){
                start="01/02/"+y;
                end="28/02/"+y;
            }
            if(m.equals("March")){
                start="01/03/"+y;
                end="31/03/"+y;
            }
            if(m.equals("April")){
                start="01/04/"+y;
                end="30/04/"+y;
            }
            if(m.equals("May")){
                start="01/05/"+y;
                end="31/05/"+y;
            }
            if(m.equals("June")){
                start="01/06/"+y;
                end="30/06/"+y;
            }
            if(m.equals("July")){
                start="01/07/"+y;
                end="31/07/"+y;
            }
            if(m.equals("August")){
                start="01/08/"+y;
                end="31/08/"+y;
            }
            if(m.equals("September")){
                start="01/09/"+y;
                end="30/09/"+y;
            }
            if(m.equals("October")){
                start="01/10/"+y;
                end="31/10/"+y;
            }
            if(m.equals("November")){
                start="01/11/"+y;
                end="30/11/"+y;
            }
            if(m.equals("December")){
                start="01/12/"+y;
                end="31/12/"+y;
            }

            List<List<String>> branches= employeeutil.getReport(br,start,end);
           pdf(branches,b,m,y);
            for(List<String> s: branches){

                for(String x:s){
                    // System.out.print(x+ " ");

                }
             //   System.out.println("");
            }

        }catch (Exception e){

            e.printStackTrace();
        }

    }
}
