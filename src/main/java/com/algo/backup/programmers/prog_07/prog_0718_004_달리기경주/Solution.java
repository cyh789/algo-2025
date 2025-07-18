package com.algo.backup.programmers.prog_07.prog_0718_004_달리기경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//달리기 경주
public class Solution {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = solution(players, callings);
        System.out.println(Arrays.toString(answer));
        //["mumu", "kai", "mine", "soe", "poe"]
    }

    public static String[] solution(String[] players, String[] callings) {
        //해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.

        //선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players
        //해설진이 부른 이름을 담은 문자열 배열 callings

        // 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return

        //mapping map<String name, Integer rank>  ::  String[] players
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        //for i callings.length
        //      String selectedName = callings[i]
        //      int selectedIndex = map.get(selectedName)
        //      int frontIndex = map.get(selected - 1)
        //      String frontName = players[frontIndex];
        //
        //      players[frontIndex] = selectedName;
        //      players[selectedIndex] = frontName;
        for (String selectedName : callings) {
            int selectedIndex = map.get(selectedName);
            int frontIndex = selectedIndex - 1;
            String frontName = players[frontIndex];
//            System.out.println(Arrays.toString(players));
//            System.out.println("selectedName=" + selectedName + " / frontName=" + frontName);

            players[frontIndex] = selectedName;
            players[selectedIndex] = frontName;
//            System.out.println(Arrays.toString(players));
//            System.out.println("----------");

            map.put(selectedName, frontIndex);
            map.put(frontName, selectedIndex);
        }

        return players;
    }
}
