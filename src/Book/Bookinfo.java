package Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Bookinfo {
public  static  String bookid;
    @FXML
    Button backbutton=new Button();
    @FXML
    Button cart=new Button();
    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Customer/usertest.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Customer Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void Cart(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) cart.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("cartconfirm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Cart confirmation");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() {
       bookid=bookutil.getBookid(bookid);
       System.out.println(bookid);
    }
}
