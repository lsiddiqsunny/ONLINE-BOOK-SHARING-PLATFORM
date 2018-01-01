package Employee;

import CustomerOrder.orderinfo;
import Employee.Employee;
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

import static Employee.Changestatus.managedkey;
import static Employee.Employee.employeekey;


public class Employeetable {
    @FXML
    TableView<employeedata> employeelist=new TableView<>();
    private final ObservableList<employeedata> data = FXCollections.observableArrayList();
    TableColumn<employeedata, String> employeename=new TableColumn<>("Employee Name");

    TableColumn<employeedata, String> phonenumber=new TableColumn<>("Phone number");

    TableColumn<employeedata, String> jobname=new TableColumn<>("Job Name");
    TableColumn<employeedata, String> id=new TableColumn<>("Employee ID");
    @FXML
    Button backbutton =new Button();
    @FXML
    Button status =new Button();
    @FXML
    public void Status(ActionEvent actionEvent){
        Stage stage;
        Parent root;
        stage = (Stage) status.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("changestatus.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void Load(String s){
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource(s));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Backbutton(ActionEvent actionEvent) {

       int x=employeeutil.getuserjobid(employeekey);
       if(x==1){
           Load("../Workspace/managingderector.fxml");
       }
    }

    @FXML
    public void initialize() {
        employeelist.setEditable(true);

        List<List<String>> userDataList=employeeutil.getAllEmployee(employeekey);
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new employeedata(row.get(0), row.get(1), row.get(2),row.get(3)));
            //System.out.println(data.get(i));
            i++;
        }

        employeename.setCellValueFactory(new PropertyValueFactory<>("Employeename"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("Phonenumber"));
        jobname.setCellValueFactory(new PropertyValueFactory<>("Jobname"));
        id.setCellValueFactory(new PropertyValueFactory<>("Employeeid"));
        employeelist.getColumns().setAll(id,employeename,phonenumber,jobname);
        employeelist.setEditable(true);


        employeelist.setItems(data);
        employeelist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<employeedata>() {
            @Override
            public void changed(ObservableValue<? extends employeedata> observable,employeedata oldValue, employeedata newValue) {
                managedkey=newValue.getEmployeeid();

            }
        });
    }
}
