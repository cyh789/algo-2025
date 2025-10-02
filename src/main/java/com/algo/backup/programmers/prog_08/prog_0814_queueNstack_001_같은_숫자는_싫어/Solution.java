package com.algo.backup.programmers.prog_08.prog_0814_queueNstack_001_같은_숫자는_싫어;

import java.util.Arrays;
import java.util.Stack;

@SuppressWarnings("UnusedAssignment")
class Solution {
    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1,1,3,3,0,1,1}	;
        n[index++] = new int[]{4,4,4,3,3}	;
        index = 0;

        for (int[] ints : n) {
            int[] answer = solution(ints);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //1,3,0,1
        //4,3
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int selected : arr) {
            if (stack.isEmpty() || stack.peek() != selected) stack.push(selected);
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}