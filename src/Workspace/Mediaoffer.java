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

public class Mediaoffer {
    private final ObservableList<offerinfo> data = FXCollections.observableArrayList();
    @FXML
    private TableView<offerinfo> offer=new TableView<>();

    @FXML
    private Button back=new Button();

    @FXML
    private Button newoffer=new Button();
    TableColumn<offerinfo, String> id=new TableColumn<>("Offer ID");

    TableColumn<offerinfo, String> detail=new TableColumn<>("Details");

    TableColumn<offerinfo, String> time=new TableColumn<>("Start Time");

    TableColumn<offerinfo, String> orderedby=new TableColumn<>("End Time");
    TableColumn<offerinfo, String> status=new TableColumn<>("Percentage");

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
    void Newoffer(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) newoffer.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("newoffer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("New Offer");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        offer.setEditable(true);

        List<List<String>> userDataList= employeeutil.getAlloffer();
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new offerinfo(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
          //  System.out.println(data.get(i));
            i++;
        }

        detail.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        time.setCellValueFactory(new PropertyValueFactory<>("amount"));
        orderedby.setCellValueFactory(new PropertyValueFactory<>("authorname"));
        id.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        status.setCellValueFactory(new PropertyValueFactory<>("per"));
        offer.getColumns().setAll(id,detail,time,orderedby,status);
        offer.setEditable(true);
        offer.setItems(data);

    }
}
