package com.algo.programmers.prog_0704_003;

//2025 프로그래머스 코드챌린지 1차 예선
//유연근무제
public class Solution {
    public static void main(String[] args) {
        int[] schedules;
        int[][] timelogs;
        int startday;
        String testcase = "1";
        if (testcase.equals("1")) {
            schedules = new int[]{700, 800, 1100};
            timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
            startday = 5;
            //answer = 3
        } else {
            schedules = new int[]{730, 855, 700, 720};
            timelogs = new int[][]{{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
            startday = 1;
            //answer = 2
        }
        int answer = solution(schedules, timelogs, startday);
        System.out.println(answer);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] schedules_temp = transFunc(schedules);
        int[][] timelogs_temp = new int[timelogs.length][timelogs[0].length];
        for (int i = 0; i < timelogs.length; i++) {
            timelogs_temp[i] = transFunc(timelogs[i]);
        }


        //직원 순서대로 1명씩 for문
        for (int i = 0; i < timelogs_temp.length; i++) {
            //요일 순서대로. 시작요일은 매번 다름
            boolean flag = true;
            int today = startday;
            for (int j = 0; j < timelogs_temp[0].length; j++) {
                if (today == 6) {
                    today++;
                    continue;
                }
                if (today == 7) {
                    today = 1;
                    continue;
                }

                if (schedules_temp[i] + 10 < timelogs_temp[i][j]) {
                    flag = false;
                }

                today++;
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }

    private static int[] transFunc(int[] time) {
        int[] answer = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            int hour = time[i] / 100;
            int min = time[i] % 100;
            answer[i] = hour * 60 + min;
        }
        return answer;
    }


}
