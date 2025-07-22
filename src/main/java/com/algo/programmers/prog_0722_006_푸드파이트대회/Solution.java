package com.algo.programmers.prog_0722_006_푸드파이트대회;

//카드뭉치
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1, 3, 4, 6};
        n[index++] = new int[]{1, 7, 1, 2};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"1223330333221"
        //"111303111"
    }

    public static String solution(int[] food) {

        StringBuilder front = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int foodCount = food[i] / 2;
            for (int j = 0; j < foodCount; j++) {
                front.append(i);
            }
        }

        String answer = front + "0";
        //reverse() 는 따로 분리
        answer += front.reverse().toString();

        return answer;
    }
}
