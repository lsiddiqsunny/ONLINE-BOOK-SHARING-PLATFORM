package Publisher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Publisher.Publisher.publisherkey;

public class Transaction {
    @FXML
    private TableView<BookEdit> newbook;
    ObservableList<BookEdit> data1 = FXCollections.observableArrayList();
    TableColumn<BookEdit, String> editId1=new TableColumn<>("Id");

    TableColumn<BookEdit, String> bookName1=new TableColumn<>("Book Name");

    TableColumn<BookEdit, String> price1=new TableColumn<>("Price");
    TableColumn<BookEdit, String> status1=new TableColumn<>("Status");
    @FXML
    Button back=new Button();
    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Publisher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Publisher page");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {


        newbook.setEditable(true);


        List<List<String>> userDataList1 = publisherutil.getPendingReq(publisherkey);
        //int i = 0;
        for (List<String> row : userDataList1) {
            data1.add(new BookEdit(row.get(0), row.get(1), row.get(2),row.get(3)));
            //  System.out.println(data.get(i));
            // i++;
        }
        editId1.setPrefWidth(100);
        bookName1.setPrefWidth(200);
        price1.setPrefWidth(100);
        status1.setPrefWidth(89);
        bookName1.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        status1.setCellValueFactory(new PropertyValueFactory<>("Status"));
        price1.setCellValueFactory(new PropertyValueFactory<>("Price"));
        editId1.setCellValueFactory(new PropertyValueFactory<>("EditId"));
        newbook.getColumns().setAll(editId1, bookName1, price1,status1);
        newbook.setEditable(true);

        newbook.setItems(data1);


    }
}
