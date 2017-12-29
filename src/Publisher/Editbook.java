package Publisher;

import CustomerOrder.orderinfo;
import Main.Getlistofsecondaryitems;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Publisher.Publisher.publisherkey;

public class Editbook {
    @FXML
    TextField newbookname=new TextField();
    @FXML
    TextField newisbn=new TextField();
    @FXML
    TextField newprice=new TextField();
    @FXML
    TextField booknumbers=new TextField();
    @FXML
    private ComboBox booktype;
    final ObservableList<Author> data = FXCollections.observableArrayList();
    @FXML
    private TableView <Author>authorlist=new TableView<>();
    TableColumn<Author, String> authorId=new TableColumn<>("Author Id");

    TableColumn<Author, String> authorname=new TableColumn<>("Author Name");
    static ArrayList<Author> Item = new ArrayList<>();
    int co=0;
    @FXML
    private ComboBox booklist;
    @FXML
    private Button back=new Button();
    @FXML
    private Button submit=new Button();
    @FXML
    private Button submit1=new Button();
    @FXML
    private Button reset=new Button();
    @FXML
    Button newauthor=new Button();
    @FXML
    Label items=new Label();
    @FXML
    private TextField price=new TextField();
    @FXML
    void Newauthor(ActionEvent actionEvent) {
        Stage stage;
        Parent root;
        stage = (Stage) newauthor.getScene().getWindow();
        //load up OTHER FXML document
        try {
            root = FXMLLoader.load(getClass().getResource("New Author.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("New Author");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Back(ActionEvent actionEvent) {
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

    @FXML
    void Submit(ActionEvent event) {

        String pr=price.getText();
        if(pr.length()!=0){
            try{
                String book=booklist.getValue().toString();
                book=publisherutil.getBook(book);
                publisherutil.setPrice(publisherkey,book,pr);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Book Price Changing Pending");
                alert.setHeaderText("Book Price Changing Pending");
                alert.setContentText("Book Price Changing Is In Queue.\nWe weill confirm when we are done.");
                alert.showAndWait();

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Book Selected ");
                alert.setHeaderText("No Book Selected ");
                alert.setContentText("Please select a book.");
                alert.showAndWait();

            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No price value found");
            alert.setHeaderText("No price value found");
            alert.setContentText("Please enter new price.");
            alert.showAndWait();

        }
    }
    @FXML
    void Submit1(ActionEvent event) {

        String name= newbookname.getText();
        String isbn=  newisbn.getText();
        String price= newprice.getText();
        String num=booknumbers.getText();
        String author="";
        int co=0;
        for(Author e:Item){
            co++;
            author=author+e.getAuthorId();
            if(co>=1 && co!=(Item.size())){
                author+=",";
            }
        }
        //  System.out.println(author);
        String type="";
        try{
            type=booktype.getValue().toString();
        }catch (Exception e){
            type="";
        }
        if(name.length()==0||isbn.length()==0||price.length()==0||num.length()==0||author.length()==0||type.length()==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Submit All Data ");
            alert.setHeaderText("Submit All Data ");
            alert.setContentText("All fields are mandatory.");
            alert.showAndWait();
        }
        else{
            System.out.println(type);
            type=publisherutil.getType(type);

            publisherutil.pendingbookinsert(publisherkey,name,isbn,type,price,num,author);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pending Book Added");
            alert.setHeaderText("Pending Book Addition ");
            alert.setContentText("Book Addition in queue.\nPlease wait.");
            alert.showAndWait();
        }

    }
    @FXML
    void Reset(ActionEvent event) {

        newbookname.clear();
        newisbn.clear();
        newprice.clear();
        booknumbers.clear();
    }
    @FXML
    public void initialize() {
        authorlist.setEditable(true);
        List<List<String>> userDataList=publisherutil.getAllAuthor();
        int i=0;
        for (List<String> row : userDataList)
        {
            data.add(new Author(row.get(0), row.get(1)));
            //  System.out.println(data.get(i));
            i++;
        }
        authorId.setPrefWidth(100);
        authorname.setPrefWidth(300);

        authorId.setCellValueFactory(new PropertyValueFactory<>("AuthorId"));
        authorname.setCellValueFactory(new PropertyValueFactory<>("AuthorName"));


        authorlist.getColumns().setAll(authorId,authorname);
        authorlist.setEditable(true);

        authorlist.setItems(data);
        ObservableList<String> bookslist =
                FXCollections.observableArrayList();
        List<List<String>> books= publisherutil.getpublisherbook(publisherkey);


        for(List<String> s: books){

            for(String x:s){
                //  System.out.println(x);
                bookslist.add(x);
            }
        }
        booklist.setItems(bookslist);
        ObservableList<String> typelist =
                FXCollections.observableArrayList();
        List<List<String>> types= publisherutil.getbooktype();


        for(List<String> s: types){

            for(String x:s){
                //  System.out.println(x);
                typelist.add(x);
            }
        }
        booktype.setItems(typelist);
        authorlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //  carttable.getSelectionModel().setCellSelectionEnabled(true);
        items.setText(co+" rows selected.");
        authorlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Author>() {
            @Override
            public void changed(ObservableValue<? extends Author> observable, Author oldValue,Author newValue) {


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

}
