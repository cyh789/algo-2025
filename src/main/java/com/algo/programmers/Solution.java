package com.algo.programmers;

//카드뭉치
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
        return answer;
    }
}
