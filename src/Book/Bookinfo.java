package Book;

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

public class Bookinfo {
public  static  String Bookname,bookid;
public static boolean  fromsearch=false;
    @FXML
    Button backbutton=new Button();
    @FXML
    private Text author=new Text();

    @FXML
    private Text price=new Text();

    @FXML
    private Text commission=new Text();

    @FXML
    private Text bookname=new Text();
    @FXML
    private Text catagory=new Text();
    @FXML
    private Text isbn=new Text();
    @FXML
    Button cart=new Button();
    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            if(!fromsearch)
            root = FXMLLoader.load(getClass().getResource("../Customer/usertest.fxml"));
            else
                root = FXMLLoader.load(getClass().getResource("SearchBook.fxml"));

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
     bookid=bookutil.getBookid(Bookname);
      // System.out.println(bookid);
       List<String> l=bookutil.getBookinfo(bookid);
       bookname.setText(l.get(0));
       author.setText(l.get(1));
       price.setText(l.get(2));
       isbn.setText(l.get(3));
       catagory.setText(l.get(4));
       commission.setText(bookutil.getOffer());

    }
}