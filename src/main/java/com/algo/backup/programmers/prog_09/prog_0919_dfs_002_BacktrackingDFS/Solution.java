package com.algo.backup.programmers.prog_09.prog_0919_dfs_002_BacktrackingDFS;

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
        dfs(N, M, result, depth, visited);
    }

    private static void dfs(int N, int M, int[] result, int depth, boolean[] visited) {
        if (depth == M) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            result[depth] = i;
            dfs(N, M, result, depth + 1, visited);
            visited[i] = false;
        }
    }
    //[1, 2, 3]
    //[1, 2, 4]
    //[1, 3, 2]
    //[1, 3, 4]
    //[1, 4, 2]
    //[1, 4, 3]
    //[2, 1, 3]
    //[2, 1, 4]
    //[2, 3, 1]
    //[2, 3, 4]
    //[2, 4, 1]
    //[2, 4, 3]
    //[3, 1, 2]
    //[3, 1, 4]
    //[3, 2, 1]
    //[3, 2, 4]
    //[3, 4, 1]
    //[3, 4, 2]
    //[4, 1, 2]
    //[4, 1, 3]
    //[4, 2, 1]
    //[4, 2, 3]
    //[4, 3, 1]
    //[4, 3, 2]
}
