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

public class PendingRequest {
    @FXML
    private TableView<BookEdit> editlist=new TableView<>();

    @FXML
    private Button back=new Button();


    ObservableList<BookEdit> data = FXCollections.observableArrayList();
    TableColumn<BookEdit, String> editId=new TableColumn<>("Id");

    TableColumn<BookEdit, String> bookName=new TableColumn<>("Book Name");

    TableColumn<BookEdit, String> price=new TableColumn<>("Price");
    TableColumn<BookEdit, String> status=new TableColumn<>("Status");


    @FXML
    public void initialize() {

        //  booklist.disableProperty().setValue(false);
        editlist.setEditable(true);


        List<List<String>> userDataList = publisherutil.getPendingBook(publisherkey);
        //int i = 0;
        for (List<String> row : userDataList) {
            data.add(new BookEdit(row.get(0), row.get(1), row.get(2),row.get(3)));
            //  System.out.println(data.get(i));
            // i++;
        }
        userDataList = publisherutil.getPendingBookinsert(publisherkey);
        //int i = 0;
        for (List<String> row : userDataList) {
            data.add(new BookEdit(row.get(0), row.get(1), row.get(2),row.get(3)));
            //  System.out.println(data.get(i));
            // i++;
        }
        editId.setPrefWidth(100);
        bookName.setPrefWidth(200);
        price.setPrefWidth(100);
       // status.setPrefWidth(89);
        bookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        editId.setCellValueFactory(new PropertyValueFactory<>("EditId"));
        editlist.getColumns().setAll(editId, bookName, price,status);
        editlist.setEditable(true);

        editlist.setItems(data);



    }
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
}
