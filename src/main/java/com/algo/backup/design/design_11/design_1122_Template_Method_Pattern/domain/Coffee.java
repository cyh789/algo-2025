package com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain;

public class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Coffee : brew");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Coffee : addCondiments");
    }
}
