package br.upe.controller;

import br.upe.entities.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerCrudDialog {
    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private Label labelCustomerCep;

    @FXML
    private Label labelCustomerCpf;

    @FXML
    private Label labelCustomerDataNascimento;

    @FXML
    private Label labelCustomerEmail;

    @FXML
    private Label labelCustomerNome;

    @FXML
    private Label labelCustomerSaldo;

    @FXML
    private Label labelCustomerSexo;

    @FXML
    private Label labelCustomerTelefone;

    @FXML
    private TextField textFieldCep;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldDataNascimento;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldSaldo;

    @FXML
    private TextField textFieldSexo;

    @FXML
    private TextField textFieldTelefone;

    @FXML
    private Label labelAlertText;

    private Stage dialogStage;
    private boolean buttonConfirmClicked = false;
    private Customer customer;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @FXML
    public void handleButtonConfirmar(ActionEvent event) {
        if (validateDataInput()){
            customer.setName(textFieldNome.getText());
            customer.setCpf(textFieldCpf.getText());
            customer.setEmail(textFieldEmail.getText());
            try {
            customer.setDataNascimento(sdf.parse(textFieldDataNascimento.getText()));
            } catch (ParseException e){
                labelAlertText.setText("Formato de data inválida!");
                e.printStackTrace();
            }
            customer.setPhone(textFieldTelefone.getText());
            customer.setCep(textFieldCep.getText());
            customer.setSexo(textFieldSexo.getText());
            customer.setSaldo(Double.parseDouble(textFieldSaldo.getText()));

            buttonConfirmClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        dialogStage.close();
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmClicked() {
        return buttonConfirmClicked;
    }

    public void setButtonConfirmClicked(boolean buttonConfirmClicked) {
        this.buttonConfirmClicked = buttonConfirmClicked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            this.textFieldNome.setText(customer.getName());
            this.textFieldCpf.setText(customer.getCpf());
            this.textFieldEmail.setText(customer.getEmail());
            if (customer.getDataNascimento() != null) {
                this.textFieldDataNascimento.setText(sdf.format(customer.getDataNascimento()));
            }
            this.textFieldTelefone.setText(customer.getPhone());
            this.textFieldCep.setText(customer.getCep());
            this.textFieldSexo.setText(customer.getSexo());
            if (customer.getSaldo() != null) {
                this.textFieldSaldo.setText(String.valueOf(customer.getSaldo()));
            }
        }
    }

    private boolean validateDataInput(){
        String errorMessage = "";

        if (textFieldNome.getText() == null || textFieldNome.getText().isEmpty()){
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldCpf.getText() == null || textFieldCpf.getText().isEmpty()){
            errorMessage += "CPF inválido!\n";
        }
        if (textFieldEmail.getText() == null || textFieldEmail.getText().isEmpty()){
            errorMessage += "Email inválido!\n";
        }
        if (textFieldDataNascimento.getText() == null || textFieldDataNascimento.getText().isEmpty()){
            errorMessage += "Data de Nascimento inválida!\n";
        }
        if (textFieldTelefone.getText() == null || textFieldTelefone.getText().isEmpty()){
            errorMessage += "Número de telefone inválido!\n";
        }
        if (textFieldCep.getText() == null || textFieldCep.getText().isEmpty()){
            errorMessage += "CEP inválido!\n";
        }
        if (textFieldSexo.getText() == null || textFieldSexo.getText().isEmpty()){
            errorMessage += "Sexo inválido!\n";
        }
        if (textFieldSaldo.getText() == null || textFieldSaldo.getText().isEmpty()){
            errorMessage += "Saldo inválido!\n";
        }

        if (errorMessage.isEmpty()){
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor corrija!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
