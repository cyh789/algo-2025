package com.algo.programmers.prog_0808_019_크기가_작은_부분_문자열;

import java.util.ArrayList;
import java.util.List;

//크기가작은부분문자열
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = "3141592";
        n[index++] = "500220839878";
        n[index++] = "10203";
        index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "271";
        m[index++] = "7";
        m[index++] = "15";

        for (int i = 0; i < arrIndex; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //8
        //3
    }
    public static int solution(String t, String p) {
        //숫자로 이루어진 문자열 t와 p가 주어질 때,
        // t에서 p와 길이가 같은 부분문자열 중에서,
        // 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
        //
        //예를 들어, t="3141592"이고 p="271" 인 경우,
        // t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다.
        // 이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.

        int count = 0;
        int startIdx = 0;
        int endIdx = startIdx + p.length();
        while (true) {
            long selected = Long.parseLong(t.substring(startIdx, endIdx));
            //System.out.println("startIdx=" + startIdx + " / endIdx=" + endIdx + " / selected=" + selected);
            if (Long.parseLong(p) >= selected) count++;

            if (endIdx + 1 > t.length()) {
                break;
            }

            startIdx += 1;
            endIdx = startIdx + p.length();

            //System.out.println("startIdx=" + startIdx + " / endIdx=" + endIdx);
        }



        return count;
    }
}
