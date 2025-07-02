package com.algo.programmers.prog_06.prog_0630_001;

import java.util.Arrays;

//[PCCE 기출문제] 9번 / 지폐 접기
public class Solution {
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
//        int[] wallet = {50, 50};
//        int[] bill = {100, 241};
        int answer = solution(wallet, bill);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        //배열 wallet sort => [1] > [0]
        Arrays.sort(wallet);

        //while 반복문
        while (true) {
            //배열 bill sort => [1] > [0]
            Arrays.sort(bill);

            //bill[1] <= wallet[1] && bill[0] <= wallet[0] 인 경우 break
            if (bill[1] <= wallet[1] && bill[0] <= wallet[0]) {
                break;
            }

            //그 외 => bill 이 wallet보다 큰 경우 => bill[1] 을 2로 나누고 answer+1
            bill[1] /= 2;
            answer++;
        }

        return answer;
    }
}
