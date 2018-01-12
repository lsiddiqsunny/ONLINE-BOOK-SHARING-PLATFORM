package Workspace;

import Employee.employeeutil;
import Publisher.publisherutil;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import static Employee.Employee.employeekey;
import static Workspace.Requestsituation.orderid;

public class Bookassign {
    @FXML
    private ComboBox<String> worker=new ComboBox<>();

    @FXML
    private Button back=new Button();

    @FXML
    private Button assign=new Button();

    @FXML
    void Assign(ActionEvent event) {
        String p="";
        try{
            p=worker.getValue();
            String[]  x=p.split("-");
            p=x[0];
            //  System.out.println(p);
            List<List<String>>  l=employeeutil.getReq(orderid.getBookid());
            employeeutil.transactioninsert(l.get(0).get(0),l.get(0).get(1),l.get(0).get(2),p,orderid.getBookid());

            employeeutil.changestatus2(orderid.getBookid());
            employeeutil.publisher4(orderid.getBookid());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Order Assigned");
            alert.setHeaderText("Order Assigned");
            alert.setContentText("A PDF file is generated.\nPlease check it.");
            alert.showAndWait();

        }catch (Exception e){
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

            root = FXMLLoader.load(getClass().getResource("requestsituation.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Request Situation");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize() {

        ObservableList<String> typelist =
                FXCollections.observableArrayList();
        List<List<String>> types=employeeutil.getWorker(employeeutil.getuserBranch(employeekey));


        for(List<String> s: types){
            String p="";
            int co=0;
            for(String x:s){

                if(co==0)
                    p=x+"-";
                else p=p+x;
                co++;
            }
            typelist.add(p);
        }
        worker.setItems(typelist);


    }
}
