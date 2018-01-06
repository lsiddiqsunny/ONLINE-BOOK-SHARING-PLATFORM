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

    @FXML
    Label items=new Label();
    int co=0;

    @FXML
    Button confirm=new Button();

    @FXML
    private TableView<BookRequest> requestlist;
    ObservableList<BookRequest> data = FXCollections.observableArrayList();
    TableColumn<BookRequest, String> editId=new TableColumn<>("Id");
    TableColumn<BookRequest, String> bookName=new TableColumn<>("Book Name");
    TableColumn<BookRequest, String> amount=new TableColumn<>("Amount");
    TableColumn<BookRequest, String> status=new TableColumn<>("Status");
    TableColumn<BookRequest, String> branch=new TableColumn<>("Branch");

    @FXML
    Button back=new Button();
    @FXML
    void Confirm(ActionEvent event){
        for(BookRequest e:Item){
            publisherutil.updatebookreq(e.getEditId());
        }

        Stage stage;
        Parent root;
        stage = (Stage)confirm.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Publisher Transaction");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

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




        requestlist.setEditable(true);
        List<List<String>> userDataList = publisherutil.getBookReq(publisherkey);
        //int i = 0;
        for (List<String> row : userDataList) {

                data.add(new BookRequest(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));

        }
        editId.setPrefWidth(100);
        bookName.setPrefWidth(200);
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
                }
                else {
                    if(newValue.getStatus().equals("IN QUEUE")){
                        Item.add(newValue);
                        co++;
                        items.setText(co+" rows selected.");
                    }
                  else   if(newValue.getStatus().equals("ASSIGNED")){

                        items.setText("The order is assigned to our agent and will connect with you soon");
                    }
                }
            }
        });


    }
}
