package com.algo.backup.programmers.prog_11.prog_1103_real_001;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 6;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"7b", "6r", "6b"};
        n[index++] = new String[]{"6b", "7r", "7b"};
        n[index++] = new String[]{"1b", "4r", "3b"};
        n[index++] = new String[]{"9b", "9r", "7b"};
        n[index++] = new String[]{"1r", "9b", "9r"};
        n[index++] = new String[]{"9b", "1r", "9r"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //5b, 5r, 7r, 8b, 8r
        //5b, 5r, 8b, 8r
        //1r, 2b
        //8b
        //lose
        //1b, 2b, 2r, 3b, 3r, 4b, 4r, 5b, 5r, 6b, 6r, 7b, 7r, 8b, 8r
    }

    public static String[] solution(String[] cards) {
        return null;
    }
}
