package com.algo.backup.programmers.prog_12.prog_1219_dfs_003_MazeDFS;

//2. 미로 탐색 예제: 출구 찾기
public class Solution_1_dfs {

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
        int[] curr = {1, 1}; // 시작점 (1,1)
        int[] end = {3, 3}; // 종료지점 (1,1)
        result = Integer.MAX_VALUE;
        move = 0;
        dfs(maze, visited, dx, dy, curr, end);
        System.out.println("출발점으로 복귀! result=" + result + " / totalMove=" + totalMove);
    }

    private static void dfs(int[][] maze, boolean[][] visited, int[] dx, int[] dy, int[] curr, int[] end) {
        System.out.println("이동: (" + curr[1] + ", " + curr[0] + ")" + " / totalMove=" + totalMove);

        if (curr[0] == end[0] && curr[1] == end[1]) {
            result = Math.min(result, move);
            System.out.println("출구 도착! result=" + result + " / totalMove=" + totalMove);
            return;
        }

        visited[curr[0]][curr[1]] = true;
        for (int i = 0; i < dx.length; i++) {
            int x = curr[0] + dx[i];
            int y = curr[1] + dy[i];

            if (x < 0 || x > maze.length) continue;
            if (y < 0 || y > maze[0].length) continue;

            if (visited[x][y]) continue;
            if (maze[x][y] == 1) continue;

            visited[curr[0]][curr[1]] = true;
            move++;
            totalMove++;
            dfs(maze, visited, dx, dy, new int[]{x, y}, end);
            move--;
            visited[curr[0]][curr[1]] = false;

            //if (result != Integer.MAX_VALUE) return;
        }

        totalMove++;
        System.out.println("되돌아감: (" + curr[1] + ", " + curr[0] + ")" + " / totalMove=" + totalMove);

    }
    static int totalMove;
    static int result;
    static int move;
    //이동: (1, 1)
    //이동: (1, 2)
    //이동: (1, 3)
    //되돌아감: (1, 3)
    //되돌아감: (1, 2)
    //이동: (2, 1)
    //이동: (3, 1)
    //이동: (3, 2)
    //이동: (3, 3)
    //출구 도착! result=8 / move=4
    //되돌아감: (3, 2)
    //되돌아감: (3, 1)
    //되돌아감: (2, 1)
    //되돌아감: (1, 1)
    //출발점으로 복귀! result=12

}
