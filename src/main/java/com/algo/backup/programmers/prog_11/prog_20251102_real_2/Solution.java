package com.algo.backup.programmers.prog_11.prog_20251102_real_2;

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
        for (int m = 0; m < 4; m++) {
            int total = n;
            total -= mMap.get(m);

            for (int i1 = 0; i1 < 10; i1++) {
                total -= sMap.get(i1);

                for (int i2 = 0; i2 < 10; i2++) {
                    total -= sMap.get(i2);

                    for (int i3 = 0; i3 < 10; i3++) {
                        if (total - sMap.get(i3) != 0) continue;
                        if (i2 == 0) {
                            if (i3 != 0 && i3 != i1) continue;
                            if (m == 2) continue;
                        }
                        total -= sMap.get(i3);

                        if (m == 0 && i1 + i2 == i3) cnt++;
                        if (m == 1 && i1 - i2 == i3) cnt++;
                        if (i2 == 0 && m == 3) cnt++;
                        else {
                            if (m == 2 && i1 / i2 == i3) cnt++;
                            if (m == 3 && i1 * i2 == i3) cnt++;
                        }
                        total += sMap.get(i3);
                    }
                    total += sMap.get(i2);
                }
                total += sMap.get(i1);
            }
        }

        return cnt;
    }
}
