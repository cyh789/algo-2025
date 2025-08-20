package com.algo.backup.programmers.prog_08.prog_0819_queueNstack_004_프로세스;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{2, 1, 3, 2};
        n[index++] = new int[]{1, 1, 9, 1, 1, 1};
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 2;
        m[index++] = 0;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //1
        //5
    }

    public static int solution(int[] priorities, int location) {
        return 0;
    }
}
