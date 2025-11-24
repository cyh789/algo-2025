package com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain;

public abstract class CaffeineBeverage {
    final public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();

        if (customerWantsCondiments())
            addCondiments();
    }

    abstract void brew();
    abstract void addCondiments();

    private void boilWater() {
        System.out.println(" : 물을 끓이는 중");
    }
    private void pourInCup() {
        System.out.println(" : 컵에 따르는 중");
    }

    // 후크
    boolean customerWantsCondiments() {
        return true;
    }


}
