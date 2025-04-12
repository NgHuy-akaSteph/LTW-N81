package com.nhom81.model;

import java.io.Serializable;

public class SoHoc implements Serializable {

    private double num1=0, num2=0;
    String operator="+";
    double result;

    public SoHoc() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getKetQua() {
        String s = "";
        switch (operator) {
            case "+":
                result = num1 + num2;
                s = num1 + " + " + num2 + " = " + result;
                break;
            case "-":
                result = num1 - num2;
                s = num1 + " - " + num2 + " = " + result;
                break;
            case "*":
                result = num1 * num2;
                s = num1 + " * " + num2 + " = " + result;
                break;
            case "/":
                if (num2 == 0) {
                    s = "Error: Division by zero";
                } else {
                    result = num1 / num2;
                    s = num1 + " / " + num2 + " = " + result;
                }
                break;
        }
        return s;
    }
}
