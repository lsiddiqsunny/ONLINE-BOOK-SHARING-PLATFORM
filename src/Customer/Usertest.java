package Customer;

import Publisher.bookinfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Book.Bookinfo.Bookname;
import static Customer.User.userkey;
import static Book.Bookinfo.Bookname;

public class Usertest {
    @FXML
    GridPane gridPane=new GridPane();
    @FXML
    GridPane gridPane1=new GridPane();
    @FXML
    GridPane gridPane2=new GridPane();
    @FXML
    Button seeall=new Button();
    @FXML
    AnchorPane anchorpane=new AnchorPane();
    @FXML
    AnchorPane anchorpane2=new AnchorPane();
    @FXML
    Button transcation=new Button();
    @FXML
    Button search=new Button();
    @FXML
    Button noti=new Button();
    @FXML
    Button help=new Button();
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
    Label offer=new Label();

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
        anchorpane2.setVisible(true);
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
    void Noti(ActionEvent event) {

    }
    @FXML
    void Help(ActionEvent event) {

    }
    @FXML
    void Search(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) search.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Book/SearchBook.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Search Book");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Transaction(ActionEvent event) {

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

        anchorpane2.setVisible(false);
        //System.out.println("here");
        anchorpane.setVisible(true);
        setup();
    }
    void setup(){
        username.setText(userutility.getusername(userkey));
    }

    @FXML
    public void initialize() {
        anchorpane2.setVisible(true);
        anchorpane.setVisible(false);

List<List<String>> booklist=userutil.getAllBooks();

        for(int i=0;i<5;i++){
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2));
            gridPane.add(name,i,0);
            gridPane.add(author,i,1);
            gridPane.add(details,i,2);
            gridPane.add(rating,i,3);
            details.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage;
                    Parent root;
                    stage = (Stage) details.getScene().getWindow();
                    //load up OTHER FXML document
                    try {
                        Bookname=l.get(0);
                        root = FXMLLoader.load(getClass().getResource("../Book/bookinfo.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("Book Information");
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


        }

        for(int i=0;i<5;i++){
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i+5);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2));
            gridPane1.add(name,i,0);
            gridPane1.add(author,i,1);
            gridPane1.add(details,i,2);
            gridPane1.add(rating,i,3);

            details.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Bookname=l.get(0);
                    Stage stage;
                    Parent root;
                    stage = (Stage) details.getScene().getWindow();
                    //load up OTHER FXML document
                    try {
                        root = FXMLLoader.load(getClass().getResource("../Book/bookinfo.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("Book Information");
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for(int i=0;i<5;i++){
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i+10);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2));
            gridPane2.add(name,i,0);
            gridPane2.add(author,i,1);
            gridPane2.add(details,i,2);
            gridPane2.add(rating,i,3);
            details.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Bookname=l.get(0);
                    Stage stage;
                    Parent root;
                    stage = (Stage) details.getScene().getWindow();
                    //load up OTHER FXML document
                    try {
                        root = FXMLLoader.load(getClass().getResource("../Book/bookinfo.fxml"));
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setTitle("Book Information");
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

offer.setText(userutil.getOffer());
        setup();

    }
}
