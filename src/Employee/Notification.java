package Employee;

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

import static Employee.Changestatus.managedkey;
import static Employee.Employee.employeekey;

public class Notification {
    String s=null;
    @FXML
    Button back=new Button();
    @FXML
    TableView<workinfo> worklist=new TableView();
    TableColumn<workinfo, String> id=new TableColumn<>("Work ID");
    private final ObservableList<workinfo> data = FXCollections.observableArrayList();
    TableColumn<workinfo, String> detail=new TableColumn<>("Details");

    TableColumn<workinfo, String> time=new TableColumn<>("Order Time");

    TableColumn<workinfo, String> orderedby=new TableColumn<>("Ordered By");
    TableColumn<workinfo, String> status=new TableColumn<>("Status");
    @FXML
    Button change=new Button();
    @FXML
    Button refresh=new Button();

    @FXML
    void Back(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Employee Account");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Change(ActionEvent actionEvent) {
        if(s!=null){
            employeeutil.updatework(s);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Status Changed");
            alert.setHeaderText("Status changed");
            alert.setContentText("Please refresh to check new status");
            alert.showAndWait();
        }
    }
    @FXML
    void Refresh(ActionEvent actionEvent) {
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
        worklist.setEditable(true);

        List<List<String>> userDataList=employeeutil.getAllWork(employeekey);
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new workinfo(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
            //System.out.println(data.get(i));
            i++;
        }

        detail.setCellValueFactory(new PropertyValueFactory<>("Details"));
        time.setCellValueFactory(new PropertyValueFactory<>("Ordertime"));
        orderedby.setCellValueFactory(new PropertyValueFactory<>("Orderedby"));
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        worklist.getColumns().setAll(id,detail,time,orderedby,status);
        worklist.setEditable(true);


        worklist.setItems(data);
        worklist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<workinfo>() {
            @Override
            public void changed(ObservableValue<? extends workinfo> observable, workinfo oldValue, workinfo newValue) {
                //  managedkey=newValue.getEmployeeid();
                s=newValue.getId();

            }
        });
    }
}
