package com.algo.backup.programmers.prog_08.prog_0731_002_유연근무제;

//유연근무제
public class Solution {
    public static void main(String[] args) {
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;
        //answer = 3
//        int[] schedules = {730, 855, 700, 720};
//        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
//        int startday = 1;
        //answer = 2
        int answer = solution(schedules, timelogs, startday);
        System.out.println(answer);
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {

        int[] schedulesTemp = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            schedulesTemp[i]  = transFunc(schedules[i]);
        }
        int[][] timelogsTemp = new int[timelogs.length][timelogs[0].length];
        for (int i = 0; i < timelogs.length; i++) {
            for (int j = 0; j < timelogs[i].length; j++) {
                timelogsTemp[i][j]  = transFunc(timelogs[i][j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < timelogsTemp.length; i++) {
            int currentday = startday;
            boolean late = false;
            for (int j = 0; j < timelogsTemp[i].length; j++) {
                if (currentday > 5) {
                    currentday++;
                    if (currentday > 7) currentday = 1;
                    continue;
                }
                if (schedulesTemp[i] + 10 < timelogsTemp[i][j]) late = true;
                currentday++;
            }

            if (!late) sum++;
        }

        return sum;
    }

    private static int transFunc(int schedule) {
        String s = String.valueOf(schedule);
        if (s.length() == 3) s = "0" + s;
        String hour = s.substring(0, 2);
        String min = s.substring(2, 4);

        return Integer.parseInt(hour) * 60
                    + Integer.parseInt(min);
    }

}
