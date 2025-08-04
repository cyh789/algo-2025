package com.algo.backup.programmers.prog_08.prog_0801_004_지폐_접기;

import java.util.Arrays;

//지폐 접기
public class Solution {
    public static void main(String[] args) {
//        int[] wallet = {30, 15};
//        int[] bill = {26, 17};
        //answer = 1
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        //answer = 4
        int answer = solution(wallet, bill);
        System.out.println(answer);
    }

    public static int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        int answer = 0;
        while (true) {
            Arrays.sort(bill);

            if (wallet[0] >= bill[0] && wallet[1] >= bill[1]) break;

            bill[1] /= 2;
            answer++;
        }

        return answer;
    }

}
