package com.algo.backup.programmers.prog_11.prog_20251103_real_3;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{-4, 0, 2}, {-4, 0, 4}, {-4, 0, 6}, {2, 0, 8}};
        n[index++] = new int[][]{{1, 0, 2}, {-1, 0, 2}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //
    }

    public static int solution(int[][] circles) {
        return 0;
    }
}
