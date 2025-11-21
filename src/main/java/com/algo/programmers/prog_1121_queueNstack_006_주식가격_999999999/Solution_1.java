package com.algo.programmers.prog_1121_queueNstack_006_주식가격_999999999;

import java.util.*;

@SuppressWarnings("UnusedAssignment")
public class Solution_1 {

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
        Queue<Integer> q = new LinkedList<>();
        for (int i : prices) {
            q.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();

            int cnt = 0;
            for (int i : q) {
                cnt++;
                if (i < curr) break;
            }

            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
