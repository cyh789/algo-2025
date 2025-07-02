package com.algo.programmers.prog_0702_002;

import java.util.Arrays;

//[PCCE 기출문제] 10번 / 공원
public class Solution {
    public static void main(String[] args) {
        int[] mats = {5,3,2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}
                        , {"A", "A", "-1", "B", "B", "B", "B", "-1"}
                        , {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}
                        , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        //answer=3
        int answer = solution(mats, park);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        int parkW = park[0].length;
        int parkH = park.length;
        for (int i = 0; i < parkH; i++) {
            for (int j = 0; j < parkW; j++) {
                if ("-1".equals(park[i][j])) {
                    answer = Math.max(answer, chkFunc(i, j, mats, park, parkW, parkH));
                    if (answer == mats[mats.length-1]) return answer;
                }
            }
        }
        return answer;
    }

    private static int chkFunc(int i, int j, int[] mats, String[][] park, int parkW, int parkH) {
        int answer = -1;
        Arrays.sort(mats);
        for (int k = mats.length-1; k >= 0; k--) {
            int mat = mats[k];
            if (mat+i > parkH || mat+j > parkW) continue;
            boolean flag = true;
            for (int m = i; m < i+mat; m++) {
                for (int n = j; n < j+mat; n++) {
                    if (!"-1".equals(park[m][n])) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) return mat;
        }
        return answer;
    }


}
