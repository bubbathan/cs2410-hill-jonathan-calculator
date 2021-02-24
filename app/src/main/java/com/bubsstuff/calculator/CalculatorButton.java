package com.bubsstuff.calculator;

import android.content.Context;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CalculatorButton extends AppCompatButton {
    public CalculatorButton(Context context, ButtonData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.column, data.colSpan, 1);
        setLayoutParams(params);
        setTextSize(24);
        setText(data.text);
    }
}
