package com.example.lesson2_android_homework;

import java.util.Map;

public class Calculator {

    String mainNumber;
    String conteiner;
    String operator;


    boolean startOperation = false;
    boolean startOperationSin = false;


    public Calculator() {
        mainNumber = "0";
        conteiner = "";
        operator = "";
    }

    public long Calculate(String first, String second, String operator) {
        long firstNumber = 0;
        long secondNumber = 0;
        try {
            firstNumber = Long.parseLong(first);
            secondNumber = Long.parseLong(second);
        } catch (NumberFormatException e) {

        }


        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    return 0;
                }
                return firstNumber / secondNumber;
        }
        return 0;
    }

    public void input(String buttonText) {
        switch (buttonText) {
            case ("+"): {
                calculateAndSet(mainNumber, "+");
                break;
            }
            case ("-"): {
                calculateAndSet(mainNumber, "-");
                break;
            }
            case ("/"): {
                calculateAndSet(mainNumber, "/");
                break;
            }
            case ("*"): {
                calculateAndSet(mainNumber, "*");
                break;
            }

            case ("C"): {
                mainNumber = "0";
                conteiner = "";
                break;
            }
            case ("="): {
                ButtonEqually();
                break;
            }
            default: {
                if (mainNumber.equals("0")) {
                    mainNumber = buttonText;
//                    conteiner = mainNumber;
                } else {

                    if (startOperation) {
                        mainNumber = "";
                        startOperation = false;
                    }
                    startOperationSin = true;
                    mainNumber += buttonText;
                }
            }
        }
//        return mainNumber;
    }

    public void calculateAndSet(String screenTitle, String operator) {


        this.operator = operator;
        startOperation = true;

        if (conteiner.length() > 0 && startOperationSin) {
            mainNumber = String.valueOf(Calculate(conteiner, mainNumber, operator));
        }
        startOperationSin = false;
        conteiner = mainNumber;

    }

    public void ButtonEqually() {
        mainNumber = String.valueOf(Calculate(conteiner, mainNumber, operator));
        startOperationSin = false;
    }

}