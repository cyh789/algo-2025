package com.algo.backup.programmers.prog_06.prog_0627_002;

import java.util.Arrays;
import java.util.Collections;

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
        int answer = solution(mats, park);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] mats, String[][] park) {
        Integer[] matsTemp = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(matsTemp, Collections.reverseOrder());
        int answer = -1;
        int h = park.length;
        int w = park[0].length;
        for (int i= 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i][j].equals("-1")) {
                    answer = Math.max(answer, chkFunc(matsTemp, i, j, park, w, h));
                    if (answer == matsTemp[0]) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    private static int chkFunc(Integer[] matsTemp, int i, int j, String[][] park, int w, int h) {
        for (int mat : matsTemp) {
            int matH = i + mat;
            int matW = j + mat;
            if (matH > h || matW > w) {
                continue;
            }
            boolean flag = true;
            for (int m = i; m < matH; m++) {
                for (int n = j; n < matW; n++) {
                    if (!park[m][n].equals("-1")) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                return mat;
            }
        }

        return -1;
    }
}
