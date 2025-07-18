package com.algo.backup.programmers.prog_07.prog_0717_001_바탕화면정리;

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
        }
        //{0, 1, 3, 4}
        //{1, 3, 5, 8}
        //{0, 0, 7, 9}
        //{1, 0, 2, 1}
    }

    public static int[] solution(String[] wallpaper) {
        //sudo
        //int lux, luy = Integer.MAX_VALUE;
        //int rdx, rdy = Integer.MIN_VALUE;
        //for i wallpaper.length
        // wallpaper[i] => char[] wallpaperTemp
        // for j wallpaperTemp.length
        //  if '#' == wallpaperTemp[j]
        //  lux = Math.min(lux, i)
        //  luy = Math.min(luy, j)
        //  rdx = Math.max(rdx, i + 1)
        //  rdy = Math.max(rdy, j + 1)
        //return new int[]{lux, luy, rdx, rdy}

        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            char[] wallpaperTemp = wallpaper[i].toCharArray();
            for (int j = 0; j < wallpaperTemp.length; j++) {
                if ('#' == wallpaperTemp[j]) {
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
