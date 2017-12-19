package Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Created by Latif Siddiq Suuny on 01-Dec-17.
 */
public class newaccount {
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
        try{
            locationid= Location.getValue().toString();}catch (Exception e){
            Alert.setText("Enter All Data");

        }
        try{
            branchid= branch.getValue().toString();}
        catch (Exception e){
            Alert.setText("Enter All Data");
        }
        if(username.isEmpty()||useremail.isEmpty()||userpass.isEmpty()||userphone.isEmpty())
            Alert.setText("Enter All Data");
        else {
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
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
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
