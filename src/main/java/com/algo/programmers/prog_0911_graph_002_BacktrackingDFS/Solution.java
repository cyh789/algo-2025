package com.algo.programmers.prog_0911_graph_002_BacktrackingDFS;

import java.util.Arrays;

//1. 백트래킹 문제 예제: N개의 숫자 중 M개를 고르기
public class Solution {

    static int N = 4; // 1~N까지 숫자
    static int M = 3; // M개 선택
    static boolean[] visited = new boolean[N + 1];
    static int[] result = new int[M];

    //dfs(depth)는 현재 선택한 숫자의 개수를 의미해요.
    //visited[i]를 통해 중복 없이 숫자를 선택하고,
    //dfs(depth + 1)로 깊이 있게 탐색하다가,
    //조건을 만족하면 출력하고 되돌아와 다른 경우를 탐색합니다.
    public static void main(String[] args) {
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}
