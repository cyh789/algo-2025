package com.algo.backup.programmers.prog_11.prog_1110_real_003;

import java.util.ArrayList;

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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < circles.length; i++) {
            result.add(new ArrayList<>());
        }

        int cnt = 0;
        for (int i = 0; i < circles.length - 1; i++) {
            int start = circles[i][0];
            int r = circles[i][2];
            for (int j = i + 1; j < circles.length; j++) {
                int startTemp = circles[j][0];
                int rTemp = circles[j][2];
                if (start - r >= startTemp - rTemp && start + r <= startTemp + rTemp) {
                    result.get(j).add(i);
                    cnt++;
                }
            }
        }

        System.out.println(result);
        if (cnt == 0) return 1;

        int maxCnt = 0;
        for (int i = 0; i < circles.length; i++) {
            boolean[] visited = new boolean[circles.length];
            int diff = bfs(visited, result, i);
            System.out.print(diff + " ");
            maxCnt = Math.max(maxCnt, diff);
        }
        System.out.println("-----");

        return maxCnt == 0 ? 1 : maxCnt;
    }

    private static int bfs(boolean[] visited, ArrayList<ArrayList<Integer>> result, int idx) {
        visited[idx] = true;
        int cnt = 1;
        for (int i = 0; i < result.get(idx).size(); i++) {
            int nextIdx = result.get(idx).get(i);
            if (visited[i]) continue;
            cnt += bfs(visited, result, nextIdx);
        }

        return cnt;
    }
}
