package com.algo.programmers.prog_0912_graph_007_모음사전;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"i", "drink", "water"};
        n[index++] = new String[]{"i", "water", "drink"};
        index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "271";
        m[index++] = "7";
        index = 0;

        String[][] l = new String[arrIndex][];
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //
    }

    public static String solution(String[] cards1, String cards2, String[] goal) {
        String answer = "";
        return answer;
    }
}
