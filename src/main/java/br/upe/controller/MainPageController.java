package br.upe.controller;

import br.upe.entities.Customer;
import br.upe.util.Facade;
import br.upe.util.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainPageController {

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonInserir;

    @FXML
    private Button buttonRemover;

    @FXML
    private Label labelCustomerCep;

    @FXML
    private Label labelCustomerCpf;

    @FXML
    private Label labelCustomerEmail;

    @FXML
    private Label labelCustomerName;

    @FXML
    private Label labelCustomerPhone;

    @FXML
    private Label labelCustomerSaldo;

    @FXML
    private Button employeeButton;

    private LoginPageController loginPageController;

    @FXML
    private ImageView barcode;

    @FXML
    private TableView<Customer> tableViewCustomers;

    @FXML
    private TableColumn<Customer, String> tableColumnCustomerCpf;

    @FXML
    private TableColumn<Customer, String> tableColumnCustomerName;

    @FXML
    private TableColumn<Customer, String> tableColumnCustomerEmail;

    @FXML
    private TableColumn<Customer, Double> tableColumnCustomerSaldo;
    private ObservableList<Customer> observableListCustomers;

    List<Customer> customers = null;
    Facade facade = new Facade();

    @FXML
    public void initialize(){
        loadTableViewCustomers();
        tableViewCustomers.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> selectItemTableViewCustomers(newValue))
        );
    }

    public void loadTableViewCustomers(){
        tableColumnCustomerCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnCustomerSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));

        customers = facade.getAllCustomers();

        observableListCustomers = FXCollections.observableArrayList(customers);
        tableViewCustomers.setItems(observableListCustomers);
    }

    public void selectItemTableViewCustomers(Customer customer){
        if (customer != null){
            labelCustomerName.setText(customer.getName());
            labelCustomerCpf.setText(customer.getCpf());
            labelCustomerEmail.setText(customer.getEmail());
            labelCustomerPhone.setText(customer.getPhone());
            labelCustomerCep.setText(customer.getCep());
            labelCustomerSaldo.setText(String.valueOf(customer.getSaldo()));
        } else {
            labelCustomerName.setText("");
            labelCustomerCpf.setText("");
            labelCustomerEmail.setText("");
            labelCustomerPhone.setText("");
            labelCustomerCep.setText("");
            labelCustomerSaldo.setText("");
        }
    }

    @FXML
    void handleCheckinAction(ActionEvent event) {
        try {
            SceneChanger.changeScene("CheckinPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonInserir(ActionEvent event) throws IOException {
        Customer customer = new Customer();
        boolean buttonConfirmarClicked = showFXMLCustomerCrudDialog(customer);
        if (buttonConfirmarClicked){
            facade.createCustomer(customer);
            loadTableViewCustomers();
        }
    }

    @FXML
    void handleButtonAlterar(ActionEvent event) throws IOException {
        Customer customer = tableViewCustomers.getSelectionModel().getSelectedItem();
        if (customer != null){
            boolean buttonConfirmarClicked = showFXMLCustomerCrudDialog(customer);
            if (buttonConfirmarClicked){
                facade.updateCustomer(customer);
                loadTableViewCustomers();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    @FXML
    void handleButtonRemover(ActionEvent event) {
        Customer customer = tableViewCustomers.getSelectionModel().getSelectedItem();
        if (customer != null){
            facade.deleteCustomer(customer);
            loadTableViewCustomers();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um cliente na Tabela!");
            alert.show();
        }
    }

    public boolean showFXMLCustomerCrudDialog(Customer customer) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(CustomerCrudDialog.class.getResource("/br/upe/fxml/CustomerCrudDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Clientes");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        dialogStage.setResizable(false);
        dialogStage.setWidth(600);
        dialogStage.setHeight(400);

        CustomerCrudDialog controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCustomer(customer);

        dialogStage.showAndWait();

        return controller.isButtonConfirmClicked();
    }

    @FXML
    void handleLoginButton(ActionEvent event) {
        try {
            SceneChanger.changeScene("LoginPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
