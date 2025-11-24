package com.algo.backup.design.design_11.design_1122_Template_Method_Pattern;

import com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain.CaffeineBeverage;
import com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain.Coffee;
import com.algo.backup.design.design_11.design_1122_Template_Method_Pattern.domain.Tea;

public class Solution {

    public static void main(String[] args) {
        CaffeineBeverage beverage = new Coffee();
        beverage.prepareRecipe();

        beverage = new Tea();
        beverage.prepareRecipe();
    }
}
