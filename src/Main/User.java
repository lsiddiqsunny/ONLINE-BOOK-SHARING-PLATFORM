package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class User {
    public static String userkey;
    @FXML
    Button updateinfo=new Button();

    @FXML
    Text phone=new Text();

    @FXML
    Text Location=new Text();

    @FXML
    Text id=new Text();

    @FXML
    Text email=new Text();

    @FXML
    Text username=new Text();
    @FXML
    Button back=new Button();

    @FXML
    public   void Updateonformation(ActionEvent event) {

    }
    @FXML
    void backbutton(ActionEvent actionEvent) {
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
    public void initialize() {
        username.setText(userutility.getusername(userkey));
        Location.setText(userutility.getuserLocation(userutility.getuserLocationid(userkey))+userutility.getuserbranch(userutility.getuserBranchid(userkey)));
        email.setText(userutility.getuserBEmail(userkey));
        phone.setText(userutility.getuserPhone(userkey));
        id.setText(userkey);

    }


}
