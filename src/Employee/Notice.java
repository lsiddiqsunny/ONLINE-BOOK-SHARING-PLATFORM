package Employee;

import Workspace.noticeinfo;
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

import static Employee.Employee.employeekey;

public class Notice {
    @FXML
    TableView<noticeinfo> noticelist=new TableView();
    TableColumn<noticeinfo, String> id=new TableColumn<>("Notice ID");
    private final ObservableList<noticeinfo> data = FXCollections.observableArrayList();
    TableColumn<noticeinfo, String> detail=new TableColumn<>("Details");

    TableColumn<noticeinfo, String> time=new TableColumn<>("Notice Time");

    TableColumn<noticeinfo, String> orderedby=new TableColumn<>("Notice Reciver");
    TableColumn<noticeinfo, String> status=new TableColumn<>("Status");

    @FXML
    Button back=new Button();

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
    public void initialize() {
        noticelist.setEditable(true);

        List<List<String>> userDataList=employeeutil.getAllSelectedNotice(String.valueOf(employeeutil.getuserjobid(employeekey)),employeeutil.getuserBranch(employeekey));
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new noticeinfo(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
            //   System.out.println(data.get(i));
            i++;
        }

        detail.setCellValueFactory(new PropertyValueFactory<>("Details"));
        time.setCellValueFactory(new PropertyValueFactory<>("Ordertime"));
        orderedby.setCellValueFactory(new PropertyValueFactory<>("Orderedto"));
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        status.setCellValueFactory(new PropertyValueFactory<>("Status"));
        noticelist.getColumns().setAll(id,detail,time,orderedby,status);
        noticelist.setEditable(true);


        noticelist.setItems(data);

    }
}
