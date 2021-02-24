package com.bubsstuff.calculator;

public class Calculator {
    public static double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        if (tokens.length == 0) {
            return Double.NaN;
            //TODO: handle this error
        }

        if (tokens.length == 1) {
            if (tokens[0].equals("")) {
                return 0.0;
            }
            return Double.parseDouble(tokens[0]);
        }

        if (tokens.length == 2) {
            return Double.NaN;
        }

        double currentValue = Double.parseDouble(tokens[0]);
        String operation = tokens[1];
        String mode = "value";

        for (int i = 2; i < tokens.length; i++) {
            if (tokens[i].equals("")) {
                return Double.NaN;
            }
            if (mode.equals("value")) {
                double foundValue = Double.parseDouble(tokens[i]);

                if (operation.equals("+")) {
                    currentValue = currentValue + foundValue;
                }
                if (operation.equals("-")) {
                    currentValue = currentValue - foundValue;
                }
                if (operation.equals("X")) {
                    currentValue = currentValue * foundValue;
                }
                if (operation.equals("/")) {
                    currentValue = currentValue / foundValue;
                }
                mode = "operator";
            } else {
                operation = tokens[i];
                mode = "value";
            }
        }

        return currentValue;
    }
}
