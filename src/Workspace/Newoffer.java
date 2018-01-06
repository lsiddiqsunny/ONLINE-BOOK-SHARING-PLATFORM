package Workspace;

import Employee.employeeutil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

public class Newoffer {

    @FXML
    private Button submit=new Button();

    @FXML
    private DatePicker start=new DatePicker();

    @FXML
    private Button back=new Button();

    @FXML
    private TextArea details=new TextArea();

    @FXML
    private DatePicker end=new DatePicker();

    @FXML
    private TextField per=new TextField();

    @FXML
    void Submit(ActionEvent event) {
        String  a,b,c,d;
        LocalDate date;
        a=details.getText();
        date=start.getValue();
        b=date.toString();
        date=end.getValue();
        c=date.toString();
        d=per.getText();
        if(a!=null||b!=null||c!=null||d!=null){
            employeeutil.offerinsert(a,b,c,d);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Offer Added");
            alert.setHeaderText("Offer Added");
            alert.setContentText("Offer Added Successfully.");
            alert.showAndWait();
        }

    }

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage)back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("mediaoffer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
