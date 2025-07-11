package com.algo.backup.programmers.prog_07.prog_0702_006;

import java.util.HashMap;
import java.util.Map;

//[PCCP 기출문제] 1번 / 붕대 감기
public class Solution {
    public static void main(String[] args) {
        int[] bandage = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10}, {9,15}, {10,5}, {11,5}};
        //answer = 5
        int answer = solution(bandage, health, attacks);
        System.out.println(answer);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        Map<Integer, Integer> attackInfo = new HashMap<>();
        int endTime = 0;
        int sucTime = 0;
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
            endTime = attack[0];
        }

        for (int i = 1; i <= endTime; i++) {
            if (attackInfo.containsKey(i)) {
                answer -= attackInfo.get(i);
                sucTime = 0;
            } else {
                answer += bandage[1];
                sucTime++;
                if (sucTime == bandage[0]) {
                    answer += bandage[2];
                    sucTime = 0;
                }
                if (answer > health) answer = health;
            }

            if (answer <= 0) return -1;
        }

        return answer;
    }


}
