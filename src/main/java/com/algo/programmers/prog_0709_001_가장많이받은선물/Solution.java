package com.algo.programmers.prog_0709_001_가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

//2024 KAKAO WINTER INTERNSHIP
//가장 많이 받은 선물
public class Solution {
    public static void main(String[] args) {
        String[] friends={"muzi", "ryan", "frodo", "neo"};
        String[] gifts={"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        //2
//        String[] friends={"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts={"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
//        //4
//        String[] friends={"a", "b", "c"};
//        String[] gifts={"a b", "b a", "c a", "a c", "a c", "c a"}
//        //0
        int answer = solution(friends, gifts);
        System.out.println(answer);
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int n = friends.length;
        int[][] giftTable = new int[n][n];
        Map<String, Integer> friendIndex = new HashMap<>();
        int[] giftScore = new int[n];
        int[] nextMonthGifts = new int[n];

        // 친구 인덱스 매핑
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        // 선물 기록 분석
        for (int i = 0; i < gifts.length; i++) {
            String[] parts = gifts[i].split(" ");
            int giverIndex = friendIndex.get(parts[0]);
            int receiverIndex = friendIndex.get(parts[1]);
            giftTable[giverIndex][receiverIndex]++;
            giftScore[giverIndex]++;
            giftScore[receiverIndex]--;
        }

        // 다음 달 선물 예측
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (giftTable[i][j] > giftTable[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftTable[i][j] < giftTable[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    } else {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        // 최대 선물 수 계산
        for (int giftsReceived : nextMonthGifts) {
            answer = Math.max(answer, giftsReceived);
        }
        return answer;
    }

}
