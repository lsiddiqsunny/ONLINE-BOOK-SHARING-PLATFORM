package Workspace;

import Book.bookutil;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Purchasingagent {
    public bookinfo  editbookid=null;
    final ObservableList<bookinfo> data = FXCollections.observableArrayList();

    @FXML
    private Button confirm=new Button();

    @FXML
    private Button back=new Button();

    @FXML
    private TableView<bookinfo> orderlist=new TableView<>();
    TableColumn<bookinfo, String> bookid=new TableColumn<>("Order Id");

    TableColumn<bookinfo, String> author=new TableColumn<>("Publisher");
    TableColumn<bookinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<bookinfo, String> total=new TableColumn<>("Total");


    @FXML
    void Confirm(ActionEvent event) {
        if(editbookid!=null){
            employeeutil.updatepublishertransaction(editbookid.getBookid());
            employeeutil.updatebookamount(bookutil.getBookid(editbookid.getBookname()),editbookid.getAmount());
            employeeutil.changestatus3(employeeutil.getrequestid(editbookid.getBookid()));
            employeeutil.publisher3(editbookid.getBookid());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Work Done");
            alert.setHeaderText("Work Done");
            alert.setContentText("Work Done Successfully.");
            alert.showAndWait();
        }

    }

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("../Employee/Employee.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {

        List<List<String>> cartList= employeeutil.getAssignedBook(employeekey) ;
       orderlist.setEditable(true);
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
        orderlist.getColumns().setAll(bookid,bookname,author,total);
        orderlist.setEditable(true);

        orderlist.setItems(data);


        orderlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<bookinfo>() {
            @Override
            public void changed(ObservableValue<? extends bookinfo> observable, bookinfo oldValue, bookinfo newValue) {
                editbookid=newValue;
            }
        });
    }

}
