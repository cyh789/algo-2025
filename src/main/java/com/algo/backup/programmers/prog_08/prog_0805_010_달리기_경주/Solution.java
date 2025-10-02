package com.algo.backup.programmers.prog_08.prog_0805_010_달리기_경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//달리기 경주
public class Solution {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        //answer=["mumu", "kai", "mine", "soe", "poe"]
        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] players, String[] callings) {
        //해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
        //선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players
        //해설진이 부른 이름을 담은 문자열 배열 callings
        //경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String backPlayer : callings) {
            int backIndex = map.get(backPlayer);
            int frontIndex = backIndex - 1;
            String frontPlayer = players[frontIndex];

            players[backIndex] = frontPlayer;
            players[frontIndex] = backPlayer;
            map.put(backPlayer, frontIndex);
            map.put(frontPlayer, backIndex);

            System.out.println(Arrays.toString(players));
        }

        //경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
        return players;
    }
}
