package com.algo.programmers.prog_0911_graph_011_DFSExample;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        int nodeCount = 5;  //노드 수
        boolean[] visited = new boolean[nodeCount];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (무방향 그래프)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);

        // DFS 시작
        System.out.println("DFS 탐색 결과:");
        int depth = 0;
        dfs(graph, depth, visited);
    }
    //DFS 탐색 결과:
    //0 1 3 4 2

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int depth, boolean[] visited) {
        if (depth > graph.size()) return;

        visited[depth] = true;
        System.out.print(depth + " ");

        ArrayList<Integer> node = graph.get(depth);

        for (int curr : node) {
            if (visited[curr]) continue;
            dfs(graph, curr, visited);
        }
    }
}
