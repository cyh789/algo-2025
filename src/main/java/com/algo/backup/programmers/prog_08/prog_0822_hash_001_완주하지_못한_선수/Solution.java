package com.algo.backup.programmers.prog_08.prog_0822_hash_001_완주하지_못한_선수;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"leo", "kiki", "eden"};
        n[index++] = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        n[index++] = new String[]{"mislav", "stanko", "mislav", "ana"};
        index = 0;

        String[][] m = new String[arrIndex][];
        m[index++] = new String[]{"eden", "kiki"}                         ;
        m[index++] = new String[]{"josipa", "filipa", "marina", "nikola"} ;
        m[index++] = new String[]{"stanko", "ana", "mislav"}	          ;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"leo"
        //"vinko"
        //"mislav"
    }

    //수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    //
    //마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
    // 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    // 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    //completion의 길이는 participant의 길이보다 1 작습니다.
    //참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    //참가자 중에는 동명이인이 있을 수 있습니다.
    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[i];
    }
}
