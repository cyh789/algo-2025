package com.algo.programmers.prog_queueNstack_006_주식가격_999999999;

import java.util.*;

@SuppressWarnings("UnusedAssignment")
public class Solution_260226_2_timeout {

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
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            map.put(i, prices[i]);
        }

        int time = 1;
        int[] result = new int[prices.length];
        boolean[] stop = new boolean[prices.length];
        while (true) {
            System.out.println("time=" + time);
            if (time >= prices.length) {
                break;
            }

            int next = prices[time];
            // 순회 중 제거할 인덱스를 따로 모아둠
            List<Integer> removeList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (time <= e.getKey()) continue;
                if (stop[e.getKey()]) continue;

                int curr = e.getValue();
                if (next < curr) {
                    System.out.println("   => @@@ curr=" + curr + " / next=" + next);
                    //하락 한 경우 stop
                    stop[e.getKey()] = true;

                    // 제거 대상 등록
                    removeList.add(e.getKey());
                }
                result[e.getKey()] += 1;
            }

            // 실제 제거 수행
            for (int idx : removeList) {
                map.remove(idx);
            }

            System.out.println("    " + Arrays.toString(result));
            System.out.println("    " + Arrays.toString(stop));

            time++;
        }

        return result;
    }
}
