package com.algo.backup.programmers.prog_07.prog_0723_002_옹알이_2;

//옹알이_2
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"aya", "yee", "u", "maa"};
        n[index++] = new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        index = 0;

        for (String[] strings : n) {
            int answer = solution(strings);
            System.out.println(answer);
            System.out.println("=============");
        }
        //1
        //2
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        //같은 발음은 이어서 못함 => 사용한 발음은 체크 필요

        String[] possible = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
//            babbling[i] = babbling[i].replace("aya", "1");
//            babbling[i] = babbling[i].replace("ye", "2");
//            babbling[i] = babbling[i].replace("woo", "3");
//            babbling[i] = babbling[i].replace("ma", "4");
//
//            if (babbling[i].contains("11") || babbling[i].contains("22") || babbling[i].contains("33") || babbling[i].contains("44")) {
//                continue;
//            }
//
//            babbling[i] = babbling[i].replace("1", "");
//            babbling[i] = babbling[i].replace("2", "");
//            babbling[i] = babbling[i].replace("3", "");
//            babbling[i] = babbling[i].replace("4", "");

            babbling[i] = babbling[i].replaceAll("ayaaya|yeye|woowoo|mama","1");
            babbling[i] = babbling[i].replaceAll("aya|ye|woo|ma","");

            if (babbling[i].isEmpty()) answer++;
        }

        return answer;
    }
}
