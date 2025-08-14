package com.algo.backup.programmers.prog_08.prog_0813_queueNstack_001_같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1,1,3,3,0,1,1}	;
        n[index++] = new int[]{4,4,4,3,3}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //1,3,0,1
        //4,3
    }

    public static int[] solution(int[] arr) {

        List<Integer> answer = new ArrayList<>();
        int current = arr[0];
        answer.add(current);
        for (int i = 0; i < arr.length - 1; i++) {
            int next = arr[i+1];
            if (current != next) {
                current = next;
                answer.add(next);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}