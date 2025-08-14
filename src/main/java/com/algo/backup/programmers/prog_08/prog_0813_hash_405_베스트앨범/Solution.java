package com.algo.backup.programmers.prog_08.prog_0813_hash_405_베스트앨범;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"classic", "pop", "classic", "classic", "pop"}	;
        index = 0;

        int[][] m = new int[arrIndex][];
        m[index++] = new int[]{500, 600, 150, 800, 2500}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], m[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //4, 1, 3, 0
        //
    }

    public static int[] solution(String[] genres, int[] plays) {


        List<Integer> answer = new ArrayList<>();

        return answer.stream().mapToInt(i -> i).toArray();
    }
}