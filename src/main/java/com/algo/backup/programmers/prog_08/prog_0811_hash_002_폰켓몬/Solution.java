package com.algo.backup.programmers.prog_08.prog_0811_hash_002_폰켓몬;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{3,1,2,3}		;
        n[index++] = new int[]{3,3,3,2,2,4}	;
        n[index++] = new int[]{3,3,3,2,2,2}	;
        index = 0;

        for (int[] ints : n) {
            int answer = solution(ints);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //3
        //2
    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int numTemp = nums.length / 2;

        return Math.min(numTemp, map.size());

    }
}
