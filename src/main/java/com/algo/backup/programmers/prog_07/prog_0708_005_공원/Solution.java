package com.algo.backup.programmers.prog_07.prog_0708_005_공원;

import java.util.Arrays;

//공원
public class Solution {
    public static void main(String[] args) {
        int[] mats = {5,3,2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"A", "A", "-1", "B", "B", "B", "B", "-1"}, {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}, {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}, {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
        //answer = 3
        int answer = solution(mats, park);
        System.out.println(answer);
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if ("-1".equals(park[i][j])) {
                    answer = Math.max(chkFunc(mats, park, i, j), answer);
                }
                if (answer == mats[mats.length - 1]) {
                    return answer;
                }
            }
        }
        return answer;
    }

    private static int chkFunc(int[] mats, String[][] park, int i, int j) {
        int answer = -1;
        for (int k = mats.length-1; k >= 0; k--) {
            int mat = mats[k];
            boolean used = false;

            if (i+mat > park.length || j+mat > park[0].length) {
                continue;
            }

            for (int l = i; l < i+mat; l++) {
                if (used) {
                    break;
                }
                for (int m = j; m < j+mat; m++) {
                    if (used) {
                        break;
                    }
                    if (!"-1".equals(park[l][m])) {
                        used = true;
                    }
                }
            }

            if (!used) {
                return mat;
            }
        }

        return answer;
    }

}
