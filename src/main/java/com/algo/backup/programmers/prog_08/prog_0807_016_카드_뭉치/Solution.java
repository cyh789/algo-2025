package com.algo.backup.programmers.prog_08.prog_0807_016_카드_뭉치;

import java.util.HashMap;
import java.util.Map;

//카드뭉치
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[][] n = new String[2][];
        n[index++] = new String[]{"i", "drink", "water"};
        n[index++] = new String[]{"i", "water", "drink"};
        index = 0;

        String[][] m = new String[2][];
        m[index++] = new String[]{"want", "to"};
        m[index++] = new String[]{"want", "to"};
        index = 0;

        String[][] l = new String[2][];
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"Yes"
        //"No"
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        //원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
        //한 번 사용한 카드는 다시 사용할 수 없습니다.
        //카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
        //기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

        //예를 들어
        // 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"],
        // 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때
        // ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면
        // 첫 번째 카드 뭉치에서 "i"를 사용한 후
        // 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고
        // 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다.
        //
        //문자열로 이루어진 배열 cards1, cards2
        // 와 원하는 단어 배열 goal이 매개변수로 주어질 때,
        // cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.


        //card1[]과 card2[]의 index를 따로 사용
        //확인중인 card[index]에서 없다면 => String cardFlag = "1" or "2" 를 이용해서 돌아가면서 확인
        //                             => index++

        //map card1 => String, int
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < cards1.length; i++) {
            map1.put(cards1[i], i);
        }

        //map card2
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < cards2.length; i++) {
            map2.put(cards2[i], i);
        }

        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            String selected = goal[i];
            if (map1.containsKey(selected) && map1.get(selected) == idx1) {
                idx1++;
            } else if (map2.containsKey(selected) && map2.get(selected) == idx2) {
                idx2++;
            } else {
                return "No";
            }

        }


        return "Yes";
    }
}
