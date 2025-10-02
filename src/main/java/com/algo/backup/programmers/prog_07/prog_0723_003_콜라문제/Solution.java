package com.algo.backup.programmers.prog_07.prog_0723_003_콜라문제;

//콜라문제
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 2;
        n[index++] = 3;
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 1;
        m[index++] = 1;
        index = 0;

        int[] l = new int[arrIndex];
        l[index++] = 20;
        l[index++] = 20;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //19
        //9
    }

    public static int solution(int a, int b, int n) {
        int count = 0;
        int currentEmptyCoke = n;
        while (currentEmptyCoke >= a) {
            int fullCoke = currentEmptyCoke / a * b;
            int emptyCoke = currentEmptyCoke % a;
            count += fullCoke;
            currentEmptyCoke = fullCoke + emptyCoke;
        }

        return count;
    }
}
