package Customer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Book.Bookinfo.Bookname;

public class Customer {
    @FXML
    GridPane gridPane=new GridPane();
    @FXML
    GridPane gridPane1=new GridPane();
    @FXML
    GridPane gridPane2=new GridPane();
    @FXML
    JFXHamburger hamburger=new JFXHamburger();
    @FXML
    JFXDrawer drawer=new JFXDrawer();
    @FXML
    JFXButton cart=new JFXButton();

    @FXML
    public void initialize() {

        List<List<String>> booklist=userutil.getHighrated();
        int sz=0;
        if(booklist==null)sz=0;
        else sz=booklist.size();
        for(int i=0;i<Integer.min(5,sz);i++){
            // System.out.println("here");
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2)); details.setEffect(cart.getEffect());

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
        booklist=userutil.getlastadded();
        sz=0;
        if(booklist==null)sz=0;
        else sz=booklist.size();
        for(int i=0;i<Integer.min(5,sz);i++){
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2));
            details.setEffect(cart.getEffect());
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
        booklist=userutil.gettopsold();
        sz=0;
        if(booklist==null)sz=0;
        else sz=booklist.size();
        for(int i=0;i<Integer.min(5,sz);i++){
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i);
            name.setText(l.get(0));
            author.setText(l.get(1));
            rating.setText(l.get(2));
            details.setEffect(cart.getEffect());
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


        try {
            VBox box  = FXMLLoader.load(getClass().getResource("Sidepan.fxml"));
            drawer.setSidePane(box);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });

    }
}
