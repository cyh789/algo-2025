package com.algo.programmers.prog_0916_dfs_002_BacktrackingDFS;

import java.util.Arrays;

//1. 백트래킹 문제 예제: N개의 숫자 중 M개를 고르기
public class Solution {

    //dfs(depth)는 현재 선택한 숫자의 개수를 의미해요.
    //visited[i]를 통해 중복 없이 숫자를 선택하고,
    //dfs(depth + 1)로 깊이 있게 탐색하다가,
    //조건을 만족하면 출력하고 되돌아와 다른 경우를 탐색합니다.
    public static void main(String[] args) {
        int N = 4; // 1~N까지 숫자
        int M = 3; // M개 선택
        int[] result = new int[M];
        boolean[] visited = new boolean[N + 1];
        int depth = 0;
        dfs(N, M, depth, result, visited);
    }

    private static void dfs(int n, int m, int depth, int[] result, boolean[] visited) {
        if (depth == m) {
            System.out.println(Arrays.toString(result));
            return;
        }

        //visited[depth] = true;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[depth] = i;
            dfs(n, m, depth + 1, result, visited);
            visited[i] = false;
        }
    }


}
