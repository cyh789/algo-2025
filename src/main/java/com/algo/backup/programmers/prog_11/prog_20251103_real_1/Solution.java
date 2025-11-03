package com.algo.backup.programmers.prog_11.prog_20251103_real_1;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"7b", "6r", "6b"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //
    }

    public static String[] solution(String[] cards) {
        return null;
    }
}
