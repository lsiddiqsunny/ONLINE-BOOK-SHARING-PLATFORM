package Workspace;

import Book.bookutil;
import CustomerOrder.orderinfo;
import Employee.employeeutil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Employee.Changestatus.managedkey;
import static Employee.Employee.employeekey;

public class Supplier {
    @FXML
    Label items=new Label();
    @FXML
    private Button back=new Button();

    @FXML
    private Button refresh=new Button();

    @FXML
    private TableView<orderinfo> orderlist=new TableView<>();

    @FXML
    private Button assign=new Button();
    TableColumn<orderinfo, String> orderid=new TableColumn<>("Purchase Id");

    TableColumn<orderinfo, String> time=new TableColumn<>("Location To Drop");
    TableColumn<orderinfo, String> bookname=new TableColumn<>("Total price(with discount)");

    TableColumn<orderinfo, String> amount=new TableColumn<>("Amount");

    TableColumn<orderinfo, String> status=new TableColumn<>("Payment Status");
    final ObservableList<orderinfo> data = FXCollections.observableArrayList();
    int co=0;
    public static ArrayList<orderinfo> Item = new ArrayList<>();
    @FXML
    public void initialize() {
        Item.clear();
        // System.out.println(employeeutil.getBranch(employeekey));employeeutil.getAllBooks(employeeutil.getBranch(employeekey))
        List<List<String>> cartList=  employeeutil.getAssignBook(employeekey);
        orderlist.setEditable(true);
        int i=0;
        for (List<String> row : cartList)
        {
            data.add(new orderinfo(row.get(0), row.get(1), row.get(2),row.get(3),row.get(4)));
           // System.out.println(data.get(i));
           // i++;
        }
        bookname.setPrefWidth(200);
        orderid.setPrefWidth(150);
       // time.setPrefWidth(200);
        status.setPrefWidth(150);
        amount.setPrefWidth(100);

        bookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        orderlist.getColumns().setAll(orderid,bookname,amount,time,status);
        orderlist.setEditable(true);

        orderlist.setItems(data);
        orderlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //  carttable.getSelectionModel().setCellSelectionEnabled(true);
        items.setText(co+" rows selected.");
        orderlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<orderinfo>() {
            @Override
            public void changed(ObservableValue<? extends orderinfo> observable, orderinfo oldValue, orderinfo newValue) {


                if(Item.contains(newValue)){
                    co--;
                    items.setText(co+" rows selected.");
                    Item.remove(newValue);
                }else {

                        Item.add(newValue);
                        co++;
                        items.setText(co+" rows selected.");
                }
            }
        });
    }

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
    void Assign(ActionEvent event) {
        for(orderinfo o:Item){
           // employeeutil.assignorder(o.getOrderid(),managedkey);
            employeeutil.changestatus1(o.getOrderid());
        }
        items.setText("Please Refresh.");

    }
    @FXML
    void Details(ActionEvent event) {
        for(orderinfo o:Item){


            String  name=employeeutil.getName(o.getOrderid());
            String FILE="";
            FILE=name+"_"+ o.getOrderid()+".pdf";
            try {
                Desktop.getDesktop().open(new File(FILE));
            } catch (IOException e) {
                e.printStackTrace();
            }
           // System.out.println(FILE);
        }


    }

    @FXML
    void Refresh(ActionEvent event) {
        Stage stage;
        Parent root;
        stage = (Stage) refresh.getScene().getWindow();
        //load up OTHER FXML document
        try {

            root = FXMLLoader.load(getClass().getResource("supplier.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Workspace");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
