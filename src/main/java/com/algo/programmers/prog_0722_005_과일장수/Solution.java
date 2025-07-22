package com.algo.programmers.prog_0722_005_과일장수;

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

        int[] m = new int[arrIndex];
        m[index++] = 4;
        m[index++] = 3;
        index = 0;

        int[][] l = new int[arrIndex][];
        l[index++] = new int[]{1, 2, 3, 1, 2, 3, 1};
        l[index++] = new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //8
        //33
    }

    public static int solution(int k, int m, int[] score) {

        Arrays.sort(score);
        int end = score.length % m - 1;

        int count  = 0;
        int sum = 0;
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == end && i > 0) {
                break;
            }

            count++;
            if (count == m) {
                sum += score[i] * m;
                count = 0;
            }
        }

        return sum;
    }
}
