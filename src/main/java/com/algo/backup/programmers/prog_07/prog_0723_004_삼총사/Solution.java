package com.algo.backup.programmers.prog_07.prog_0723_004_삼총사;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{-2, 3, 0, 2, -5};
        n[index++] = new int[]{-3, -2, -1, 0, 1, 2, 3};
        n[index++] = new int[]{-1, 1, -1, 1};

        for (int[] ints : n) {
            int answer = solution(ints);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //5
        //0
    }

    public static int solution(int[] number) {
        int count = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        //System.out.println("i=" + number[i] + " / j=" + number[j] + " / k=" + number[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
