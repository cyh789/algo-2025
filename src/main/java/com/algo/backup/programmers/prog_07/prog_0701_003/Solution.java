package com.algo.backup.programmers.prog_07.prog_0701_003;

//[PCCE 기출문제] 9번 / 이웃한 칸
public class Solution {
    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
//        String[][] board = {{"yellow", "green", "blue"},
//                            {"blue", "green", "yellow"},
//                            {"yellow", "blue", "blue"}};
//        int h = 0;
//        int w = 1;
        int answer = solution(board, h, w);
        System.out.println("answer=" + answer);
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int boardW = board[0].length;
        int boardH = board.length;
        String color = board[h][w];

//        //위, 오른쪽, 아래, 왼쪽을 구한다
//        List<String> selected = new ArrayList<>();
//        if (h-1 >= 0) selected.add(board[h-1][w]);
//        if (w+1 < boardW) selected.add(board[h][w+1]);
//        if (h+1 < boardH) selected.add(board[h+1][w]);
//        if (w-1 >= 0) selected.add(board[h][w-1]);
//
//        for (int i = 0; i < selected.size(); i++) {
//            if (color.equals(selected.get(i))) {
//                answer++;
//            }
//        }

        //위, 오른쪽, 아래, 왼쪽을 구한다
        if (h-1 >= 0) answer += color.equals(board[h-1][w]) ? 1 : 0;
        if (w+1 < boardW) answer += color.equals(board[h][w+1]) ? 1 : 0;
        if (h+1 < boardH) answer += color.equals(board[h+1][w]) ? 1 : 0;
        if (w-1 >= 0) answer += color.equals(board[h][w-1]) ? 1 : 0;
        return answer;
    }
}
