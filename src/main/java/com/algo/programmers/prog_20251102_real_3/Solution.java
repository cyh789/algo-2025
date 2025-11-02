package com.algo.programmers.prog_20251102_real_3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{-4, 0, 2}, {-4, 0, 4}, {-4, 0, 6}, {2, 0, 8}};
        n[index++] = new int[][]{{1, 0, 2}, {-1, 0, 2}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //
    }

    public static int solution(int[][] circles) {
        //포함하려면 min, max
        //s = x축 최소, l= x축 최대
        //min.s >= max.s => cnt++
        //min.l <= max.l => cnt++

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < circles.length; i++) {
            list.add(new ArrayList<>());
        }

        int cnt = 0;
        for (int i = 0; i < circles.length - 1; i++) {
            int start = circles[i][0];
            int r = circles[i][2];

            for (int j = i + 1; j < circles.length; j++) {
                int startTemp = circles[j][0];
                int rTemp = circles[j][2];

                if (start - r >= startTemp - rTemp && start + r <= startTemp + rTemp) {
                    //System.out.println(Arrays.toString(circles[i]) + " " + Arrays.toString(circles[j]));
                    list.get(j).add(i);
                    cnt++;
                }
            }
        }

        //System.out.println(list);
        if (cnt == 0) return 1;

        int maxCnt = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean[] visited = new boolean[circles.length];
            if (visited[i]) continue;
            int diffCnt = dfs(list, visited, i);
            //System.out.println(diffCnt);
            maxCnt = Math.max(maxCnt, diffCnt);
        }

        return maxCnt == 0 ? 1 : maxCnt;
    }

    private static int dfs(List<List<Integer>> list, boolean[] visited, int idx) {
        visited[idx] = true;
        int cnt = 1;
        for (int nextIdx : list.get(idx)) {
            if (visited[nextIdx]) continue;
            cnt += dfs(list, visited, nextIdx);
        }

        return cnt;
    }
}
