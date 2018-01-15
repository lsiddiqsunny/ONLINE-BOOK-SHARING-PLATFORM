package Customer;

import CustomerOrder.cartutil;
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

import static Customer.User.userkey;

public class Notification {
    @FXML
    private Button back=new Button();

    @FXML
    private Button refresh=new Button();

    @FXML
    private TableView<notiinfo> notilist =new TableView<>();
    final ObservableList<notiinfo> data = FXCollections.observableArrayList();
    TableColumn<notiinfo, String> id=new TableColumn<>("Notification Id");

    TableColumn<notiinfo, String> time=new TableColumn<>("Notification Time");
    TableColumn<notiinfo, String> notification=new TableColumn<>("Notification");


    @FXML
    void Back(ActionEvent event) {
        for(notiinfo n: data){
            userutil.updatenotistatus(n.getNotiid());
        }
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("customer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("User Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Refresh(ActionEvent event) {
        for(notiinfo n: data){
           userutil.updatenotistatus(n.getNotiid());
        }
        Stage stage;
        Parent root;
        stage = (Stage) refresh.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("notification.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Notification");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void initialize() {

        List<List<String>> cartList= userutil.getNoti(userkey) ;
       notilist.setEditable(true);
        int i=0;
        for (List<String> row : cartList)
        {
            data.add(new notiinfo(row.get(0), row.get(1), row.get(2)));
           // System.out.println(data.get(i));
           // i++;
        }
      // notification.setPrefWidth(200);
        id.setPrefWidth(150);
        time.setPrefWidth(200);


        notification.setCellValueFactory(new PropertyValueFactory<>("notification"));

        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        id.setCellValueFactory(new PropertyValueFactory<>("notiid"));

        notilist.getColumns().setAll(id,notification,time);
        notilist.setEditable(true);
        notilist.setItems(data);

    }
}
