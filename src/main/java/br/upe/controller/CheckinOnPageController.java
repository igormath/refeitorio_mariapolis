package br.upe.controller;

import br.upe.entities.Customer;
import br.upe.util.CustomerModel;
import br.upe.util.Facade;
import br.upe.util.SceneChanger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CheckinOnPageController {
    @FXML
    private Label labelCheckInCliente;

    @FXML
    private Label labelCheckInCpf;

    @FXML
    private Label labelCheckInSaldo;

    private Customer customer;
    Facade facade = new Facade();

    @FXML
    public void initialize(){
        int countdownDurationInSeconds = 3;
        Timeline timeline = new Timeline();
        timeline.setCycleCount(1);

        customer = CustomerModel.getInstance().getCustomer();
        customer.deductMealCost();
        facade.updateCustomer(customer);
        labelCheckInCliente.setText(customer.getName());
        labelCheckInCpf.setText(customer.getCpf());
        labelCheckInSaldo.setText(String.valueOf(customer.getSaldo()));

        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(countdownDurationInSeconds),
                event -> {
                    try{
                        SceneChanger.changeScene("MainPage");
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
        );
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }
}
