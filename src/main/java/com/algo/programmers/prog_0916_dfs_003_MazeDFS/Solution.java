package com.algo.programmers.prog_0916_dfs_003_MazeDFS;

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
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};
        dfs(maze, 1, 1, dx, dy, visited); // 시작점 (1,1)
    }

    static int totalMove = 0;
    static int move = 0;
    public static void dfs(int[][] maze, int x, int y, int[] dx, int[] dy, boolean[][] visited) {
        // 현재 위치 방문 처리
        visited[x][y] = true;
        totalMove++;
        System.out.println("이동: (" + x + ", " + y + ")");

        // 출구 조건 (예: 오른쪽 아래 모서리)
        if (x == 3 && y == 3) {
            System.out.println("출구 도착!");
            System.out.println("totalMove=" + totalMove + " / move=" + move);

            visited[x][y] = false; // 백트래킹 처리
            totalMove--;
            return;
        }

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // 범위를 벗어나거나 벽이거나 이미 방문한 경우 종료
            if (nextX < 0 || nextX >= maze.length || nextY < 0 || nextY >= maze[0].length) continue;
            if (maze[nextX][nextY] == 1 || visited[nextX][nextY]) continue;

            move++;
            dfs(maze, nextX, nextY, dx, dy, visited);
            move--;
        }

        // 백트래킹 (선택적으로 표시)
        System.out.println("되돌아감: (" + x + ", " + y + ")");
    }


}
