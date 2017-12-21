package Publisher;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Publisher {
    public static String publisherkey;
    final ObservableList<bookinfo> data = FXCollections.observableArrayList();
    @FXML
    Text publishername=new Text();
    @FXML
    Text publisherid=new Text();
    @FXML
    Text publisheraddress=new Text();
    @FXML
    TableView<bookinfo> booklist=new TableView<>();
    @FXML
    Button logout=new Button();
    @FXML
    Button editprofile=new Button();
    @FXML
    Button transcation=new Button();
    @FXML
    void Transaction(ActionEvent actionEvent){

    }
    @FXML
    void Editprofile(ActionEvent actionEvent){
        Stage stage;
        Parent root;
        stage = (Stage) editprofile.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("publisheredit.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Page");

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Logout(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) logout.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("../Main/Main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Home page");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    TableColumn<bookinfo, String> bookname=new TableColumn<>("Book Name");

    TableColumn<bookinfo, String> authorname=new TableColumn<>("Author Name");

    TableColumn<bookinfo, String> price=new TableColumn<>("Price");
    @FXML
    public void initialize() {

        //  booklist.disableProperty().setValue(false);
        booklist.setEditable(true);
        publishername.setText(publisherutil.getusername(publisherkey));
        publisheraddress.setText(publisherutil.getuserLocation(publisherutil.getuserLocationid(publisherkey)));
        publisherid.setText(publisherkey);
        List<List<String>> userDataList=publisherutil.getAllBooks(publisherkey);
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new bookinfo(row.get(0), row.get(1), row.get(2)));
          //  System.out.println(data.get(i));
            i++;
        }
//        bookname.setPrefWidth(200);
//        authorname.setPrefWidth(200);
//        price.setPrefWidth(200);
        bookname.setCellValueFactory(new PropertyValueFactory<>("Bookname"));
        authorname.setCellValueFactory(new PropertyValueFactory<>("Authorname"));
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        //   System.out.println(bookname.getColumns().isEmpty());
        booklist.getColumns().setAll(bookname,authorname,price);
        booklist.setEditable(true);

        booklist.setItems(data);





        // System.out.println(publisherkey);
    }


}
