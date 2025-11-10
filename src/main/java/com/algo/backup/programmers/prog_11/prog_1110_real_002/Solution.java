package com.algo.backup.programmers.prog_11.prog_1110_real_002;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 21;
        n[index++] = 0;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //
    }

    public static int solution(int n) {
        int[] sg = new int[]{6, 2, 5, 5, 4, 5, 6, 4, 7, 6};
        //더하기, 빼기, 나누기, 곱하기
        int[] msg = new int[]{2, 1, 1, 2};

        int cnt = 0;
        for (int m1 = 0; m1 < msg.length; m1++) {
            int total = n;
            total -= msg[m1];
            for (int s1 = 0; s1 < sg.length; s1++) {
                total -= sg[s1];
                for (int s2 = 0; s2 < sg.length; s2++) {
                    total -= sg[s2];
                    for (int s3 = 0; s3 < sg.length; s3++) {
                        if (total - sg[s3] != 0) continue;
                        //나누기
                        if (m1 == 2) {
                            if (s2 == 0) continue;
                        }

                        total -= sg[s3];

                        //더하기
                        if (m1 == 0 && s1 + s2 == s3) {
                            cnt++;
                        }
                        //빼기
                        if (m1 == 1 && s1 - s2 == s3) {
                            cnt++;
                        }
                        //나누기
                        if (m1 == 2 && s1 / s2 == s3) {
                            cnt++;
                        }
                        //곱하기
                        if (m1 == 3 && s1 * s2 == s3) {
                            cnt++;
                        }

                        total += sg[s3];
                    }
                    total += sg[s2];
                }
                total += sg[s1];
            }
        }

        return cnt;
    }
}
