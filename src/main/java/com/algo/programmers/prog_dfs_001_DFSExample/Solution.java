package com.algo.programmers.prog_dfs_001_DFSExample;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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
        System.out.println("DFS 탐색 결과:");
    }
    //DFS 탐색 결과:
    //0 1 3 4 5 6 2 7
     
}
