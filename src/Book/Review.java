package Book;

import CustomerOrder.cartutil;
import CustomerOrder.orderinfo;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


import static Book.Bookinfo.bookid;

public class Review {
    final ObservableList<reviewinfo> data = FXCollections.observableArrayList();

    @FXML
    private TableView<reviewinfo> reviewlist=new TableView<>();

    @FXML
    private Button back;
    TableColumn<reviewinfo, String> user_name=new TableColumn<>("User Name");

    TableColumn<reviewinfo, String> review_time=new TableColumn<>("Review Time");
    TableColumn<reviewinfo, String> review=new TableColumn<>("Review");
    @FXML
    public void initialize() {

        List<List<String>> cartList= bookutil.getBookReview(bookid) ;
        reviewlist.setEditable(true);
        int i=0;
        for (List<String> row : cartList)
        {
            data.add(new reviewinfo(row.get(0), row.get(1), row.get(2)));
            //System.out.println(data.get(i));
            //i++;
        }
        user_name.setPrefWidth(150);
      //  review.setPrefWidth(250);
     //  review_time.setPrefWidth(100);


        user_name.setCellValueFactory(new PropertyValueFactory<>("username"));
        review_time.setCellValueFactory(new PropertyValueFactory<>("time"));
       review.setCellValueFactory(new PropertyValueFactory<>("bookname"));

        reviewlist.getColumns().setAll(review_time,user_name,review);
        reviewlist.setEditable(true);

        reviewlist.setItems(data);

    }

    @FXML
    void Back(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) back.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("bookinfo.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Book Information");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
