package com.algo.programmers.prog_0717_003_공원산책;

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

    private static int currentH = Integer.MAX_VALUE;
    private static int currentW = Integer.MAX_VALUE;
    public static int[] solution(String[] park, String[] routes) {
        //examples[0] = new String[]{"SOO","OOO","OOO"}		;
        //examples2[0] = new String[]{"E 2","S 2","W 1"};
        int parkH = park.length;
        int parkW = park[0].length();
        String[][] parkTable = new String[parkH][parkW];
        for (int i = 0; i < park.length; i++) {
            char[] parkTemp = park[i].toCharArray();
            for (int j = 0; j < parkTemp.length; j++) {
                parkTable[i][j] = String.valueOf(parkTemp[j]);
                if ('S' == parkTemp[j]) {
                    currentH = i;
                    currentW = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] routesTemp = routes[i].split(" ");
            String direction = routesTemp[0];
            int move = Integer.parseInt(routesTemp[1]);

            chkFunc(parkW, parkH, direction, move, parkTable);
        }
        
        return new int[]{currentH, currentW};
    }

    private static void chkFunc(int parkW, int parkH, String direction, int move, String[][] parkTable) {
        boolean stop = false;
//        System.out.println("currentW=" + currentW + " currentH=" + currentH);
//        System.out.println("direction=" + direction + " move=" + move);
//        System.out.println("parkW=" + parkW  + " parkH=" + parkH);
        if ("E".equals(direction) && currentW + move <= parkW - 1) {
            for (int j = 1; j <= move; j++) {
                if ("X".equals(parkTable[currentH][currentW + j])) stop = true;
            }
            if (!stop) currentW += move;
        }
        if ("W".equals(direction) && currentW - move >= 0) {
            for (int j = 1; j <= move; j++) {
                if ("X".equals(parkTable[currentH][currentW - j])) stop = true;
            }
            if (!stop) currentW -= move;
        }

        if ("S".equals(direction) && currentH + move <= parkH - 1) {
            for (int j = 1; j <= move; j++) {
                if ("X".equals(parkTable[currentH + j][currentW])) stop = true;
            }
            if (!stop) currentH += move;
        }
        if ("N".equals(direction) && currentH - move >= 0) {
            for (int j = 1; j <= move; j++) {
                if ("X".equals(parkTable[currentH - j][currentW])) stop = true;
            }
            if (!stop) currentH -= move;
        }
    }
}
