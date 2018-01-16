package Createaccount;

import Main.Getlistofsecondaryitems;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Created by Latif Siddiq Suuny on 01-Dec-17.
 */
public class newaccount {
    ObservableList<String> district =FXCollections.observableArrayList(
            "Dhaka",
            "Chittagong",
            "Comilla",
            "Dinajpur",
            "Bogra",
            "Joypurhat",
            "Sylhet",
            "Noakhali"
    );

    @FXML
    TextField street=new TextField();
    @FXML
    ComboBox<String> post=new ComboBox(
    );

    @FXML
    ComboBox branch=new ComboBox();
    @FXML
    PasswordField password=new PasswordField();

    @FXML
    TextField phone=new TextField();

    @FXML
    TextField name=new TextField();

    @FXML
    ComboBox Location=new ComboBox();
    @FXML
    TextField email=new TextField();
    @FXML
    Button submitbutton=new Button();

    @FXML
    Button resetbutton=new Button();

    @FXML
    Button back=new Button();
    @FXML
    Text Alert=new Text();
    @FXML
    void submit(ActionEvent event) {
        String username=name.getText();
        String useremail=email.getText();
        String userphone=phone.getText();
        String userpass=password.getText();
        String locationid=null;
        String branchid=null;
        String Post=null;
        String Street=street.getText();
        try{
            locationid= Location.getValue().toString();


        }catch (Exception e){
            Alert.setText("Enter All Data");

        }
        try{
            branchid= branch.getValue().toString();}
        catch (Exception e){
            Alert.setText("Enter All Data");
        }
        try{
            Post= post.getValue().toString();}
        catch (Exception e){
            Alert.setText("Enter All Data");
        }
        if(username.isEmpty()||useremail.isEmpty()||userpass.isEmpty()||userphone.isEmpty()||Street.isEmpty())
            Alert.setText("Enter All Data");
        else {

           locationid=InsertCustomerdata.getLocation(Street +","+Post+","+locationid);
            //System.out.println(locationid);
            if(locationid.equals("$")){
             //   System.out.println(Street + " "+Post+" "+Location.getValue());
                InsertCustomerdata.InsertLocation(Street, Post,Location.getValue().toString());
                locationid=InsertCustomerdata.getLocation(Street +","+Post+","+Location.getValue().toString());
              //  System.out.println(locationid);
                if(locationid.equals("$")){
                    locationid=String .valueOf(new Random(100).nextInt(100));
                }

            }
            InsertCustomerdata.Inserdata(username,userpass,useremail,userphone,locationid,branchid);

        }


    }
    @FXML
    void Backbutton(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Main/Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Home page");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void reset(ActionEvent event) {
        name.clear();email.clear();phone.clear();password.clear();
        street.clear();

    }

    @FXML
    public void initialize() {
        Location.setItems(district);
        ObservableList<String> postcode =FXCollections.observableArrayList();

        for(int i=1200;i<=1300;i++){
            postcode.add(String .valueOf(i));
        }
        post.setItems(postcode);
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
