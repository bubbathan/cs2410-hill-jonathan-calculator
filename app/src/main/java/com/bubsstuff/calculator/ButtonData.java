package com.bubsstuff.calculator;

import android.graphics.Color;

import java.security.PublicKey;

public class ButtonData {
    public String text;
    public int row;
    public int column;
    public int colSpan;
    public Integer backgroundColor;
    public Integer textColor;

    public ButtonData(String text, int row, int column, int colSpan) {
        this(text, row, column, colSpan, null, null);
    }

    public  ButtonData(String text, int row, int column, int colSpan, Integer backgroundColor, Integer textColor) {
        this.text = text;
        this.row = row;
        this.column = column;
        this.colSpan = colSpan;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }
}
