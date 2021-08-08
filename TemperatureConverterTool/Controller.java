package com.shariq.java;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField userInputField;

    @FXML
    public Button convertButton;

    private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
private static final String F_TO_C_TEXT="Fahrenheit to Celcius";

private boolean isC_TO_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {




        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_TO_F_TEXT)){
                isC_TO_F=true;
            }else{
                isC_TO_F=false;
            }

        });

        convertButton.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {
        String input = userInputField.getText();


        float enteredTemperature=0.0f;
        try {
             enteredTemperature = Float.parseFloat(input);
        }catch (Exception exception){
            warnUser();
            return;
        // No code executed-------
        }


        float newTemperature = 0.0f;
        if(isC_TO_F){             //User has selected to Celsius To Fahrenheit
            newTemperature=(enteredTemperature*9/5)+32;
        }else{                    //User has selected to Fahrenheit To Celsius
            newTemperature=(enteredTemperature-32)*5/9;
        }
        display(newTemperature);
    }

    private void warnUser() {

        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occured");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();

    }

    private void display(float newTemperature) {
        String unit = isC_TO_F? "F" : "C";
        System.out.println("The new temperature is"+ newTemperature);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is:"+newTemperature +unit);
       alert.show();
    }
}

