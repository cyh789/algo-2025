package com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain;

public class Tea extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Tea : brew");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Tea : brew");
    }
    @Override
    boolean customerWantsCondiments() {
        return false;
    }
}
