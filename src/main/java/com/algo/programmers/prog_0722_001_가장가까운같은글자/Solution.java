package com.algo.programmers.prog_0722_001_가장가까운같은글자;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//카드뭉치
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[] n = new String[2];
        n[index++] = "banana";
        n[index++] = "foobar";

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //-1, -1, -1, 2, 2, 2
        //-1, -1, 1, -1, -1, -1
    }

    public static int[] solution(String s) {

        //Map<String, Integer> map
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        char[] c = s.toCharArray();
        for (int j = 0; j < c.length; j++) {
            String selected = String.valueOf(c[j]);

            if (map.containsKey(selected)) {
                int value = j - map.get(selected);
                map.put(selected, Math.max(value, j));
                answer[j] = value;
            } else {
                map.put(selected, j);
                answer[j] = -1;
            }
        }

        return answer;
    }

}
