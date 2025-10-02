package com.algo.backup.programmers.prog_08.prog_0829_queueNstack_006_주식가격_999999999;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1, 2, 3, 2, 3};
        index = 0;

        for (int[] ints : n) {
            int[] answer = solution(ints);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //4, 3, 1, 1, 0
    }

    //초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
    // 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
    //
    //제한사항
    //prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
    //prices의 길이는 2 이상 100,000 이하입니다.
    //입출력 예

    //prices	        return
    //[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
    //입출력 예 설명
    //1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
    //2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
    //3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
    //4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
    //5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
    public static int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();  //int price
        for (int price : prices) {
            queue.offer(price);
        }

        int[] answer = new int[prices.length];  //0을 넣고 시작
        int idx = 0;
        while (!queue.isEmpty()) {
            int prev = queue.poll();

            //자기 자신은 계산하면 안됨
            int start = prices.length - queue.size();
            for (int j = start; j < prices.length; j++) {
                int curr = prices[j];
                answer[idx]++;

                //break 안하면 시간부족함
                // => 가격이 하락하지 안음 사용불가
                // => if (prev <= curr) 사용불가
                //가격이 하락함
                if (prev > curr) break;
            }

            idx++;
        }

        return answer;
    }
}
