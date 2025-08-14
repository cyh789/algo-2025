package com.algo.backup.programmers.prog_08.prog_0812_hash_002_폰켓몬;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{3,1,2,3}		;
        n[index++] = new int[]{3,3,3,2,2,4}	;
        n[index++] = new int[]{3,3,3,2,2,2}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //3
        //2
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int selectedNum = nums.length / 2;
        if (selectedNum <= set.size()) return selectedNum;

        return set.size();
    }
}
