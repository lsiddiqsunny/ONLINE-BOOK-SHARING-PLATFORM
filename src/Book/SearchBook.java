package Book;

import Customer.userutil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Book.Bookinfo.*;

public class SearchBook {
    public static int start;
    public static int end;
    @FXML
    private FlowPane result=new FlowPane();
    @FXML
    Button clear=new Button();
    @FXML
    private ComboBox search=new ComboBox();
    @FXML
    Button back=new Button();
    @FXML
    Button previous=new Button();
    @FXML
    Button next=new Button();
    @FXML
    Label page=new Label();
    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Customer/customer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Customer Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField query;
    ObservableList<String> searchitem=
            FXCollections.observableArrayList(
                    "Book Name",
                    "Author",
                    "Book Type"
            );
    public  static  List<List<String>> booklist;
    @FXML
    Button searchbutton=new Button();
    void setup(){
        int sz;
        if(booklist==null|| start==0) {
            sz=0;
            return;
        }
        else sz=booklist.size();
       //  System.out.println(sz);
        result.setHgap(15);
        result.setVgap(15);
        for(int i = start-1; i< end; i++){
            String cssLayout = "-fx-border-color: black;\n" +
                    "-fx-border-insets: 0;\n" +
                    "-fx-border-width: 1;\n" +
                    "-fx-border-style: dashed;-fx-alignment: center\n";

            VBox vBox=new VBox();
            vBox.setStyle(cssLayout);
            vBox.setMinHeight(120);
            vBox.setMinWidth(150);
            vBox.setMaxHeight(120);
            vBox.setMaxWidth(150);
            Text name=new Text();
            Text author=new Text();
            Text rating=new Text("");
            Button details=new Button("See Details");
            List<String> l=booklist.get(i);
            name.setText(l.get(0));
            String x=  l.get(1).replace(',','\n');
            author.setText(x);
            rating.setText(l.get(2));
            details.setEffect(back.getEffect());
            vBox.getChildren().add(name);
            vBox.getChildren().add(author);
            vBox.getChildren().add(details);
            vBox.getChildren().add(rating);
//            Border border = new Border();
//            vBox.setBorder(border);
            result.getChildren().add(vBox);

            details.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Stage stage;
                    Parent root;
                    stage = (Stage) details.getScene().getWindow();
                    //load up OTHER FXML document
                    try {
                        Bookname=l.get(0);
                        fromsearch=true;
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

    }
    @FXML
    public void initialize() {


        search.setItems(searchitem);


        setup();
        if(booklist!=null){

            page.setText("Showing "+start+ " to "+ end+ " of "+booklist.size() +" results");
            if(end<booklist.size()){
                next.setVisible(true);
            }
            if(start==0) page.setText("");
        }
    }
    @FXML
    public void Clear(ActionEvent actionEvent) {
        int sz;

        if(booklist==null || booklist.isEmpty()) sz=0;
        else sz=booklist.size();


            for(int i = end-start; i>=Integer.min(end-11,0); i--){
                if(!result.getChildren().isEmpty())
                    result.getChildren().remove(i);
            }
       // query.clear();
        start=0;
        end=0;
        next.setVisible(false);
        previous.setVisible(false);
        page.setText("");

    }
    @FXML
    public void Clear1(ActionEvent actionEvent) {


        for(int i = end-start; i>=Integer.min(end-11,0); i--){

            if(!result.getChildren().isEmpty()){
                result.getChildren().remove(i);
            }
        }
        //   query.clear();

        page.setText("");

    }
    @FXML
    public void Previous(ActionEvent actionEvent) {
        Clear1(new ActionEvent());
        //   System.out.println(start+ " "+ end);
        end=start-1;
        start=Integer.max(start-12,1);
        page.setText("Showing "+start+ " to "+ end+ " of "+booklist.size() +" results");
        setup();

        if(start==1)
        previous.setVisible(false);
        if(end!=booklist.size())
            next.setVisible(true);


    }
    @FXML
    public void Next(ActionEvent actionEvent) {
        Clear1(new ActionEvent());
     //   System.out.println(start+ " "+ end);
        start=end+1;
        end=Integer.min(end+12,booklist.size());
        page.setText("Showing "+start+ " to "+ end+ " of "+booklist.size() +" results");
        setup();
        if(end==booklist.size())
            next.setVisible(false);
        previous.setVisible(true);


    }

    @FXML
    public void Search(ActionEvent actionEvent) {
        Clear(new ActionEvent());
        String svalue="";
        if(booklist!=null)
        booklist.clear();
        try{
            svalue=search.getValue().toString();
        }catch (Exception e){
            svalue="";
        }
        if(svalue.length()==0){
            booklist= userutil.getAllBooks();
        }else if(svalue.equals("Author")){
            String p;
            try{
                p =query.getText();
            }catch (Exception e){
                p="";
            }
            //System.out.println("here");
            if(p.length()==0){
                booklist=userutil.getAllBooks();
            }
            else{
                booklist= bookutil.getSearchBookbyauthor(p);
            }
        }
        else if(svalue.equals("Book Name")){
            String p;
            try{
                p =query.getText();
            }catch (Exception e){
                p="";
            }
            //System.out.println("here");
            if(p.length()==0){
                booklist=userutil.getAllBooks();
            }
            else{
                booklist= bookutil.getSearchBookbybook(p);
            }
        }
        else{
            String p;
            try{
                p =query.getText();
            }catch (Exception e){
                p="";
            }
            //System.out.println("here");
            if(p.length()==0){
                booklist=userutil.getAllBooks();
            }
            else{
                booklist= bookutil.getSearchBookbytype(p);
            }
        }
        if(booklist!=null){

            start=1;

            end=Integer.min(12,booklist.size());
            page.setText("Showing "+start+ " to "+ end+ " of "+booklist.size() +" results");
            if(booklist.size()>12){
                next.setVisible(true);
            }
        }else{
            page.setText("");
        }


        setup();
    }
}
