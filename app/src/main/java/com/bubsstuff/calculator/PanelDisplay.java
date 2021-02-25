package com.bubsstuff.calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class PanelDisplay extends AppCompatTextView {
    String expression = "";

    public PanelDisplay(Context context) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 1);
        params.columnSpec = GridLayout.spec(0, 3, 1);
        setGravity(Gravity.END);
        setTextColor(getResources().getColor(R.color.white, null));
        setTextSize(24);
        setLayoutParams(params);
        setExpression(expression);
    }

    public void setExpression(String expression) {
        this.expression = expression;
        setText(expression);
    }

    public String getExpression() {
        return expression;
    }
}
