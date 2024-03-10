package br.upe.controller;

import br.upe.entities.Customer;
import br.upe.util.Facade;
import br.upe.util.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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
    public void initialize() {
        loadTableViewCustomers();
        tableViewCustomers.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> selectItemTableViewCustomers(newValue)));
    }

    public void loadTableViewCustomers() {
        tableColumnCustomerCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnCustomerName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCustomerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnCustomerSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo_cafe"));

        customers = facade.getAllCustomers();

        observableListCustomers = FXCollections.observableArrayList(customers);
        tableViewCustomers.setItems(observableListCustomers);
    }

    public void selectItemTableViewCustomers(Customer customer) {
        if (customer != null) {
            labelCustomerName.setText(customer.getNome());
            labelCustomerCpf.setText(customer.getCpf());
            labelCustomerEmail.setText(customer.getEmail());
            labelCustomerPhone.setText(customer.getTelefone());
            labelCustomerCep.setText(customer.getCep());
            labelCustomerSaldo.setText(String.valueOf(customer.getSaldo_cafe()));
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

}
