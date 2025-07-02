package com.algo.programmers.prog_06.prog_0625_001;

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
        int answer = solution(mats, park);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                if (park[i][j].equals("-1")){
                    answer = Math.max(answer, checkMatLength(i, j, mats, park));

                    if (answer == mats[mats.length-1]) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    private static int checkMatLength(int i, int j, int[] mats, String[][] park) {
        int matLength = -1;
        int m = park[i].length; //공원의 행 크기
        int n = park.length;    //공원의 열 크기

        // 가장 큰 매트 크기부터 작은 매트 크기까지 순차적으로 검사
        for (int d = mats.length -1; d >= 0; d--) {
            int mat = mats[d];
            // 매트가 공원 범위를 벗어나면 검사하지 않는다
            if (j + mat > m || i + mat > n) {
                continue;
            }
            boolean flag = true;    // 매트를 놓을 수 있는지 여부를 저장할 플래그
            for (int k = i; k < i+mat; k++) {
                for (int l = j; l < j+mat; l++) {
                    if (!park[k][l].equals("-1")) {
                        flag = false;
                        break;
                    }
                }
            }

            // 매트를 놓을 수 있는 경우, 해당 매트의 크기를 저장하고 종료
            if (flag) {
                matLength = mat;
                break;
            }
        }
        return matLength;
    }
}
