package com.bubsstuff.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ButtonData> buttonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeData();

        GridLayout mainLayout = new GridLayout(this);
        mainLayout.setColumnCount(4);
        PanelDisplay display = new PanelDisplay(this);
        mainLayout.addView(display);

        for(ButtonData data: buttonData) {
            CalculatorButton button = new CalculatorButton(this, data);
            button.setOnClickListener((view) -> {
                if (data.text.equals("=")) {
                    double expressionValue = Calculator.evaluate(display.getExpression());
                    if (Double.isNaN(expressionValue)) {
                        display.setExpression("Invalid input");
                    } else {
                        display.setExpression(String.valueOf(expressionValue));
                    }
                } else if(data.text.equals("C")) {
                    display.setExpression("");
                } else if (data.text.equals("X") || data.text.equals("/") || data.text.equals("-") || data.text.equals("+")) {
                    display.setExpression(display.getExpression() + " " + data.text + " ");
                } else {
                    display.setExpression(display.getExpression() + data.text);
                }
            });
            mainLayout.addView(button);
        }

        setContentView(mainLayout);
    }

    private void initializeData() {
        buttonData = new ArrayList<ButtonData>(){
            {
                add(new ButtonData("C", 0, 3, 1));
                add(new ButtonData("7", 1, 0, 1));
                add(new ButtonData("8", 1, 1, 1));
                add(new ButtonData("9", 1, 2, 1));
                add(new ButtonData("/", 1, 3, 1));
                add(new ButtonData("4", 2, 0, 1));
                add(new ButtonData("5", 2, 1, 1));
                add(new ButtonData("6", 2, 2, 1));
                add(new ButtonData("X", 2, 3, 1));
                add(new ButtonData("1", 3, 0, 1));
                add(new ButtonData("2", 3, 1, 1));
                add(new ButtonData("3", 3, 2, 1));
                add(new ButtonData("-", 3, 3, 1));
                add(new ButtonData("0", 4, 0, 2));
                add(new ButtonData(".", 4, 2, 1));
                add(new ButtonData("+", 4, 3, 1));
                add(new ButtonData("=", 5, 0, 4));
            }
        };
    }
}