package com.algo.programmers.prog_dfs_003_MazeDFS;

import java.util.Arrays;

//2. 미로 탐색 예제: 출구 찾기
public class Solution_260113 {

    //maze는 1이 벽, 0이 길입니다.
    //DFS로 상하좌우를 탐색하며 길을 따라가고,
    //더 이상 갈 수 없으면 되돌아와 다른 방향을 시도해요.
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1}
        };
        boolean[][] visited = new boolean[5][5];
        int[] dx = {-1, 1, 0, 0}; // 상하
        int[] dy = {0, 0, -1, 1}; // 좌우
        int[] start = {1, 1}; // 시작점 (1,1)
        int[] end = {3, 3}; // 종료지점 (1,1)
        result = Integer.MAX_VALUE;
        totalMove = 0;
        int move = 0;
        dfs(maze, dx, dy, start, end, visited, move);

        System.out.println("출발점으로 복귀! result=" + result + " / totalMove=" + totalMove);
    }
    static int totalMove;
    static int result;

    private static void dfs(int[][] maze, int[] dx, int[] dy, int[] start, int[] end, boolean[][] visited, int move) {
        System.out.println("이동: " + Arrays.toString(start) + " / totalMove=" + totalMove);

        if (result <= move) {
            System.out.println("@@@ 가지치기");
            return;
        }
        if (start[0] == end[0] && start[1] == end[1]) {
            result = Math.min(result, move);
            System.out.println("출구 도착! result=" + result + " / totalMove=" + totalMove);
            return;
        }

        visited[start[0]][start[1]] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = start[0] + dx[i];
            int nextY = start[1] + dy[i];
            if (nextX < 0 || nextX >= maze.length) continue;
            if (nextY < 0 || nextY >= maze[0].length) continue;

            if (visited[nextX][nextY]) continue;
            if (maze[nextX][nextY] != 0) continue;

            visited[nextX][nextY] = true;
            int[] next = new int[]{nextX, nextY};
            totalMove++;
            dfs(maze, dx, dy, next, end, visited, move + 1);
            visited[nextX][nextY] = false;
        }

        totalMove++;
        System.out.println("되돌아감: " + Arrays.toString(start) + " / totalMove=" + totalMove);
    }
    //이동: [1, 1] / totalMove=0
    //이동: [2, 1] / totalMove=1
    //이동: [3, 1] / totalMove=2
    //되돌아감: [3, 1] / totalMove=3
    //되돌아감: [2, 1] / totalMove=4
    //이동: [1, 2] / totalMove=5
    //이동: [1, 3] / totalMove=6
    //이동: [2, 3] / totalMove=7
    //이동: [3, 3] / totalMove=8
    //출구 도착! result=4 / totalMove=8
    //되돌아감: [2, 3] / totalMove=9
    //되돌아감: [1, 3] / totalMove=10
    //되돌아감: [1, 2] / totalMove=11
    //되돌아감: [1, 1] / totalMove=12
    //출발점으로 복귀! result=4 / totalMove=12


}
