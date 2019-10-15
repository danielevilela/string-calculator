package com.dvilela.stringcalculator.model;

import java.util.List;

public class Word {

    private String value;
    private List<Integer> negatives;
    private int sum;


    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public List<Integer> getNegatives() {
        return negatives;
    }

    public void setNegatives(List<Integer> negatives) {

        this.negatives = negatives;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
