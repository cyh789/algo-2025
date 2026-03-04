package com.algo.programmers.prog_dfs_001_DFSExample;

import java.util.ArrayList;
import java.util.List;

public class Solution_260304 {

    public static void main(String[] args) {
        int nodeCount = 8;  //노드 수
        boolean[] visited = new boolean[nodeCount];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (무방향 그래프)
        graph.get(0).addAll(List.of(1, 2));
        graph.get(1).addAll(List.of(3, 4));
        graph.get(4).addAll(List.of(5, 6));
        graph.get(2).add(7);

        // DFS 시작
        List<Integer> result = new ArrayList<>();
        int curr = 0;
        visited[curr] = true;
        result.add(curr);
        dfs(graph, visited, curr, result);
        System.out.println("DFS 탐색 결과:");
        System.out.println(result);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int curr, List<Integer> result) {
        for (int next : graph.get(curr)) {
            if (visited[next]) continue;
            visited[next] = true;
            result.add(next);
            dfs(graph, visited, next, result);
        }
    }
    //DFS 탐색 결과:
    //0 1 3 4 5 6 2 7
     
}
