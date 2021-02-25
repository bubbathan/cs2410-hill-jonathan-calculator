package com.bubsstuff.calculator;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class CalculatorButton extends AppCompatButton {
    public CalculatorButton(Context context, ButtonData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.column, data.colSpan, 1);
        params.setMargins(18, 18, 18, 18);
        setLayoutParams(params);
        if (data.backgroundColor != null) {
            setBackgroundColor(data.backgroundColor);
        } else {
            setBackgroundColor(getResources().getColor(R.color.calculator_background, null));
        }

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if (motionEvent.getAction() == motionEvent.ACTION_DOWN) {
                    if (data.text.equals("=")) {
                        setBackgroundColor(getResources().getColor(R.color.equal_push_background, null));
                    } else {
                        setBackgroundColor(getResources().getColor(R.color.push_background, null));
                    }
                } else if (motionEvent.getAction() == motionEvent.ACTION_UP){
                    setBackgroundColor(data.backgroundColor == null ? getResources().getColor(R.color.calculator_background, null) : data.backgroundColor);
                }
                return false;
            }
        });
        if (data.textColor != null) {
            setTextColor(data.textColor);
        } else {
            setTextColor(getResources().getColor(R.color.white, null));
        }
        setTextSize(24);
        setText(data.text);
    }
}
