package com.algo.programmers.prog_0801_006_가장_많이_받은_선물;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//2024 KAKAO WINTER INTERNSHIP
//가장 많이 받은 선물
public class Solution {
    public static void main(String[] args) {
        String[][] friends = new String[3][];
        friends[0] = new String[]{"muzi", "ryan", "frodo", "neo"};
        friends[1] = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        friends[2] = new String[]{"a", "b", "c"};
        String[][] gifts = new String[3][];
        gifts[0] = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        gifts[1] = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        gifts[2] = new String[]{"a b", "b a", "c a", "a c", "a c ", "c a"};
        for (int i = 0; i < 3; i++) {
            int answer = solution(friends[i], gifts[i]);
            System.out.println(answer);
            System.out.println("=========");
        }
        //2
        //4
        //0
    }

    public static int solution(String[] friends, String[] gifts) {
        //두 사람이 선물을 주고받은 기록이 있다면,
        //  이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.

        //두 사람이 선물을 주고받은 기록이 하나도 없거나  or  주고받은 수가 같다면,
        //   선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
        //선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
        //   만약 두 사람의 선물 지수도 같다면
        //       다음 달에 선물을 주고받지 않습니다.

        //선물을 가장 많이 받을 친구가 받을 선물의 수를 return


        // 1. 두 사람이 선물을 주고받은 기록
        // 2. 다음 달에 받을 선물의 수
        // 3. 선물 지수

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }


        int[][] friendsTable = new int[friends.length][friends.length];
        int[] giftScore = new int[friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] giftsTemp = gifts[i].split(" ");
            String giver = giftsTemp[0];
            String receiver = giftsTemp[1];

            int giverIndex = map.get(giver);
            int receiverIndex = map.get(receiver);

            // 1. 두 사람이 선물을 주고받은 기록
            friendsTable[giverIndex][receiverIndex]++;

            // 3. 선물 지수
            giftScore[giverIndex]++;
            giftScore[receiverIndex]--;
        }

        int[] nextMonthGifts = new int[friends.length];
        for (int i = 0; i < friendsTable.length; i++) {
            for (int j = i; j < friendsTable[i].length; j++) {
                // 2. 다음 달에 받을 선물의 수

                //두 사람이 선물을 주고받은 기록이 있다면,
                //  이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                if (friendsTable[i][j] > friendsTable[j][i]) {
                    nextMonthGifts[i]++;
                } else if (friendsTable[i][j] < friendsTable[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    //두 사람이 선물을 주고받은 기록이 하나도 없거나  or  주고받은 수가 같다면,
                    //   선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGifts[j]++;
                    }

                }
            }
        }

        Arrays.sort(nextMonthGifts);

        return nextMonthGifts[nextMonthGifts.length - 1];
    }
}
