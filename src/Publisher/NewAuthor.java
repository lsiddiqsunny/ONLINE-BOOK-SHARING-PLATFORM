package Publisher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NewAuthor {
    @FXML
    private Button submit;

    @FXML
    private TextField authorname=new TextField();

    @FXML
    private Button back=new Button();

    @FXML
    private Label info=new Label();

    @FXML
    void Submit(ActionEvent event) {
        String name=authorname.getText();
        if(name.length()!=0){
            publisherutil.insertauthor(name);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("New Author Added");
            alert.setHeaderText("New Author Added");
            alert.setContentText("New Author Added Successfully");
            alert.showAndWait();
        }
    }

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("editbook.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Book");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
