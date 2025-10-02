package com.algo.backup.programmers.prog_08.prog_0821_queueNstack_205_다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 2;
        n[index++] = 100;
        n[index++] = 100;
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 10;
        m[index++] = 100;
        m[index++] = 100;
        index = 0;

        int[][] l = new int[arrIndex][];
        l[index++] = new int[]{7,4,5,6};
        l[index++] = new int[]{10};
        l[index++] = new int[]{10,10,10,10,10,10,10,10,10,10};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //8
        //101
        //110
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int sum = 0;
        int idx = 0;
        while (!bridge.isEmpty()) {
            // 한 칸 제거하고 시작
            // 무게 계산
            // 시간 경과
            sum -= bridge.poll();
            time++;

            if (idx < truck_weights.length) {
                int selectedTruck = truck_weights[idx];
                if (weight < sum + selectedTruck) {
                    // 빈 칸 추가
                    bridge.offer(0);
                } else {
                    // 트럭무게 한 칸 추가
                    // 무게 계산
                    bridge.offer(selectedTruck);
                    sum += selectedTruck;
                    idx++;
                }
            }
        }

        return time;
    }
}
