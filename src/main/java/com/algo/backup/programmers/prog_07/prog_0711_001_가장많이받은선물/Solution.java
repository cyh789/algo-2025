package com.algo.backup.programmers.prog_07.prog_0711_001_가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

//2024 KAKAO WINTER INTERNSHIP
//가장 많이 받은 선물
public class Solution {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//        //2
//        String[] friends={"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts={"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
//        //4
//        String[] friends={"a", "b", "c"};
//        String[] gifts={"a b", "b a", "c a", "a c", "a c ", "c a"};
//        //0
        int answer = solution(friends, gifts);
        System.out.println(answer);
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;

        //String friends[i] => int friendIndex
        Map<String, Integer> friendIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        //두 사람이 선물을 주고받은 기록 => 이차원 배열로 표시
        int[][] giftTable = new int[n][n];
        //선물 지수 = 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
        int[] giftScore = new int[n];
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String giver = parts[0];
            String receiver = parts[1];
            int giverIndex = friendIndex.get(giver);
            int receiverIndex = friendIndex.get(receiver);
            giftTable[giverIndex][receiverIndex]++;

            giftScore[giverIndex]++;
            giftScore[receiverIndex]--;
        }

        //다음 달에 선물을 하나 받습니다. => 일차원 배열로 표시
        int[] nextMonthGifts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //두 사람이 선물을 주고받은 기록이 있다면,
                //  이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                if (giftTable[i][j] > giftTable[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftTable[i][j] < giftTable[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    //두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면,
                    //  선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGifts[j]++;
                    }

                    //만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
                }
            }
        }

        //위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때,
        //   당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
        for (int nextMonthGift : nextMonthGifts) {
            answer = Math.max(answer, nextMonthGift);
        }

        return answer;
    }
}
