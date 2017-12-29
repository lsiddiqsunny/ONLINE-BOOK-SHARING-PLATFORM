package Book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

import static Book.Bookinfo.bookid;
import static Customer.User.userkey;

public class Cartconfirm {
    @FXML
    Text bookname=new Text();
    @FXML
    Text author=new Text();
    @FXML
    Text price=new Text();
    @FXML
    Button backbutton=new Button();
    @FXML
    Button confirm=new Button();
    @FXML
    TextField amount=new TextField();
    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("bookinfo.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Book Information");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void Confirm(ActionEvent event) {
        String s=amount.getText();
        if(s.isEmpty()){
            s="0";
        }
        boolean ok=bookutil.checkorder(bookid,s);
        if(!ok){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not enough book in storage");
            alert.setHeaderText("Not enough book in storage");
            alert.setContentText("Please enter less amount of books");
            alert.showAndWait();
            return;
        }

        bookutil.updateorder(bookid,s,userkey);
    }
    @FXML
    public void initialize() {
        List<String> rs=bookutil.getBookinfo(bookid);
        bookname.setText(rs.get(0));
        author.setText(rs.get(1));
        price.setText(rs.get(2));
    }
}
