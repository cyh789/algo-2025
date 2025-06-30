package com.algo.programmers.prog_0630_002;

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
        //아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.
        int answer = -1;

        //1<= mat <= 10
        //1<= park <= 50

        //park의 행을 구한다 => park[0].length => for문에 사용
        int parkW = park[0].length;
        //park의 열을 구한다 => park.length => for문에 사용
        int parkH = park.length;

        //열
        for (int i = 0; i < parkH; i++) {
            //행
            for (int j = 0; j < parkW; j++) {
                //park의 현재 위치가 "-1"인지 확인한다 => if park[i][j].equals("-1")
                //"-1"이라면 돗자리를 깔 수 있는지 확인하는 chkFunc 실행
                if (park[i][j].equals("-1")) {
                    //mat 크기는 항상 더 큰 값을 유지
                    answer = Math.max(answer, chkFunc(i, j, mats, park, parkW, parkH));
                }
            }
        }

        return answer;
    }

    private static int chkFunc(int i, int j, int[] mats, String[][] park, int parkW, int parkH) {
        //아무런 돗자리도 깔 수 없는 경우 -1을 return합니다.
        int answer = -1;

        //chkFunc:: mats를 sort 해준다.
        Arrays.sort(mats);
        //mats의 for문은 뒤에서부터 꺼내서 확인한다.
        //  뒤에서부터 꺼내서 확인 => 큰 수부터 확인이니까,
        //                        돗자리를 깔 수 있는것이 확인되면, 즉시 return mat 가능
        for (int k = mats.length -1; k >= 0; k--) {
            int mat = mats[k];
            //mat를 이용해서 park의 행과 열에서 가능한지 확인
            //  돗자리를 깔 수 있는지 확인하는 flag 선언 => boolean flag = true;
            boolean flag = true;

            //현재위치+돗자리의 길이 > 공원의 행/열인 경우 => 즉시 다음 mat 검사 => continue
            //i와 j는 배열의 index이므로 => 0부터 시작이라서 => 실제 계산할때 if문에서 -1씩 해줘야함
            //  j+mat = parkW 인거  (정상) => j에 0을 mat에 5를 parkW에 5를 대입해보면 됨
            //  j+mat > parkW 면 비정상
            if (j+mat > parkW || i+mat > parkH) {
                continue;
            }

            //  park의 열 + mat => for m=i; m<i+mat -1; m++
            for (int m = i; m < i+mat; m++) {
                //  park의 행 + mat => for n=j; n<j+mat -1; n++
                for (int n = j; n < j+mat; n++) {
                    //  park의 현재 위치가 "-1인지 확인한다 => !park[m][n].equals("-1")
                    if (!park[m][n].equals("-1")) {
                        //  "-1"이 아니라면 돗자리를 깔 수 없다 => boolean flag = false로 변경. break로 for문도 중지.
                        flag = false;
                        break;
                    }
                }
                //  park의 행에서도 flag 확인해서 break 여부 가능.
                if (!flag) break;
            }
            //  다음 mat를 진행하기 전, flag를 체크해서 true 라면 돗자리를 깔 수 있음 => return mat
            if (flag) return mat;
        }

        return answer;
    }
}
