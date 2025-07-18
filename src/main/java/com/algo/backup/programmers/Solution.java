package com.algo.backup.programmers;

import java.util.Arrays;

//
public class Solution {

    public static void main(String[] args) {
        String[][] examples = new String[4][];
        examples[0] = new String[]{".#...", "..#..", "...#."};
        examples[1] = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        examples[2] = new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        examples[3] = new String[]{"..", "#."};
        for (int i = 0; i < examples.length; i++) {
            int[] answer = solution(examples[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("==========");
        }
        //{0, 1, 3, 4}
        //{1, 3, 5, 8}
        //{0, 0, 7, 9}
        //{1, 0, 2, 1}
    }

    public static int[] solution(String[] wallpaper) {
        return new int[0];
    }
}
