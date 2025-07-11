package com.algo.programmers;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        //answer=["mumu", "kai", "mine", "soe", "poe"]
        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] players, String[] callings) {
        return players;
    }
}
