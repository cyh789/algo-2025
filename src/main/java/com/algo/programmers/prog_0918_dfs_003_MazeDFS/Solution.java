package com.algo.programmers.prog_0918_dfs_003_MazeDFS;

import java.util.Arrays;

//2. 미로 탐색 예제: 출구 찾기
public class Solution {

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
        int[] curr = start;
        dfs(maze, 1, 1, dx, dy, visited);
    }
    static int totalMove = 0;
    static int move = 0;

    private static void dfs(int[][] maze, int x, int y, int[] dx, int[] dy, boolean[][] visited) {
        visited[x][y] = true;
        totalMove++;
        System.out.println("이동: (" + y + ", " + x + ")");

        if (x == 3 && y == 3) {
            System.out.println("출구 도착!");
            System.out.println("totalMove=" + totalMove + " / move=" + move);

            //여기서는 필요없긴한데, 백트래킹 할 경우에는 중복 방지를 위해 필수
            visited[x][y] = false;
            totalMove--;
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= maze.length) continue;
            if (nextY < 0 || nextY >= maze[0].length) continue;

            if (visited[nextX][nextY]) continue;
            if (maze[nextX][nextY] == 1) continue;

            move++;
            dfs(maze, nextX, nextY, dx, dy, visited);
            move--;
        }

        // 백트래킹 (선택적으로 표시)
        System.out.println("되돌아감: (" + y + ", " + x + ")");
    }
    //이동: (1, 1)
    //이동: (1, 2)
    //이동: (1, 3)
    //되돌아감: (1, 3)
    //되돌아감: (1, 2)
    //이동: (2, 1)
    //이동: (3, 1)
    //이동: (3, 2)
    //이동: (3, 3)
    //출구 도착!
    //totalMove=7 / move=4
    //되돌아감: (3, 2)
    //되돌아감: (3, 1)
    //되돌아감: (2, 1)
    //되돌아감: (1, 1)

}
