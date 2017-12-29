package Publisher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class PendingRequest {
    @FXML
    private TableView<BookEdit> editlist=new TableView<>();

    @FXML
    private Button back=new Button();

    @FXML
    private TableView<?> newbook;

    @FXML
    void Back(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("Publisher.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Publisher page");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
