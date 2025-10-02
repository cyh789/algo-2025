package com.algo.backup.programmers.prog_08.prog_0811_hash_001_완주하지_못한_선수;

import java.util.Arrays;

@SuppressWarnings("UnusedAssignment")
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

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }

        return participant[participant.length - 1];
    }
}
