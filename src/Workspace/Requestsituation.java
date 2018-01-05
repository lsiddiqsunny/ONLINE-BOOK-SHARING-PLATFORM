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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Requestsituation {
    @FXML
    Button back=new Button();
    @FXML
    Label alert=new Label();
    final ObservableList<bookinfo> data = FXCollections.observableArrayList();
    @FXML
    private TableView<bookinfo> booklist=new TableView<>();
    TableColumn<bookinfo, String> bookid=new TableColumn<>("Request Id");

    TableColumn<bookinfo, String> author=new TableColumn<>("Author Name");
    TableColumn<bookinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<bookinfo, String> total=new TableColumn<>("Status");
    @FXML
    public void initialize() {

        List<List<String>> cartList= employeeutil.getSReqBook(employeekey) ;
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

    }

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("newbook.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


