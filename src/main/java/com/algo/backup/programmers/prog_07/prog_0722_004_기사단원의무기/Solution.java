package com.algo.backup.programmers.prog_07.prog_0722_004_기사단원의무기;

//기사단원의무기
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 5;
        n[index++] = 10;
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 3;
        m[index++] = 3;
        index = 0;

        int[] l = new int[arrIndex];
        l[index++] = 2;
        l[index++] = 2;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //10
        //21
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int countToBuyWeapon = 0;
            for (int j = 1; j * j <= i; j++) {
                //약수인지 확인
                if (j * j == i) {
                    countToBuyWeapon++;
                } else if (i % j == 0) {
                    countToBuyWeapon += 2;
                }
            }

            if (countToBuyWeapon > limit) {
                countToBuyWeapon = power;
            }

            answer += countToBuyWeapon;
        }

        return answer;
    }
}
