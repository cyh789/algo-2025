package com.algo.backup.programmers.prog_11.prog_20251103_real_3;

import java.util.ArrayList;

public class Solution_2 {

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
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < circles.length; i++) {
            list.add(new ArrayList<>());
        }

        int cnt = 0;
        for (int i = 0; i < circles.length; i++) {
            int start = circles[i][0];
            int r = circles[i][2];
            for (int j = i + 1; j < circles.length - 1; j++) {
                int startTemp = circles[j][0];
                int rTemp = circles[j][2];
                if (start - r >= startTemp - rTemp && start + r <= startTemp + rTemp) {
                    list.get(j).add(i);
                    cnt++;
                }
            }
        }

        System.out.println(list);
        if (cnt == 0) return 1;

        int maxCnt = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean[] visited = new boolean[circles.length];
            int diff = dfs(visited, list, i);
            maxCnt = Math.max(maxCnt, diff);
        }

        return maxCnt == 0 ? 1 : maxCnt;
    }

    private static int dfs(boolean[] visited, ArrayList<ArrayList<Integer>> list, int i) {
        visited[i] = true;
        int cnt = 1;
        for (int nextIdx : list.get(i)) {
            if (visited[nextIdx]) continue;
            cnt += dfs(visited, list, nextIdx);
        }
        return cnt;
    }


}
