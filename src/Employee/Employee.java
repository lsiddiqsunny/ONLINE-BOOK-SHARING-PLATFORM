package Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Employee {
    public  static  String employeekey;
    @FXML
    Button logout=new Button();
    @FXML
    Button  underpeople=new Button();
    @FXML
    Button  workspace=new Button();
    @FXML
    Button  editprofile=new Button();

    @FXML
    private Text employeephone=new Text();

    @FXML
    private Text employeejob=new Text();

    @FXML
    private Text employeeemail=new Text();

    @FXML
    private Text employeeaddress=new Text();
    @FXML
    private Text employeedepartment=new Text();
    @FXML
    private Text employeemanager=new Text();

    @FXML
    private Text employeeid=new Text();

    @FXML
    private Text employeename=new Text();
    @FXML
    Button notification=new Button();
    @FXML
    Button shownotice=new Button();

    @FXML
    void Logout(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) logout.getScene().getWindow();
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
    void Shownotice(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) shownotice.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("notice.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Notice");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Notification(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) notification.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("notification.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Notification");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void Load(String s){
        Stage stage;
        Parent root;
        stage = (Stage) workspace.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource(s));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Workspace(ActionEvent actionEvent) {
        int x=employeeutil.getuserjobid(employeekey);
        if((x>=1 && x<=8 )||x==14){
            Load("../Workspace/managingderector.fxml");
        }
    }
    @FXML
    void Editprofile(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) editprofile.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("editprofile.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Profile");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Underpeople(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) underpeople.getScene().getWindow();
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
    public void initialize() {
        employeename.setText(employeeutil.getusername(employeekey));
        employeeaddress.setText(employeeutil.getuserLocation(employeeutil.getuserLocationid(employeekey)));
        employeeemail.setText(employeeutil.getusermailphone(employeekey,"Email"));
        employeephone.setText(employeeutil.getusermailphone(employeekey,"Phone_number"));
        employeeid.setText(employeekey);
        employeejob.setText(employeeutil.getuserjob(employeekey));
        employeedepartment.setText(employeeutil.getuserdepartment(employeekey));
        if(employeeutil.getusermanager(employeekey).length()!=0)
            employeemanager.setText(employeeutil.getusermanager(employeekey));
        else employeemanager.setText("NO MANAGER");


    }

}
