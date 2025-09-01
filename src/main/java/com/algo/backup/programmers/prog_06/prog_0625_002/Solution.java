package com.algo.backup.programmers.prog_06.prog_0625_002;

import java.util.Arrays;

//[PCCE 기출문제] 9번 / 지폐 접기
public class Solution {
    public static void main(int[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        int answer = solution(wallet, bill);
        System.out.println("answer=" + answer);
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);    //[0] < [1]
        while (true) {
            Arrays.sort(bill);  //[0] < [1]
            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) {
                break;
            }
            bill[1] /= 2;
            answer ++;
        }
        return answer;
    }
}
