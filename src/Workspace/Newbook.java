package Workspace;

import Employee.employeeutil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Newbook {
    @FXML
    Label totalbook=new Label();
    @FXML
    Label totalnow=new Label();

    public String  editbookid=null;
    @FXML
    Label alert=new Label();
    final ObservableList<bookinfo> data = FXCollections.observableArrayList();
    @FXML
    private TableView<bookinfo> booklist=new TableView<>();

    @FXML
    private Button request=new Button();

    @FXML
    private TextField amount=new TextField();

    @FXML
    private Button back=new Button();

    @FXML
    private Button situation=new Button();
    TableColumn<bookinfo, String> bookid=new TableColumn<>("Book Id");

    TableColumn<bookinfo, String> author=new TableColumn<>("Author Name");
    TableColumn<bookinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<bookinfo, String> total=new TableColumn<>("Total In Storage");

    @FXML
    void Request(ActionEvent event) {
        String  s=amount.getText();
        if(s!=null && editbookid!=null){
            String  p=employeeutil.getPublisherid(editbookid);
            // System.out.println(p);
            employeeutil.addbookreq(employeekey,editbookid,p,s);
            alert.setText("Book reqested");
        }
        else{
            alert.setText("Book can not be reqested");
        }

    }

    @FXML
    public void initialize() {
String x=employeeutil.getTotal(employeekey);
totalnow.setText(totalnow.getText()+x);
x=employeeutil.getCapacity(employeekey);
totalbook.setText(totalbook.getText()+x);
        List<List<String>> cartList= employeeutil.getStorageBook(employeekey) ;
        booklist.setEditable(true);
        int i=0;
        for (List<String> row : cartList)
        {
            data.add(new bookinfo(row.get(0), row.get(1), row.get(3),row.get(2)));
            //System.out.println(data.get(i));
            //i++;
        }
        bookname.setPrefWidth(200);
        bookid.setPrefWidth(100);
        author.setPrefWidth(200);

        total.setPrefWidth(150);

        bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        author.setCellValueFactory(new PropertyValueFactory<>("authorname"));
        bookid.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        total.setCellValueFactory(new PropertyValueFactory<>("amount"));
        booklist.getColumns().setAll(bookid,bookname,author,total);
        booklist.setEditable(true);

        booklist.setItems(data);


        booklist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<bookinfo>() {
            @Override
            public void changed(ObservableValue<? extends bookinfo> observable,bookinfo oldValue, bookinfo newValue) {
                editbookid=newValue.getBookid();
            }
        });
    }


    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("bookkeeper.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Situation(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) situation.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("requestsituation.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Book Request Situation");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
