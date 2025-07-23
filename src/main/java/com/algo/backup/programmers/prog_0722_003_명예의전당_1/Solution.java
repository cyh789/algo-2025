package com.algo.backup.programmers.prog_0722_003_명예의전당_1;

import java.util.Arrays;

//카드뭉치
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 3;
        n[index++] = 4;
        index = 0;

        int[][] l = new int[arrIndex][];
        l[index++] = new int[]{10, 100, 20, 150, 1, 100, 200};
        l[index++] = new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], l[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //[10, 10, 10, 20, 20, 100, 100
        //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300
    }

    public static int[] solution(int k, int[] score) {
        int period = score.length;
        int[] honor = new int[k];
        for (int i = 0; i < honor.length; i++) {
            honor[i] = Integer.MIN_VALUE;
        }
        int[] dailyLowHonorScore = new int[period];

        int firstSelected = Integer.MAX_VALUE;
        for (int i = 0; i < score.length; i++) {
            int selected = score[i];
            if (i < k) {
                honor[i] = selected;

                firstSelected = Math.min(firstSelected, selected);
                dailyLowHonorScore[i] = firstSelected;
            } else {
                Arrays.sort(honor);
                if (honor[0] <= selected) {
                    honor[0] = selected;
                }

                Arrays.sort(honor);
                dailyLowHonorScore[i] = honor[0];
            }
        }

        return dailyLowHonorScore;
    }
}
