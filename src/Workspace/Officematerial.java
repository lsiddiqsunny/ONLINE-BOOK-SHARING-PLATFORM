package Workspace;

import Employee.employeeutil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Employee.Employee.employeekey;

public class Officematerial {
    @FXML
    private GridPane grid=new GridPane();

    @FXML
    private Button back=new Button();

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("clerk.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {


        grid.setGridLinesVisible(true);
        Text t=new Text();

        grid.add(new Text("Material Name"),0,0);
        grid.add(new Text("Amount"),1,0);
        List<List<String >> L= employeeutil.getAllMaterial(employeeutil.getuserBranch(employeekey));
        for(int i=0;i<L.size();i++){
            t=new Text(L.get(i).get(0));

            grid.add(t,0,i+1);

            t=new Text(L.get(i).get(1));
            grid.add(t,1,i+1);
        }

    }


}
