package com.algo.backup.design.design_11.design_1122_Strategy_Pattern;

import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain.Duck;
import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain.MallardDuck;
import com.algo.backup.design.design_11.design_1122_Strategy_Pattern.domain.RedheadDuck;

public class Solution {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
        duck.performQuack();
        duck.performFly();

        duck = new RedheadDuck();
        duck.display();
        duck.performQuack();
        duck.performFly();
    }
}
