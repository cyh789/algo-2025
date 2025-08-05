package com.algo.programmers.prog_0805_012_공원_산책;

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
        //공원을 나타내는 문자열 배열 park,
        //S : 시작 지점
        //O : 이동 가능한 통로
        //X : 장애물
        int parkH = park.length;
        int parkW = park[0].length();
        int startH = Integer.MAX_VALUE;
        int startW = Integer.MAX_VALUE;
        String[][] parkTable = new String[parkH][parkW];
        for (int i = 0; i < parkH; i++) {
            char[] parkTemp = park[i].toCharArray();
            for (int j = 0; j < parkW; j++) {
                char selected = parkTemp[j];
                if ('S' == selected) {
                    startH = i;
                    startW = j;
                }
                parkTable[i][j] = String.valueOf(selected);
            }
        }

        for (int i = 0; i < parkTable.length; i++) {
            System.out.println(Arrays.toString(parkTable[i]));
        }
        System.out.println("==============");

        // 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes
        //["방향 거리", "방향 거리" … ]
        //예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다.
        int currentH = startH;
        int currentW = startW;

        for (int k = 0; k < routes.length; k++) {

            System.out.println("currentH=" + currentH + " / currentW=" + currentW);

            String[] routesTemp = routes[k].split(" ");
            char direction = routesTemp[0].charAt(0);
            int move = Integer.parseInt(routesTemp[1]);

            // 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
            //주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
            //주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
            //위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.

            //공원의 가로 길이가 W, 세로 길이가 H라고 할 때,
            // 공원의 좌측 상단의 좌표는 (0, 0),
            // 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
            boolean stop = false;
            if ('E' == direction) {
                if (currentW + move < parkW) {
                    for (int i = 1; i <= move; i++) {
                        if ("X".equals(parkTable[currentH][currentW + i])) {
                            stop = true;
                            break;
                        }
                    }
                    if (!stop) currentW += move;
                }
            }
            if ('W' == direction) {
                if (currentW - move >= 0) {
                    for (int i = 1; i <= move; i++) {
                        if ("X".equals(parkTable[currentH][currentW - i])) {
                            stop = true;
                            break;
                        }
                    }
                    if (!stop) currentW -= move;
                }
            }
            if ('S' == direction) {
                if (currentH + move < parkH) {
                    for (int i = 1; i <= move; i++) {
                        if ("X".equals(parkTable[currentH + i][currentW])) {
                            stop = true;
                            break;
                        }
                    }
                    if (!stop) currentH += move;
                }
            }
            if ('N' == direction) {
                if (currentH - move >= 0) {
                    for (int i = 1; i <= move; i++) {
                        if ("X".equals(parkTable[currentH - i][currentW])) {
                            stop = true;
                            break;
                        }
                    }
                    if (!stop) currentH -= move;
                }
            }

        }


        // 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
        int[] answer = {currentH, currentW};
        return answer;
    }
}
