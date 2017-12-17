package Main;

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

import static Main.Employee.employeekey;


public class Employeetable {
    @FXML
    TableView<employeedata> employeelist=new TableView<>();
    final ObservableList<employeedata> data = FXCollections.observableArrayList();
    TableColumn<employeedata, String> employeename=new TableColumn<>("Employee Name");

    TableColumn<employeedata, String> phonenumber=new TableColumn<>("Phone number");

    TableColumn<employeedata, String> jobname=new TableColumn<>("Job Name");
    @FXML
    Button backbutton =new Button();
    @FXML
    void Backbutton(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("employee.fxml"));
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
        employeelist.setEditable(true);

        List<List<String>> userDataList=employeeutil.getAllEmployee(employeekey);
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new employeedata(row.get(0), row.get(1), row.get(2)));
            System.out.println(data.get(i));
            i++;
        }

        employeename.setCellValueFactory(new PropertyValueFactory<>("Employeename"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
        jobname.setCellValueFactory(new PropertyValueFactory<>("Jobname"));
        employeelist.getColumns().setAll(employeename,phonenumber,jobname);
        employeelist.setEditable(true);


        employeelist.setItems(data);

    }
}
