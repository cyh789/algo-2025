package com.algo.backup.programmers.prog_10.prog_1028_to_1031_dfsBfs.prog_dfsBfs_007_퍼즐_조각_채우기;

import java.util.ArrayList;
import java.util.Collections;

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

    public static int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        ArrayList<ArrayList<int[]>> boardList = new ArrayList<>();
        boolean[][] boardVisited = new boolean[n][n];
        ArrayList<ArrayList<int[]>> tableList = new ArrayList<>();
        boolean[][] tableVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!boardVisited[i][j] && game_board[i][j] == 0) {
                    ArrayList<int[]> result = new ArrayList<>();
                    dfs(game_board, boardVisited, result, 0, i, j, new int[]{i, j});
                    boardList.add(result);
                }
                if (!tableVisited[i][j] && table[i][j] == 1) {
                    ArrayList<int[]> result = new ArrayList<>();
                    dfs(table, tableVisited, result, 1, i, j, new int[]{i, j});
                    tableList.add(result);
                }
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[boardList.size()];
        for (ArrayList<int[]> tablePoints : tableList) {
            for (int j = 0; j < boardList.size(); j++) {
                ArrayList<int[]> boardPoints = boardList.get(j);
                if (visited[j]) continue;
                if (boardPoints.size() != tablePoints.size()) continue;
                if (!match(boardPoints, tablePoints)) continue;

                visited[j] = true;
                answer += tablePoints.size();
                break;
            }
        }

        return answer;
    }

    private static boolean match(ArrayList<int[]> boardPoints, ArrayList<int[]> tablePoints) {
        Collections.sort(boardPoints, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < 4; i++) {
            Collections.sort(tablePoints, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            boolean correct = true;

            int zeroX = tablePoints.get(0)[0];
            int zeroY = tablePoints.get(0)[1];
            for (int j = 0; j < tablePoints.size(); j++) {
                tablePoints.get(j)[0] -= zeroX;
                tablePoints.get(j)[1] -= zeroY;
            }

            for (int j = 0; j < tablePoints.size(); j++) {
                int[] tablePoint = tablePoints.get(j);
                int[] boardPoint = boardPoints.get(j);
                if (tablePoint[0] != boardPoint[0] || tablePoint[1] != boardPoint[1]) {
                    correct = false;
                    break;
                }
            }

            if (correct) return true;
            for (int j = 0; j < tablePoints.size(); j++) {
                int temp = tablePoints.get(j)[0];
                tablePoints.get(j)[0] = tablePoints.get(j)[1];
                tablePoints.get(j)[1] = -temp;
            }
        }

        return false;
    }

    private static void dfs(int[][] gameBoard, boolean[][] visited, ArrayList<int[]> result, int target, int i, int j, int[] start) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[i][j] = true;
        result.add(new int[]{i - start[0], j - start[1]});

        for (int m = 0; m < 4; m++) {
            int nextX = i + dx[m];
            int nextY = j + dy[m];

            if (nextX < 0 || nextX >= gameBoard.length) continue;
            if (nextY < 0 || nextY >= gameBoard[0].length) continue;
            if (visited[nextX][nextY]) continue;
            if (gameBoard[nextX][nextY] != target) continue;

            visited[nextX][nextY] = true;
            dfs(gameBoard, visited, result, target, nextX, nextY, start);
        }
    }
}
