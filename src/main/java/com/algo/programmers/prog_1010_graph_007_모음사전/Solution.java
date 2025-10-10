package com.algo.programmers.prog_1010_graph_007_모음사전;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 4;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = "AAAAE";
        n[index++] = "AAAE";
        n[index++] = "I";
        n[index++] = "EIO";
        index = 0;

        for (String s : n) {
            int answer = solution(s);
            System.out.println(answer);
            System.out.println("=============");
        }
        //6
        //10
        //1563
        //1189
    }

    //사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는,
    // 길이 5 이하의 모든 단어가 수록되어 있습니다.
    // 사전에서 첫 번째 단어는 "A"이고,
    // 그다음은 "AA"이며,
    // 마지막 단어는 "UUUUU"입니다.
    //
    //단어 하나 word가 매개변수로 주어질 때,
    // 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //word의 길이는 1 이상 5 이하입니다.
    //word는 알파벳 대문자 "A", "E", "I", "O", "U"로만 이루어져 있습니다.

    //입출력 예
    //word	    result
    //"AAAAE"	6
    //"AAAE"	10
    //"I"	    1563
    //"EIO"	    1189

    //입출력 예 #1
    //사전에서 첫 번째 단어는 "A"이고,
    // 그다음은 "AA", "AAA", "AAAA", "AAAAA", "AAAAE", ... 와 같습니다.
    // "AAAAE"는 사전에서 6번째 단어입니다.
    //
    //입출력 예 #2
    //"AAAE"는 "A", "AA", "AAA", "AAAA", "AAAAA", "AAAAE", "AAAAI", "AAAAO", "AAAAU"의 다음인 10번째 단어입니다.
    //
    //입출력 예 #3
    //"I"는 1563번째 단어입니다.
    //
    //입출력 예 #4
    //"EIO"는 1189번째 단어입니다.
    public static int solution(String word) {
        String[] conditions = {"A", "E", "I", "O", "U"};
        List<String> result = new ArrayList<>();
        String curr = "";
        cnt = 0;
        answer = 0;
        dfs(conditions, word, curr, result);
        //System.out.println(result.toString());

        return answer;
    }
    static int cnt;
    static int answer;

    private static void dfs(String[] conditions, String word, String curr, List<String> result) {
        if (curr.equals(word)) {
            answer = cnt;
            return;
        }

        if (curr.length() >= 5) return;

        for (int i = 0; i < conditions.length; i++) {
            String next = curr + conditions[i];
            cnt++;
            result.add(next);
            dfs(conditions, word, next, result);

            if (answer > 0) return;
        }
    }

}