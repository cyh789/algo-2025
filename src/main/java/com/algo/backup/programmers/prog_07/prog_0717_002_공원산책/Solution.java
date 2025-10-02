package com.algo.backup.programmers.prog_07.prog_0717_002_공원산책;

import java.util.Arrays;

//공원산책
public class Solution {

    public static void main(String[] args) {
        String[][] examples = new String[3][];
        examples[0] = new String[]{"SOO","OOO","OOO"}		;
        examples[1] = new String[]{"SOO","OXX","OOO"}		;
        examples[2] = new String[]{"OSO","OOO","OXO","OOO"}	;
        String[][] examples2 = new String[3][];
        examples2[0] = new String[]{"E 2","S 2","W 1"};
        examples2[1] = new String[]{"E 2","S 2","W 1"};
        examples2[2] = new String[]{"E 2","S 3","W 1"};
//        //{2,1}
//        //{0,1}
//        //{0,0}
        for (int i = 0; i < examples.length; i++) {
            String[] park = examples[i];
            String[] routes = examples2[i];
            int[] answer = solution(park, routes);
            System.out.println(Arrays.toString(answer));
            System.out.println("================");
        }
    }

    public static int[] solution(String[] park, String[] routes) {
        int currentX = Integer.MIN_VALUE;
        int currentY = Integer.MIN_VALUE;
        String[][] parkTable = new String[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            char[] parkTemp = park[i].toCharArray();
            for (int j = 0; j < parkTemp.length; j++) {
                parkTable[i][j] = String.valueOf(parkTemp[j]);

                if ('S' == parkTemp[j]) {
                    currentX = j;
                    currentY = i;
                }
            }
        }

        for (String[] strings : parkTable) {
            System.out.println(Arrays.toString(strings));
        }

        for (String route : routes) {
            String[] routesTemp = route.split(" ");
            int move = Integer.parseInt(routesTemp[1]);
            boolean stop = false;

            System.out.println("currentX=" + currentX + " / currentY=" + currentY);
            System.out.println("routesTemp[0]=" + routesTemp[0] + " / selected=" + move);
            System.out.println("--------");
            if ("E".equals(routesTemp[0])) {
                System.out.println("## currentX + move=" + (currentX + move));
                System.out.println("## parkTable[0].length=" + parkTable[0].length);
                if (currentX + move < parkTable[0].length) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentY][currentX + j])) stop = true;
                    }
                    if (!stop) currentX += move;
                }
            }
            if ("W".equals(routesTemp[0])) {
                if (currentX - move >= 0) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentY][currentX - j])) stop = true;
                    }
                    if (!stop) currentX -= move;
                }
            }

            if ("S".equals(routesTemp[0])) {
                if (currentY + move < parkTable.length) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentY + j][currentX])) stop = true;
                    }
                    if (!stop) currentY += move;
                }
            }
            if ("N".equals(routesTemp[0])) {
                if (currentY - move >= 0) {
                    for (int j = 1; j <= move; j++) {
                        if ("X".equals(parkTable[currentY - j][currentX])) stop = true;
                    }
                    if (!stop) currentY -= move;
                }
            }

        }

        return new int[]{currentY, currentX};
    }
}
