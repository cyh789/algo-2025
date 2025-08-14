package com.algo.programmers.prog_0814_queueNstack_002_기능개발;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{93, 30, 55}	;
        n[index++] = new int[]{95, 90, 99, 99, 80, 99}	;
        index = 0;
        int[][] m = new int[arrIndex][];
        m[index++] = new int[]{1, 30, 5}	;
        m[index++] = new int[]{1, 1, 1, 1, 1, 1}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], m[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //2,1
        //1,3,2
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] cal = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            cal[i] = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) cal[i]++;
        }

//        System.out.println(Arrays.toString(cal));

        List<Integer> list = new ArrayList<>();
        int current = cal[0];
        int count = 1;
        for (int i = 1; i < cal.length; i++) {
            if (cal[i] <= current) count++;
            else {
                current = cal[i];
                list.add(count);
                count = 1;
            }
        }
        list.add(count);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}