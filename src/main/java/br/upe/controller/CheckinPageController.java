package br.upe.controller;

import br.upe.entities.Customer;
import br.upe.util.CustomerModel;
import br.upe.util.Facade;
import br.upe.util.SceneChanger;
import br.upe.util.getCustomer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class CheckinPageController {
    @FXML
    private Label labelCustomerEmail;

    @FXML
    private Label labelCustomerNome;

    @FXML
    private Label labelCustomerQuant;

    @FXML
    private Label labelCustomerSaldo;

    @FXML
    private Label labelCustomerAlert;

    @FXML
    private TextField textFieldCustomerCpf;

    Facade facade = new Facade();
    List<Customer> customers = null;

    Customer searchResult = null;

    @FXML
    public void initialize(){
        customers = facade.getAllCustomers();
        labelCustomerQuant.setText(String.valueOf(customers.size()));
    }

    @FXML
    void handleCustomerSearch(ActionEvent event) {
        searchResult = getCustomer.getCustomerByCpf(customers, textFieldCustomerCpf.getText());
        if (searchResult != null){
            labelCustomerNome.setText(searchResult.getName());
            labelCustomerEmail.setText(searchResult.getEmail());
            labelCustomerSaldo.setText(String.valueOf(searchResult.getSaldo()));
        } else {
            labelCustomerNome.setText("");
            labelCustomerEmail.setText("");
            labelCustomerSaldo.setText("");
            labelCustomerAlert.setText("Cliente não encontrado!");
        }
    }

    @FXML
    void handleHomeButton(ActionEvent event) {
        try {
            SceneChanger.changeScene("MainPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleConfirmButton(ActionEvent event) {
        if (searchResult.getSaldo() < 10){
            labelCustomerAlert.setText("Saldo insuficiente!");
        } else {
            CustomerModel.getInstance().setCustomer(searchResult);
            try {
                SceneChanger.changeScene("CheckinOnPage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
