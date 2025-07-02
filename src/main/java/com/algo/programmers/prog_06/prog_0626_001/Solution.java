package com.algo.programmers.prog_06.prog_0626_001;

import java.util.ArrayList;
import java.util.List;

//[PCCE 기출문제] 9번 / 이웃한 칸
public class Solution {
    public static void main(String[] args) {
//        String[][] board = {{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}};
//        int h = 1;
//        int w = 1;
        String[][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h = 0;
        int w = 1;
        int answer = solution(board, h, w);
        System.out.println("answer=" + answer);
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;
        int x = board[0].length -1;    //0~6
        int y = board.length -1;   //0~9
        String color = board[h][w];

        List<String> selects = new ArrayList<>();
        if (h-1 >= 0) selects.add(board[h-1][w]);   //up
        if (w+1 <= y) selects.add(board[h][w+1]);   //right
        if (h+1 <= x) selects.add(board[h+1][w]);   //down
        if (w-1 >= 0) selects.add(board[h][w-1]);   //left

        for (String s : selects) {
            if (s.equals(color)) answer++;
        }

        return answer;
    }
}
