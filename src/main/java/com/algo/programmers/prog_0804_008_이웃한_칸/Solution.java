package com.algo.programmers.prog_0804_008_이웃한_칸;

//이웃한 칸
public class Solution {
    public static void main(String[] args) {
//        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
//        int h=1;	int w=1;
        //answer=2
        String[][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h=0;	int w=1;
        //answer=1
        int answer = solution(board, h, w);
        System.out.println(answer);
    }

    public static int solution(String[][] board, int h, int w) {
        //각 칸마다 색이 칠해진 2차원 격자 보드판이 있습니다. 그중 한 칸을 골랐을 때,
        //  위, 아래, 왼쪽, 오른쪽 칸 중 같은 색깔로 칠해진 칸의 개수를 구하려고 합니다.
        //
        //보드의 각 칸에 칠해진 색깔 이름이 담긴 이차원 문자열 리스트 board
        //고른 칸의 위치를 나타내는 두 정수 h, w
        //board[h][w]와 이웃한 칸들 중 같은 색으로 칠해져 있는 칸의 개수를 return

        int boardH = board.length;
        int boardW = board[0].length;
        String selected = board[h][w];

        int answer = 0;
        //위
        if (h - 1 >= 0) {
            if (selected.equals(board[h - 1][w])) answer++;
        }
        //아래
        if (h + 1 <= boardH - 1) {
            if (selected.equals(board[h + 1][w])) answer++;
        }
        //왼쪽
        if (w - 1 >= 0) {
            if (selected.equals(board[h][w - 1])) answer++;
        }
        //오른쪽
        if (w + 1 <= boardW - 1) {
            if (selected.equals(board[h][w + 1])) answer++;
        }

        return answer;
    }

}
