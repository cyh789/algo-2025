package com.algo.backup.programmers.prog_07.prog_0721_003_카드뭉치;

import java.util.HashMap;
import java.util.Map;

//카드뭉치
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[][] n = new String[2][];
        n[index++] = new String[]{"i", "drink", "water"};
        n[index++] = new String[]{"i", "water", "drink"};
        index = 0;

        String[][] m = new String[2][];
        m[index++] = new String[]{"want", "to"};
        m[index++] = new String[]{"want", "to"};
        index = 0;

        String[][] l = new String[2][];
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"Yes"
        //"No"
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        //mapping cards1, cards2
        //for i cards1
        //for i cards2
        int cards1Index = 1;
        Map<String, Integer> map1 = new HashMap<>();
        for (String string : cards1) {
            map1.put(string, cards1Index++);
        }

        int cards2Index = 1;
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : cards2) {
            map2.put(s, cards2Index++);
        }

        int currentCards1Index = 1;
        int currentCards2Index = 1;
        for (String selected : goal) {
            if (map1.containsKey(selected) && map1.get(selected) == currentCards1Index) {
                currentCards1Index++;
            } else {
                if (map2.containsKey(selected) && map2.get(selected) == currentCards2Index) {
                    currentCards2Index++;
                } else {
                    return "No";
                }
            }
        }
        return "Yes";
    }
}
