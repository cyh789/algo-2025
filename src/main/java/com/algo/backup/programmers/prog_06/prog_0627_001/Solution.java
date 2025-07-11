package com.algo.backup.programmers.prog_06.prog_0627_001;

import java.util.Arrays;

//[PCCE 기출문제] 9번 / 지폐 접기
public class Solution {
    public static void main(String[] args) {
//        int[] wallet = {30, 15};
//        int[] bill = {26, 17};
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        int answer = solution(wallet, bill);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        while(true) {
            Arrays.sort(bill);
            if (bill[1] <= wallet[1] && bill[0] <= wallet[0]) break;
            bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}
