package com.company;

/**
 * Created by ZhdankiFam on 01.05.2015.
 */
public class Model {
    private double oper1 = 0;
    private char operation;

    public void action(String oper1, char operation) {
        this.oper1 = Double.parseDouble(oper1);
        this.operation = operation;
    }

    public double calculate(String oper2) {
        double op2 = Double.parseDouble(oper2);
        double result = 0;

        if (operation == '+') {
            result = oper1 + op2;
        } else if (operation == '-') {
            result = oper1 - op2;
        } else if (operation == '*') {
            result = oper1 * op2;
        } else if (operation == '/') {
            result = oper1 / op2;
        } else if (operation == '%') {
            result = (oper1 / 100) * op2;
        }
        return result;
    }


}


