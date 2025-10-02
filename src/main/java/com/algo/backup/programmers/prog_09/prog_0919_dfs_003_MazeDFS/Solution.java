package com.algo.backup.programmers.prog_09.prog_0919_dfs_003_MazeDFS;

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
        dfs(maze, start, end, dx, dy, visited);
        System.out.println("출발점으로 복귀! totalMove=" + totalMove);
    }
    static int totalMove = 0;
    static int move = 0;

    private static void dfs(int[][] maze, int[] curr, int[] end, int[] dx, int[] dy, boolean[][] visited) {
        totalMove++;
        visited[curr[0]][curr[1]] = true;
        System.out.println("이동: (" + curr[1] + ", " + curr[0] + ")");

        if (curr[0] == end[0] && curr[1] == end[1]) {
            totalMove--;
            visited[curr[0]][curr[1]] = false;

            System.out.println("출구 도착! totalMove=" + totalMove + " / move=" + move);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nextX = curr[0] + dx[i];
            int nextY = curr[1] + dy[i];

            if (nextX < 0 || nextX > maze.length) continue;
            if (nextY < 0 || nextY > maze[0].length) continue;

            if (visited[nextX][nextY]) continue;
            if (maze[nextX][nextY] == 1) continue;

            move++;
            dfs(maze, new int[]{nextX, nextY}, end, dx, dy, visited);
            move--;
        }

        // 백트래킹 (선택적으로 표시)
        totalMove++;
        System.out.println("되돌아감: (" + curr[1] + ", " + curr[0] + ")");
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
    //출구 도착! totalMove=8 / move=4
    //되돌아감: (3, 2)
    //되돌아감: (3, 1)
    //되돌아감: (2, 1)
    //되돌아감: (1, 1)
    //출발점으로 복귀! totalMove=12

}
