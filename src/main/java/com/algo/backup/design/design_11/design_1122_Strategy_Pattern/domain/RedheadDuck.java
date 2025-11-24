package com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain;

import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.FlyNoWay;
import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.behavior.Squeak;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        quackBehavior = new Squeak();
        flyBehavior = new FlyNoWay();
    }

    @Override
    public void display() {
        System.out.println("RedheadDuck : display");
    }
}
