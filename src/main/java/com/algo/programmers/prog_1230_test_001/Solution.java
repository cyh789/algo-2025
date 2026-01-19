package com.algo.programmers.prog_1230_test_001;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{1, 4}, {3, 4}, {3, 10}};
        n[index++] = new int[][]{{1, 1}, {2, 2}, {1, 2}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //1 10
        //2 1
    }

    public static int[] solution(int[][] v) {
        Arrays.sort(v, (o1, o2) -> o1[0] - o2[0]);

        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for (int i = 0; i < v.length; i++) {
            if (!setX.add(v[i][0])) setX.remove(v[i][0]);
            if (!setY.add(v[i][1])) setY.remove(v[i][1]);
        }

        int[] answer = new int[2];
        answer[0] = setX.iterator().next();
        answer[1] = setY.iterator().next();

        return answer;
    }
}
