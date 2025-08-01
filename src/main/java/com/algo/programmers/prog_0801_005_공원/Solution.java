package com.algo.programmers.prog_0801_005_공원;

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

        int parkH = park.length;
        int parkW = park[0].length;
        for (int n = 0; n < parkH; n++) {
            for (int m = 0; m < parkW; m++) {
                if ("-1".equals(park[n][m])) {

                    for (int i = mats.length - 1; i >= 0; i--) {
                        boolean used = false;
                        int selected = mats[i];

                        if (n + selected > parkH || m + selected > parkW) continue;

                        for (int n2 = n; n2 < n + selected; n2++) {
                            if (used) break;
                            for (int m2 = m; m2 < m + selected; m2++) {
                                if (!"-1".equals(park[n2][m2])) {
                                    used = true;
                                    break;
                                }
                            }
                        }

                        if (!used) answer = Math.max(answer, selected);
                    }
                }

                if (answer == mats[mats.length - 1]) return answer;
            }
        }

        return answer;
    }


}
