package Customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Customer.User.userkey;


public class Viewreview {
    @FXML
    Button back=new Button();
    @FXML
    ListView reviewlist=new ListView();
    @FXML
    void Back(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("User.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("User Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<String> reviews = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

//reviewlist.setItems(reviews);

        List<List<String>>Listed=userutility.getAllreview(userkey);
        reviews.removeAll();
        reviewlist.setItems(reviews);
        for( List x: Listed){
            reviews.add(x.get(0)+"-"+x.get(1)+"-"+x.get(2));
            //System.out.println(x);
        }
        reviewlist.setItems(reviews);


    }
}
