package com.algo.programmers.prog_20251102_real_2;

import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> sMap = new HashMap<>();
        int[] sg = new int[]{6, 2, 5, 5, 4, 5, 6, 4, 7, 6};
        for (int i = 0; i < 10; i++) {
            sMap.put(i, sg[i]);
        }

        Map<Integer, Integer> mMap = new HashMap<>();
        int[] msg = new int[]{2, 1, 1, 2};
        for (int i = 0; i < 4; i++) {
            //0 덧셈 1 뺄셈 2 나눗셈 3 곱셈
            mMap.put(i, msg[i]);
        }

        //System.out.println("0 덧셈 1 뺄셈 2 나눗셈 3 곱셈");
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int total = n;
            total -= mMap.get(i);

            for (int j = 0; j < 10; j++) {
                total -= sMap.get(j);

                for (int k = 0; k < 10; k++) {
                    total -= sMap.get(k);

                    for (int l = 0; l < 10; l++) {
                        if (total - sMap.get(l) != 0) continue;
                        if (k == 0) {
                            if (l != 0 && l != j) continue;
                            if (i == 2) continue;
                        }
                        total -= sMap.get(l);

                        if (i == 0 && j + k == l) cnt++;
                        if (i == 1 && j - k == l) cnt++;
                        if (k == 0 && i == 3) cnt++;
                        else {
                            if (i == 2 && j / k == l) cnt++;
                            if (i == 3 && j * k == l) cnt++;
                        }
                        total += sMap.get(l);
                    }
                    total += sMap.get(k);
                }
                total += sMap.get(j);
            }
        }

        return cnt;
    }
}
