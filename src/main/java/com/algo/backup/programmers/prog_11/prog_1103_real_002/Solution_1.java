package com.algo.backup.programmers.prog_11.prog_1103_real_002;

public class Solution_1 {

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
        for (int i = 0; i < msg.length; i++) {
            int total = n;
            total -= msg[i];
            for (int j = 0; j < sg.length; j++) {
                total -= sg[j];
                for (int k = 0; k < sg.length; k++) {
                    total -= sg[k];
                    for (int l = 0; l < sg.length; l++) {
                        if (total - sg[l] != 0) continue;
                        if (k == 0) {
                            if (i == 2) continue;
                        }
                        total -= sg[l];

                        //더하기
                        if (i == 0 && j + k == l) {
                            System.out.print(j + "+");
                            System.out.print(k + "=");
                            System.out.print(l);
                            System.out.println();
                            cnt++;
                        }
                        //빼기
                        if (i == 1 && j - k == l) {
                            System.out.print(j + "-");
                            System.out.print(k + "=");
                            System.out.print(l);
                            System.out.println();
                            cnt++;
                        }
                        //나누기
                        if (i == 2 && j / k == l) {
                            System.out.print(j + "/");
                            System.out.print(k + "=");
                            System.out.print(l);
                            System.out.println();
                            cnt++;
                        }
                        //곱하기
                        if (i == 3 && j * k == l) {
                            System.out.print(j + "*");
                            System.out.print(k + "=");
                            System.out.print(l);
                            System.out.println();
                            cnt++;
                        }
                        total += sg[l];
                    }
                    total += sg[k];
                }
                total += sg[j];
            }
        }

        return cnt;
    }
}
