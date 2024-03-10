package br.upe.controller;

import br.upe.util.MaskedTextField;
import br.upe.util.SceneChanger;
import br.upe.validation.ValidaFuncionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginPageController {

    @FXML
    private MaskedTextField cpf;
    @FXML
    private Label msgError;
    @FXML
    private PasswordField pass;

    private String cpfTextLabel;

    @FXML
    public void handleLoginAction(ActionEvent event) {
        String cpfText = cpf.getText();
        String passText = pass.getText();
        cpfTextLabel = cpfText;
        String cpfLimpo = cpfText.replaceAll("[^0-9]", "");

       if (ValidaFuncionario.isValido(cpfLimpo, passText)) {
            try {
                SceneChanger.changeScene("MainPage");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msgError.setText("Por favor, preencha corretamente\n todos os campos");
        }

    }
}
