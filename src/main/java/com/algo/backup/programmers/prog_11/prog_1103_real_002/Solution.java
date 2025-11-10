package com.algo.backup.programmers.prog_11.prog_1103_real_002;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 21;
        n[index++] = 0;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //4
        //0
    }

    public static int solution(int n) {
        int[] sg = new int[]{6, 2, 5, 5, 4, 5, 6, 4, 7, 6};
        //더하기, 빼기, 나누기, 곱하기
        int[] msg = new int[]{2, 1, 1, 2};

        return 0;
    }
}
