package com.algo.programmers.prog_0911_graph_013_MazeDFS;

//2. 미로 탐색 예제: 출구 찾기
public class Solution {
    
    static int[][] maze = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1}
    };
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    //maze는 1이 벽, 0이 길입니다.
    //DFS로 상하좌우를 탐색하며 길을 따라가고,
    //더 이상 갈 수 없으면 되돌아와 다른 방향을 시도해요.
    public static void main(String[] args) {
        dfs(1, 1); // 시작점 (1,1)
    }

    static int count = 0;
    private static void dfs(int x, int y) {
        if (x == 3 && y == 3) {
            System.out.println("출구 도착! count=" + count);
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i <= 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (visited[nx][ny]) continue;
            if (maze[nx][ny] == 1) continue;

            count++;
            dfs(nx, ny);
            count--;
        }

    }

}
