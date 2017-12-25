package Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static Customer.User.userkey;


public class Usertest {
    @FXML
    ToggleButton seeall=new ToggleButton();
    @FXML
    AnchorPane anchorpane=new AnchorPane();

    @FXML
    private Button logout=new Button();

    @FXML
    private Button review=new Button();

    @FXML
    private Button profile=new Button();

    @FXML
    private Button update=new Button();

    @FXML
    private Button cart=new Button();
    @FXML
    Button close=new Button();

    @FXML
    private Text username=new Text();

    @FXML
    void Profile(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) profile.getScene().getWindow();
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
    @FXML
    void Close(ActionEvent event) {
        seeall.setVisible(true);
        anchorpane.setVisible(false);
    }

    @FXML
    void Review(ActionEvent event) {
        Parent root;
        Stage stage = (Stage) review.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("viewreview.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("View Reviews");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Update(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) update.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("userupdate.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Update Information");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Cart(ActionEvent event) {

    }

    @FXML
    void Logout(ActionEvent event) {
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
    void Seeall(ActionEvent event) {
        seeall.setVisible(false);
        anchorpane.setVisible(true);
        setup();
    }
    void setup(){
        username.setText(userutility.getusername(userkey));
    }

    @FXML
    public void initialize() {
   seeall.setVisible(true);
        anchorpane.setVisible(false);
        setup();
    }
}
