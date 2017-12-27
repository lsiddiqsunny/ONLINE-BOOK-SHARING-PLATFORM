package CustomerOrder;


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
import java.util.ArrayList;
import java.util.List;

import static Customer.User.userkey;

public class Customercart {
    final ObservableList<orderinfo> data = FXCollections.observableArrayList();
int co=0;
    ArrayList<orderinfo> Item = new ArrayList<>();
    @FXML
    Button back=new Button();
    @FXML
    Label items=new Label();
    @FXML
    TableView<orderinfo> carttable=new TableView<>();
    @FXML
    Button select=new Button();

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("../Customer/usertest.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Customer Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    TableColumn<orderinfo, String> orderid=new TableColumn<>("Order Id");

    TableColumn<orderinfo, String> time=new TableColumn<>("Order Time");
    TableColumn<orderinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<orderinfo, String> amount=new TableColumn<>("Amount");

    TableColumn<orderinfo, String> status=new TableColumn<>("Payment Status");
    @FXML
    void Select(ActionEvent event) {
        for(orderinfo e:Item){
            System.out.println(e.toString());
        }

    }

    @FXML
    public void initialize() {
        List<List<String>> cartList=cartutil.getAllBooks(userkey) ;
        carttable.setEditable(true);
        int i=0;
        for (List<String> row : cartList)
        {
            data.add(new orderinfo(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
            //System.out.println(data.get(i));
            //i++;
        }
        bookname.setPrefWidth(200);
        orderid.setPrefWidth(150);
        time.setPrefWidth(200);
        status.setPrefWidth(150);
        amount.setPrefWidth(100);

        bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        carttable.getColumns().setAll(orderid,bookname,amount,time,status);
        carttable.setEditable(true);

        carttable.setItems(data);
        carttable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //  carttable.getSelectionModel().setCellSelectionEnabled(true);
        items.setText(co+" rows selected.");
        carttable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<orderinfo>() {
            @Override
            public void changed(ObservableValue<? extends orderinfo> observable, orderinfo oldValue,orderinfo newValue) {


                if(Item.contains(newValue)){
                    co--;
                    items.setText(co+" rows selected.");
                    Item.remove(newValue);
                }else {
                    Item.add(newValue);
                    co++;
                    items.setText(co+" rows selected.");
                }
            }
        });
    }
}
