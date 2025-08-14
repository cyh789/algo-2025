package com.algo.programmers.prog_0814_queueNstack_102_기능개발;

import java.util.*;

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
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            int cal = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] > 0) cal++;
            queue.add(cal);
        }

        List<Integer> list = new ArrayList<>();
        int current = queue.poll();
        int count = 1;
        while (true) {
            int next = queue.poll();
            if (next <= current) count++;
            else {
                current = next;
                list.add(count);
                count = 1;
            }

            if (queue.isEmpty()) {
                list.add(count);
                break;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}