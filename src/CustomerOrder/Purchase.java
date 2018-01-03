package CustomerOrder;

import Customer.userutility;
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

import static Customer.User.userkey;
import static CustomerOrder.Customercart.Item;
import static Main.pdf.pdf;

public class Purchase {
    ObservableList<orderinfo> data = FXCollections.observableArrayList();
    @FXML
    TableView<orderinfo> booklist=new TableView<>();
    TableColumn<orderinfo, String> orderid=new TableColumn<>("Order Id");

    TableColumn<orderinfo, String> time=new TableColumn<>("Order Time");
    TableColumn<orderinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<orderinfo, String> amount=new TableColumn<>("Amount");

    TableColumn<orderinfo, String> status=new TableColumn<>("Payment Status");
    @FXML
    Button back=new Button();
    @FXML
    Button confirm=new Button();

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("customercart.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Order List");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Confirm(ActionEvent event) {
        int x=cartutil.lastid();
        x++;
        int co=0;
        for(orderinfo e:Item){
            co++;
            cartutil.Orderconfirm(Integer.toString(x),e.getOrderid());
        }
        if(co>0){
            pdf(Item, userutility.getusername(userkey));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("All orders are in queue. ");
            alert.setHeaderText("Wait for 24 hours!");
            alert.setContentText("A PDF file is generated.\nPlease check it.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {

        booklist.setEditable(true);

        for (int i=0;i<Item.size();i++)
        {
            data.add(Item.get(i));
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
        booklist.getColumns().setAll(orderid,bookname,amount,time,status);
        booklist.setEditable(true);

        booklist.setItems(data);

    }
}
