package Book;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

import static Customer.User.userkey;

public class Bookinfo {
    public  static  String Bookname,bookid;
    public static boolean  fromsearch=false;
    String rating="";
    final ToggleGroup group = new ToggleGroup();
    @FXML
    Button backbutton=new Button();
    @FXML
    Button view=new Button();
    @FXML
    RadioButton rb1=new RadioButton();
    @FXML
    RadioButton rb2=new RadioButton();
    @FXML
    RadioButton rb3=new RadioButton();
    @FXML
    RadioButton rb4=new RadioButton();
    @FXML
    RadioButton rb5=new RadioButton();
    @FXML
    TextArea review=new TextArea();
    @FXML
    Button submit=new Button();
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
    private Text amount=new Text();
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
    void Submit(ActionEvent event) {
        String s=review.getText();
        if(s!=null){
            System.out.println(rating+s);
        }
        else s="";

        if(rating.length()!=0){
            bookutil.insertreview(bookid,userkey,s,rating);
        }
        else{
            review.setPromptText("No review added.\n Please give a rating.");
        }


    }
    @FXML
    void View(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage)view.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("review.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Review");
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
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);
        rb4.setToggleGroup(group);
        rb5.setToggleGroup(group);
        rb1.setUserData("1");
        rb2.setUserData("2");
        rb3.setUserData("3");
        rb4.setUserData("4");
        rb5.setUserData("5");

        bookid=bookutil.getBookid(Bookname);
        // System.out.println(bookid);
        List<String> l=bookutil.getBookinfo(bookid);
        bookname.setText(l.get(0));
        author.setText(l.get(1));
        price.setText(l.get(2));
        isbn.setText(l.get(3));
        catagory.setText(l.get(4));
        commission.setText(bookutil.getOffer());
        amount.setText(l.get(5));
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    rating=group.getSelectedToggle().getUserData().toString();
                }
            }
        });

    }
}
