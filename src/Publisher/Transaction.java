package Publisher;

import CustomerOrder.orderinfo;
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
import java.util.ArrayList;
import java.util.List;

import static Publisher.Publisher.publisherkey;

public class Transaction {
    public static ArrayList<BookRequest> Item = new ArrayList<>();
    public static ArrayList<BookEdit> Item1 = new ArrayList<>();
    @FXML
    private TableView<BookEdit> newbook;
    @FXML
    Label items=new Label();
    int co=0;
    @FXML
    Label items1=new Label();
    int co1=0;
    @FXML
    private TableView<BookRequest> requestlist;
    ObservableList<BookRequest> data = FXCollections.observableArrayList();
    TableColumn<BookRequest, String> editId=new TableColumn<>("Id");
    TableColumn<BookRequest, String> bookName=new TableColumn<>("Book Name");
    TableColumn<BookRequest, String> amount=new TableColumn<>("Amount");
    TableColumn<BookRequest, String> status=new TableColumn<>("Status");
    TableColumn<BookRequest, String> branch=new TableColumn<>("Branch");

    ObservableList<BookEdit> data1 = FXCollections.observableArrayList();
    TableColumn<BookEdit, String> editId1=new TableColumn<>("Id");
    TableColumn<BookEdit, String> bookName1=new TableColumn<>("Book Name");

    TableColumn<BookEdit, String> price1=new TableColumn<>("Price");
    TableColumn<BookEdit, String> status1=new TableColumn<>("Status");
    @FXML
    Button back=new Button();
    @FXML
    void Confirm(ActionEvent event){
        for(BookRequest e:Item){
            publisherutil.updatebookreq(e.getEditId());
        }

        initialize();
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


        requestlist.setEditable(true);
        List<List<String>> userDataList = publisherutil.getBookReq(publisherkey);
        //int i = 0;
        for (List<String> row : userDataList) {
            data.add(new BookRequest(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
            //  System.out.println(data.get(i));
            // i++;
        }
        editId.setPrefWidth(100);
        bookName.setPrefWidth(100);
        amount.setPrefWidth(100);
        status.setPrefWidth(89);
        branch.setPrefWidth(100);
        bookName.setCellValueFactory(new PropertyValueFactory<>("BookName"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        amount.setCellValueFactory(new PropertyValueFactory<>("Price"));
        editId.setCellValueFactory(new PropertyValueFactory<>("EditId"));
        branch.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        requestlist.getColumns().setAll(editId, bookName,amount,status,branch);
        requestlist.setEditable(true);
        requestlist.setItems(data);

        requestlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<BookRequest>() {
            @Override
            public void changed(ObservableValue<? extends BookRequest> observable, BookRequest oldValue, BookRequest newValue) {


                if(Item.contains(newValue)){
                    co--;
                    items.setText(co+" rows selected.");
                    Item.remove(newValue);
                }else {
                    if(newValue.getStatus().equals("IN QUEUE")){
                        Item.add(newValue);
                        co++;
                        items.setText(co+" rows selected.");
                    }
                }
            }
        });


    }
}
