package com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain;

import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.FlyBehavior;
import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.QuackBehavior;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performQuack() {
        quackBehavior.quack();
    }
    public void performFly() {
        flyBehavior.fly();
    }
    public void swim() {
        System.out.println("swim");
    }
}
