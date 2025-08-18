package com.algo.backup.programmers.prog_08.prog_0814_queueNstack_004_프로세스;

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
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentPriority = map.get(current);

            //큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
            // => 전체탐색 필요
            boolean stop = false;
            for (int idx : queue) {
                System.out.println(idx);
                if (map.get(idx) > currentPriority) {
                    stop = true;
                    break;
                }
            }
            System.out.println("---------------");

            if (stop) queue.add(current); // 다시 뒤로 보냄
            else {
                count++;
                System.out.println("count=" + count);
                if (current == location) return count;
            }
        }


        return -1;
    }
}
