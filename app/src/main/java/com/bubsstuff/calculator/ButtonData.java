package com.bubsstuff.calculator;

public class ButtonData {
    public String text;
    public int row;
    public int column;
    public int colSpan;

    public  ButtonData(String text, int row, int column, int colSpan) {
        this.text = text;
        this.row = row;
        this.column = column;
        this.colSpan = colSpan;
    }
}
