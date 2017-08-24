package com.example.darkbyte.calculator.controllers;

/**
 * Created by darkbyte on 19/08/17.
 */

public class Calculator {
    private float num1;
    private float num2;
    private  char op;

    public float execOperation() throws IllegalArgumentException {
        switch (this.op) {
            case '+':
                return sum();
            case '*':
                return mult();
            case '-':
                return sub();
            case '/':
                return division();
            default: return 0;
        }
    }

    public float sum(){
        return num1+num2;
    }
    public float sub(){
        return num1 - num2;
    }
    public float mult (){
        return num1* num2;
    }
    public float division() throws IllegalArgumentException{ // throw the exception if denominator = 0
        return num1/num2;
    }

    public float getNum1() {
        return num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public void setOp(char op){
        this.op = op;
    }
}
