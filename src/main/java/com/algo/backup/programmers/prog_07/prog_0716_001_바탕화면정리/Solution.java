package com.algo.backup.programmers.prog_07.prog_0716_001_바탕화면정리;

import java.util.Arrays;

//바탕화면 정리
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
        }
//        //{0, 1, 3, 4}
//        //{1, 3, 5, 8}
//        //{0, 0, 7, 9}
//        //{1, 0, 2, 1}

    }

    public static int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            char[] walletPaperTemp = wallpaper[i].toCharArray();
            for (int j = 0; j < walletPaperTemp.length; j++) {
                if ('#' == walletPaperTemp[j]) {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}
