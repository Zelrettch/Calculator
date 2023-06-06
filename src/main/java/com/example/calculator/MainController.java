package com.example.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clear_button;

    @FXML
    private Button divide_button;

    @FXML
    private Button equals_button;

    @FXML
    private Label label_res;

    @FXML
    private Button minus_button;

    @FXML
    private Button multiply_button;

    @FXML
    private Button percent_button;

    @FXML
    private Button plus_button;

    @FXML
    private Button plus_minus_button;

    @FXML
    private Button comma;

    String first_num = "0";
    String option = "";
    String second_num = "";

    @FXML
    void addNumber(ActionEvent event) {
        if(option.equals("")) {
            first_num += ((Button) event.getSource()).getText();
            label_res.setText(first_num);
        } else {
            second_num += ((Button) event.getSource()).getText();
            label_res.setText(first_num + " " + option + " " + second_num);
        }
    }

    private boolean condition(){
        return (!first_num.equals("") && second_num.equals(""));
    }

    private void display() {
        label_res.setText(first_num + " " + option);
    }

    @FXML
    void initialize() {

        comma.setOnAction(actionEvent -> {

        });

        plus_button.setOnAction(actionEvent -> {
            if(condition()){
                option = "+";
                display();}
        });
        minus_button.setOnAction(actionEvent -> {
            if(condition()){
                option = "-";
                display();}
        });
        divide_button.setOnAction(actionEvent -> {
            if(condition()){
                option = "/";
                display();}
        });
        multiply_button.setOnAction(actionEvent -> {
            if(condition()){
                option = "*";
                display();}
        });
        equals_button.setOnAction(actionEvent -> {
            if (!first_num.equals("") && !option.equals("") && !second_num.equals("")) {
                if(Double.parseDouble(second_num) == 0 && option.equals("/"))
                    label_res.setText("You can not divide by 0");
                else {
                    first_num = (Double.toString(mathAction()));
                    second_num = "";
                    option = "";
                    label_res.setText(first_num);
                }
            }
        });
        clear_button.setOnAction(actionEvent -> {
            first_num = "";
            second_num = "";
            option = "";
            label_res.setText("0");
        });
    }

    private double mathAction() {
        double a = Double.parseDouble(first_num);
        double b = Double.parseDouble(second_num);
        double res;

        switch (option) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            default: res = 0;
        }
        return ((double) Math.round(res * 100))/ 100;
    }

}
