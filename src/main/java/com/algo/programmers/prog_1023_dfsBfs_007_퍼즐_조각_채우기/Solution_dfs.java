package com.algo.programmers.prog_1023_dfsBfs_007_퍼즐_조각_채우기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_dfs {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        n[index++] = new int[][]{{0,0,0},{1,1,0},{1,1,1}};
        index = 0;

        int[][][] m = new int[arrIndex][][];
        m[index++] = new int[][]{{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        m[index++] = new int[][]{{1,1,1},{1,0,0},{0,0,0}};
        index = 0;

        String[][] l = new String[arrIndex][];
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        l[index++] = new String[]{"i", "want", "to", "drink", "water"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //14
        //0
    }
    //테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈 공간에 적절히 올려놓으려 합니다. 게임 보드와 테이블은 모두 각 칸이 1x1 크기인 정사각 격자 모양입니다. 이때, 다음 규칙에 따라 테이블 위에 놓인 퍼즐 조각을 게임 보드의 빈칸에 채우면 됩니다.
    //
    //조각은 한 번에 하나씩 채워 넣습니다.
    //조각을 회전시킬 수 있습니다.
    //조각을 뒤집을 수는 없습니다.
    //게임 보드에 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 됩니다.
    //다음은 퍼즐 조각을 채우는 예시입니다.
    //
    //puzzle_5.png
    //
    //위 그림에서 왼쪽은 현재 게임 보드의 상태를, 오른쪽은 테이블 위에 놓인 퍼즐 조각들을 나타냅니다. 테이블 위에 놓인 퍼즐 조각들 또한 마찬가지로 [상,하,좌,우]로 인접해 붙어있는 경우는 없으며, 흰 칸은 퍼즐이 놓이지 않은 빈 공간을 나타냅니다. 모든 퍼즐 조각은 격자 칸에 딱 맞게 놓여있으며, 격자 칸을 벗어나거나, 걸쳐 있는 등 잘못 놓인 경우는 없습니다.
    //
    //이때, 아래 그림과 같이 3,4,5번 조각을 격자 칸에 놓으면 규칙에 어긋나므로 불가능한 경우입니다.
    //
    //puzzle_6.png
    //
    //3번 조각을 놓고 4번 조각을 놓기 전에 위쪽으로 인접한 칸에 빈칸이 생깁니다.
    //5번 조각의 양 옆으로 인접한 칸에 빈칸이 생깁니다.
    //다음은 규칙에 맞게 최대한 많은 조각을 게임 보드에 채워 넣은 모습입니다.
    //
    //puzzle_7.png
    //
    //최대한 많은 조각을 채워 넣으면 총 14칸을 채울 수 있습니다.
    //
    //현재 게임 보드의 상태 game_board, 테이블 위에 놓인 퍼즐 조각의 상태 table이 매개변수로 주어집니다. 규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //3 ≤ game_board의 행 길이 ≤ 50
    //game_board의 각 열 길이 = game_board의 행 길이
    //즉, 게임 보드는 정사각 격자 모양입니다.
    //game_board의 모든 원소는 0 또는 1입니다.
    //0은 빈칸, 1은 이미 채워진 칸을 나타냅니다.
    //퍼즐 조각이 놓일 빈칸은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
    //table의 행 길이 = game_board의 행 길이
    //table의 각 열 길이 = table의 행 길이
    //즉, 테이블은 game_board와 같은 크기의 정사각 격자 모양입니다.
    //table의 모든 원소는 0 또는 1입니다.
    //0은 빈칸, 1은 조각이 놓인 칸을 나타냅니다.
    //퍼즐 조각은 1 x 1 크기 정사각형이 최소 1개에서 최대 6개까지 연결된 형태로만 주어집니다.
    //game_board에는 반드시 하나 이상의 빈칸이 있습니다.
    //table에는 반드시 하나 이상의 블록이 놓여 있습니다.
    //입출력 예
    //game_board	table	result
    //[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]	[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]	14
    //[[0,0,0],[1,1,0],[1,1,1]]	[[1,1,1],[1,0,0],[0,0,0]]	0
    //입출력 예 설명
    //입출력 예 #1
    //
    //입력은 다음과 같은 형태이며, 문제의 예시와 같습니다.
    static int N;
    static boolean[][] visited;

    public static int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> pieces = new ArrayList<>();

        N = game_board.length;
        visited = new boolean[N][N];

        // 빈칸 추출
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j] && game_board[i][j] == 0) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(game_board, i, j, 0, shape, i, j);
                    blanks.add(normalize(shape));
                }

        visited = new boolean[N][N];

        // 퍼즐 조각 추출
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (!visited[i][j] && table[i][j] == 1) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(table, i, j, 1, shape, i, j);
                    pieces.add(normalize(shape));
                }

        int answer = 0;
        boolean[] used = new boolean[pieces.size()];

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                for (int r = 0; r < 4; r++) {
                    List<int[]> rotated = rotate(pieces.get(i), r);
                    if (match(blank, rotated)) {
                        answer += blank.size();
                        used[i] = true;
                        break;
                    }
                }
                if (used[i]) break;
            }
        }

        return answer;
    }

    static void dfs(int[][] board, int x, int y, int target, List<int[]> shape, int baseX, int baseY) {
        visited[x][y] = true;
        shape.add(new int[]{x - baseX, y - baseY});

        for (int[] d : new int[][]{{-1,0},{1,0},{0,-1},{0,1}}) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (!visited[nx][ny] && board[nx][ny] == target) {
                dfs(board, nx, ny, target, shape, baseX, baseY);
            }
        }
    }

    static List<int[]> normalize(List<int[]> shape) {
        shape.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int baseX = shape.get(0)[0], baseY = shape.get(0)[1];
        List<int[]> norm = new ArrayList<>();
        for (int[] p : shape)
            norm.add(new int[]{p[0] - baseX, p[1] - baseY});
        return norm;
    }

    static List<int[]> rotate(List<int[]> shape, int r) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            int x = p[0], y = p[1];
            if (r == 0) rotated.add(new int[]{x, y});
            else if (r == 1) rotated.add(new int[]{y, -x});
            else if (r == 2) rotated.add(new int[]{-x, -y});
            else rotated.add(new int[]{-y, x});
        }
        rotated.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int baseX = rotated.get(0)[0], baseY = rotated.get(0)[1];
        for (int i = 0; i < rotated.size(); i++)
            rotated.set(i, new int[]{rotated.get(i)[0] - baseX, rotated.get(i)[1] - baseY});
        return rotated;
    }

    static boolean match(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++)
            if (a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1])
                return false;
        return true;
    }
}
