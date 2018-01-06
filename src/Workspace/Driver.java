package Workspace;

import Employee.employeeutil;
import Employee.workinfo;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Driver {
    @FXML
    private TableView<transportinfo> transportlist=new TableView<>();
    TableColumn<transportinfo, String> id=new TableColumn<>("Work ID");
    private final ObservableList<transportinfo> data = FXCollections.observableArrayList();
    TableColumn<transportinfo, String> license=new TableColumn<>("License");

    TableColumn<transportinfo, String> capacity=new TableColumn<>("Capacity");


    @FXML
    private Button back=new Button();

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
        transportlist.setEditable(true);

        List<List<String>> userDataList= employeeutil.getAllTransport(employeekey);
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new transportinfo(row.get(0), row.get(1), row.get(2)));
//            System.out.println(data.get(i));
            i++;
        }

        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        license.setCellValueFactory(new PropertyValueFactory<>("Details"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("Status"));

        transportlist.getColumns().setAll(id,license,capacity);
        transportlist.setEditable(true);


       transportlist.setItems(data);

    }
}
