package com.algo.programmers.prog_0702_001;

import java.util.Arrays;

//[PCCE 기출문제] 9번 / 지폐 접기
public class Solution {
    public static void main(String[] args) {
        int[] wallet = {30, 15};
        int[] bill = {26, 17};
        //answer=1
//        int[] wallet = {50, 50};
//        int[] bill = {100, 241};
        //answer=4
        int answer = solution(wallet, bill);
        System.out.println("answer=" + answer);


    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        //wallet sort => [1] > [0]
        Arrays.sort(wallet);
        //while (true)
        while (true) {
            //  bill sort => [1] > [0]
            Arrays.sort(bill);
            //  if bill[1] <= wallet[1] && bill[0] <= wallet[0] => break;
            if (bill[1] <= wallet[1] && bill[0] <= wallet[0]) break;
            //  bill[1] /= 2
            bill[1] /= 2;
            //  answer++
            answer++;
        }
        return answer;
    }
}
