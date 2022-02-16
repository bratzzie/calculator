package com.stud.calc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {
    @FXML private Pane titlePane;
    @FXML private Button closeButton, minButton;
    @FXML private Label resultOutput;

    private double x, y;
    private double num1 = 0;
    private String operatorInMathView = "+";

    public void initialize(Stage stage) {
        titlePane.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        titlePane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        closeButton.setOnMouseClicked(mouseEvent -> stage.close());
        minButton.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    void onOperandClicked(MouseEvent event) {
        int operand = Integer.parseInt(((Label)event.getSource()).getId().replace("btn", ""));
        resultOutput.setText(Double.parseDouble(resultOutput.getText()) == 0 ? String.valueOf((double) operand)
                : String.valueOf(Double.parseDouble(resultOutput.getText())*10+operand)); // *10 - to avoid the collapse of numbers
    }

    @FXML
    void onOperatorClicked(MouseEvent event) {
        String operator = ((Label)event.getSource()).getId().replace("btn","");
        if(operator.equals("Equals")) {
            double num2 = Double.parseDouble(resultOutput.getText());
            switch (operatorInMathView) {
                case "+" -> resultOutput.setText(String.valueOf(num1+num2));
                case "-" -> resultOutput.setText(String.valueOf(num1-num2));
                case "*" -> resultOutput.setText(String.valueOf(num1*num2));
                case "/" -> resultOutput.setText(String.valueOf(num1/num2));
                case "%" -> resultOutput.setText(String.valueOf(num1%num2));
            }
            operatorInMathView = ".";
        }
        else if(operator.equals("MC") || operator.equals("AC")) {
            resultOutput.setText(String.valueOf(0.0));
            operatorInMathView = ".";
        }
        else {
            switch (operator) {
                case "Plus" -> operatorInMathView = "+";
                case "Minus" -> operatorInMathView = "-";
                case "Multiply" -> operatorInMathView = "*";
                case "Divide" -> operatorInMathView = "/";
                case "Mod" -> operatorInMathView = "%";
            }
            num1 = Double.parseDouble(resultOutput.getText());
            resultOutput.setText(String.valueOf(0.0));
        }
    }
}
