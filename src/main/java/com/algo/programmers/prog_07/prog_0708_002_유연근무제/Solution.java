package com.algo.programmers.prog_07.prog_0708_002_유연근무제;

//유연근무제
public class Solution {
    public static void main(String[] args) {
//        int[] schedules = {700, 800, 1100};
//        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
//        int startday = 5;
        //answer = 3
        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int startday = 1;
        //answer = 2
        int answer = solution(schedules, timelogs, startday);
        System.out.println(answer);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] schedulesTemp = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            schedulesTemp[i] = transFunc(schedules[i]);
        }
        int[][] timelogsTemp = new int[timelogs.length][timelogs[0].length];
        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                timelogsTemp[i][j] = transFunc(timelogs[i][j]);
            }
        }

        for (int i = 0; i < timelogsTemp.length; i++) {
            int today = startday;
            int selected = schedulesTemp[i];
            boolean late = false;
            for (int j = 0; j < timelogsTemp[i].length; j++) {
                if (late) {
                    break;
                }

                if (today >= 6) {
                    if (today == 7) {
                        today = 1;
                        continue;
                    }
                    today++;
                    continue;
                }

//                System.out.println("today=" + today + " / selected=" + selected + " / timelogsTemp=" + timelogsTemp[i][j]);
                if (selected + 10 < timelogsTemp[i][j]) {
                    late = true;
                }
                today++;
            }

            if (!late) {
                answer++;
            }
//            System.out.println("========");
        }

        return answer;
    }

    private static int transFunc(int time) {
        int answer = 0;
        int hour = time / 100;
        int min = time % 100;
        answer = hour * 60 + min;
        return answer;
    }
}
