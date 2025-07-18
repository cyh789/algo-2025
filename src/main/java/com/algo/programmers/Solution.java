package com.algo.programmers;

//덧칠하기
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        int[] n = new int[3];
        n[index++] = 8;
        n[index++] = 5;
        n[index++] = 4;
        index = 0;
        int[] m = new int[3];
        m[index++] = 4;
        m[index++] = 4;
        m[index++] = 1;
        index = 0;
        int[][] section = new int[3][];
        section[index++] = new int[]{2, 3, 6}   ;
        section[index++] = new int[]{1, 3}      ;
        section[index++] = new int[]{1, 2, 3, 4};
        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], section[i]);
            System.out.println(answer);
            System.out.println("==========");
        }
        //{0, 1, 3, 4}
        //{1, 3, 5, 8}
        //{0, 0, 7, 9}
        //{1, 0, 2, 1}
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        return answer;
    }
}
