package com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain;

import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.FlyWithWings;
import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("MallardDuck : display");
    }
}
