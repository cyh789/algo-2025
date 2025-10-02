package com.algo.backup.programmers.prog_08.prog_0821_queueNstack_305_다리를_지나는_트럭;

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

        int pollCount = 0;
        int bridgeWeight = 0;
        int truck_weights_idx = 0;
        while (!bridge.isEmpty()) {
            //poll
            int prev = bridge.poll();
            bridgeWeight -= prev;
            pollCount++;

            //offer
            if (truck_weights_idx < truck_weights.length) {
                int selected = truck_weights[truck_weights_idx];
                if (bridgeWeight + selected <= weight) {
                    bridge.offer(selected);
                    bridgeWeight += selected;

                    truck_weights_idx++;
                } else {
                    bridge.offer(0);
                }
            }
        }

        return pollCount;
    }

}
