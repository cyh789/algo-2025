package com.algo.backup.programmers.prog_07.prog_0710_004_달리기경주;

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
        int n = players.length;

        Map<String, Integer> rankingMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rankingMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String key = callings[i];
            int ranking = rankingMap.get(key);

            String frontPlayer = players[ranking-1];
            String currentPlayer = players[ranking];

            //등수 바꾸기
            players[ranking] = frontPlayer;
            players[ranking-1] = currentPlayer;

            // 할때마다 계산해서 map을 수정
            rankingMap.replace(frontPlayer, ranking);
            rankingMap.replace(currentPlayer, ranking-1);
        }

        //해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
        //  이름이 불림 : n => n-1, n-1 => n

        //선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 => players
        //해설진이 부른 이름을 담은 문자열 배열 => callings
        return players;
    }
}
