package com.algo.backup.programmers.prog_08.prog_0806_013_바탕화면_정리;

import java.util.Arrays;

//바탕화면정리
public class Solution {

    public static void main(String[] args) {
        String[][] examples = new String[4][];
        examples[0] = new String[]{".#...", "..#..", "...#."};
        examples[1] = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        examples[2] = new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        examples[3] = new String[]{"..", "#."};
        for (String[] wallpaper : examples) {
            int[] answer = solution(wallpaper);
            System.out.println(Arrays.toString(answer));
            System.out.println("=======");
        }
        //{0, 1, 3, 4}
        //{1, 3, 5, 8}
        //{0, 0, 7, 9}
        //{1, 0, 2, 1}
    }

    public static int[] solution(String[] wallpaper) {

        //wallpaper[i][j]는 바탕화면에서 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
        //wallpaper[i][j]는 "#" 또는 "."의 값만 가집니다.
        //바탕화면에는 적어도 하나의 파일이 있습니다.
        //드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 lux < rdx, luy < rdy를 만족해야 합니다.
        int wallpaperH = wallpaper.length;
        int wallpaperW = wallpaper[0].length();
        int startH = Integer.MAX_VALUE;
        int startW = Integer.MAX_VALUE;
        int endH = Integer.MIN_VALUE;
        int endW = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaperH; i++) {
            char[] wallpaperTemp = wallpaper[i].toCharArray();
            for (int j = 0; j < wallpaperTemp.length; j++) {
                if ('#' == wallpaperTemp[j]) {
                    startH = Math.min(startH, i);
                    startW = Math.min(startW, j);
                    endH = Math.max(endH, i + 1);
                    endW = Math.max(endW, j + 1);
                }
            }
        }


        //점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.

        //머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper
        // 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return
        int[] answer = new int[]{startH, startW, endH, endW};

        return answer;
    }
}
