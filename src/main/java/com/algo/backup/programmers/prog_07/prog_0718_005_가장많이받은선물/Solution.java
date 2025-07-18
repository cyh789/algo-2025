package com.algo.backup.programmers.prog_07.prog_0718_005_가장많이받은선물;

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

        //mapping index to friends :: for i friends  =>  map(friends[i])
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        Map<Integer, String> mapTemp = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            mapTemp.put(i, friends[i]);
        }

        //int[friendsH][friendsH] giftsTable
        //int[friendsH] giftScore
        //for i gifts  =>  split :: giver = giftsTemp[0], receiver = giftsTemp[1]
        //   mapping get index ::  giverIndex, receiverIndex
        //   giftsTable[giverIndex][receiverIndex]++
        //   giftScore[giverIndex]++;
        //   giftScore[giverIndex]--;
        int friendsH = friends.length;;
        int[] giftScore = new int[friendsH];
        int[][] giftsTable = new int[friendsH][friendsH];
        for (int i = 0; i < gifts.length; i++) {
            String[] giftsTemp = gifts[i].split(" ");
            String giver = giftsTemp[0];
            String receiver = giftsTemp[1];
            int giverIndex = map.get(giver);
            int receiverIndex = map.get(receiver);
            giftsTable[giverIndex][receiverIndex]++;
            giftScore[giverIndex]++;
            giftScore[receiverIndex]--;
        }

        for (int i = 0; i < giftsTable.length; i++) {
            System.out.println(Arrays.toString(giftsTable[i]));
        }

        //int[friendsH] nextMonthGifts
        //for i giftsTableH  =>  for j giftsTableW  =>  if giftsTable[i][j] > giftsTable[j][i]  =>  nextMonthGifts[i]++;
        //        else if giftsTable[i][j] < giftsTable[j][i]  =>  nextMonthGifts[j]++;
        //        else
        int[] nextMonthGifts = new int[friendsH];
        int giftsTableH = giftsTable.length;
        for (int i = 0; i < giftsTableH; i++) {
            int figtTableW = giftsTable[i].length;

            //★시작값이 i가 아니면 값이 x2 연산됨
            for (int j = i; j < figtTableW; j++) {
                //두 사람이 선물을 주고받은 기록이 있다면,
                //  이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                if (giftsTable[i][j] > giftsTable[j][i]) {
                    nextMonthGifts[i]++;
                    System.out.println("giftsTable[i][j]=" + mapTemp.get(i) + " > giftsTable[j][i]=" + mapTemp.get(j));
                } else if (giftsTable[i][j] < giftsTable[j][i]) {
                    nextMonthGifts[j]++;
                    System.out.println("giftsTable[i][j]=" + mapTemp.get(i) + " < giftsTable[j][i]=" + mapTemp.get(j));
                } else {
                    //두 사람이 선물을 주고받은 기록이 하나도 없거나  or  주고받은 수가 같다면,
                    //   선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    //선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
                    //   만약 두 사람의 선물 지수도 같다면
                    //       다음 달에 선물을 주고받지 않습니다.
                    if (giftScore[i] > giftScore[j]) {
                        System.out.println("giftScore[i]=" + mapTemp.get(i) + " > giftScore[j]=" + mapTemp.get(j));
                        nextMonthGifts[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        System.out.println("giftScore[i]=" + mapTemp.get(i) + " < giftScore[j]=" + mapTemp.get(j));
                        nextMonthGifts[j]++;
                    }
                }

            }
        }

        //선물을 가장 많이 받을 친구가 받을 선물의 수를 return
        Arrays.sort(nextMonthGifts);
        System.out.println("--------");
        System.out.println(Arrays.toString(nextMonthGifts));
        System.out.println("--------");

        return nextMonthGifts[nextMonthGifts.length - 1];
    }
}
