package com.algo.backup.programmers.prog_10.prog_1002_graph_006_전력망을_둘로_나누기;

import java.util.ArrayList;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 9;
        n[index++] = 4;
        n[index++] = 7;
        index = 0;

        int[][][] l = new int[arrIndex][][];
        l[index++] = new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}	;
        l[index++] = new int[][]{{1,2},{2,3},{3,4}}								;
        l[index++] = new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}				;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //3
        //0
        //1
    }

    //n개의 송전탑이
    // 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
    // 당신은 이 전선들 중 하나를 끊어서
    // 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
    // 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
    //
    //송전탑의 개수 n,
    // 그리고 전선 정보 wires가 매개변수로 주어집니다.
    // 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
    // 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //n은 2 이상 100 이하인 자연수입니다.
    //wires는 길이가 n-1인 정수형 2차원 배열입니다.
    //wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
    // 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
    //1 ≤ v1 < v2 ≤ n 입니다.
    //전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
    //입출력 예
    //n	    wires	                                            result
    //9	    [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
    //4	    [[1,2],[2,3],[3,4]]	                                0
    //7	    [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1

    //입출력 예 설명
    //입출력 예 #1
    //4번과 7번을 연결하는 전선을 끊으면
    // 두 전력망은 각 6개와 3개의 송전탑을 가지며,
    // 이보다 더 비슷한 개수로 전력망을 나눌 수 없습니다.
    //또 다른 방법으로는 3번과 4번을 연결하는 전선을 끊어도 최선의 정답을 도출할 수 있습니다.

    //입출력 예 #2
    //2번과 3번을 연결하는 전선을 끊으면
    // 두 전력망이 모두 2개의 송전탑을 가지게 되며, 이 방법이 최선입니다.

    //입출력 예 #3
    //3번과 7번을 연결하는 전선을 끊으면
    // 두 전력망이 각각 4개와 3개의 송전탑을 가지게 되며, 이 방법이 최선입니다.
    public static int solution(int n, int[][] wires) {
        int size = n + 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : wires) {
            Integer v1 = arr[0];
            Integer v2 = arr[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        //System.out.println(graph);

        int diffMin = Integer.MAX_VALUE;
        for (int[] arr : wires) {
            Integer v1 = arr[0];
            Integer v2 = arr[1];
            graph.get(v1).remove(v2);
            graph.get(v2).remove(v1);

            boolean[] visited = new boolean[size];
            int curr = v1;
            cntV1 = 0;
            dfs(graph, curr, visited);

            int cntV2 = n - cntV1;
            int diff = Math.abs(cntV1 - cntV2);
            diffMin = Math.min(diffMin, diff);

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return diffMin;
    }
    static int cntV1;

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] visited) {
        visited[curr] = true;
        cntV1++;

        for (int next : graph.get(curr)) {
            if (visited[next]) continue;
            dfs(graph, next,  visited);
        }
    }

}
