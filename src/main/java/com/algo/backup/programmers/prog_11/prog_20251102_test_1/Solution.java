package com.algo.backup.programmers.prog_11.prog_20251102_test_1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{1,4},{3,4},{3,10}};
        n[index++] = new int[][]{{1,1},{2,2},{1,2}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //
    }

    public static int[] solution(int[][] v) {


        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            int x = v[i][0];
            int y = v[i][1];
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
            mapY.put(y, mapY.getOrDefault(y, 0) + 1);
        }

        int[] answer = new int[2];
        for (Map.Entry e : mapX.entrySet()) {
            if ((int) e.getValue() == 1) answer[0] = (int) e.getKey();
        }
        for (Map.Entry e : mapY.entrySet()) {
            if ((int) e.getValue() == 1) answer[1] = (int) e.getKey();
        }

        return answer;
    }
}
