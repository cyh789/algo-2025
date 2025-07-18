package com.algo.backup.programmers.prog_07.prog_0711_004_공원산책;

import java.util.Arrays;

//공원 산책
public class Solution {

    public static void main(String[] args) {
//        String[] park={"SOO","OOO","OOO"}		;
//        String[] routes={"E 2","S 2","W 1"};
//        //{2,1}
//        String[] park={"SOO","OXX","OOO"}		;
//        String[] routes={"E 2","S 2","W 1"};
//        //{0,1}
        String[] park={"OSO","OOO","OXO","OOO"}	;
        String[] routes={"E 2","S 3","W 1"};
//        //{0,0}
        int[] answer = solution(park, routes);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] park, String[] routes) {
        String[][] parkTable = new String[park.length][park[0].length()];
        int startIndexH = 0;
        int startIndexW = 0;
        for (int i = 0; i < park.length; i++) {
            char[] value = park[i].toCharArray();
            for (int j = 0; j < value.length; j++) {
                String valueTemp = String.valueOf(value[j]);
                parkTable[i][j] = valueTemp;
                if ("S".equals(valueTemp)) {
                    startIndexH = i;
                    startIndexW = j;
                }
            }
        }

        for (int i = 0; i < parkTable.length; i++) {
            System.out.println(Arrays.toString(parkTable[i]));
        }

        int currentIndexH = startIndexH;
        int currentIndexW = startIndexW;

        for (int i = 0; i < routes.length; i++) {
            String[] parts = routes[i].split(" ");
            String direction = parts[0];
            int move = Integer.parseInt(parts[1]);

            boolean possible = true;
            if ("E".equals(direction)) {
                if (currentIndexW + move < parkTable[0].length) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentIndexH][currentIndexW + j])) possible = false;
                    }
                    if (possible) currentIndexW += move;
                }
            }
            if ("W".equals(direction)) {
                if (currentIndexW - move >= 0) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentIndexH][currentIndexW - j])) possible = false;
                    }
                    if (possible) currentIndexW -= move;
                }
            }
            if ("S".equals(direction)) {
                if (currentIndexH + move < parkTable.length) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentIndexH + j][currentIndexW])) possible = false;
                    }
                    if (possible) currentIndexH += move;
                }
            }
            if ("N".equals(direction)) {
                if (currentIndexH - move >= 0) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentIndexH - j][currentIndexW])) possible = false;
                    }
                    if (possible) currentIndexH -= move;
                }
            }
        }

        int[] answer = {currentIndexH, currentIndexW};
        
        return answer;
    }
}
