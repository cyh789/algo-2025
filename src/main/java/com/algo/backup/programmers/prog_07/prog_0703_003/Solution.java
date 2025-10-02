package com.algo.backup.programmers.prog_07.prog_0703_003;

//2025 프로그래머스 코드챌린지 1차 예선
//유연근무제
@SuppressWarnings("ConstantValue")
public class Solution {

    public static void main(String[] args) {
        int[] schedules;
        int[][] timelogs;
        int startday;
        String testcase = "2";
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

        //출근 시각은 HHMM 형식의 정수로 주어지며, 이를 시간과 분 단위로 변환하여 비교해야 합니다.
        int[] schedulesTemp = transFunc(schedules);

        //출근 시각은 HHMM 형식의 정수로 주어지며, 이를 시간과 분 단위로 변환하여 비교해야 합니다.
        int[][] timelogsTemp = new int[timelogs.length][timelogs[0].length];
        for (int i = 0; i < timelogs.length; i++) {
            timelogsTemp[i] = transFunc(timelogs[i]);
        }

        //주어진 시작 요일(startday)에 따라 출근 기록을 주중과 주말로 구분하여 검사해야 합니다.
        int currentday = startday;
        for (int i = 0; i < schedulesTemp.length; i++) {
            boolean flag = true;
            //System.out.println("timelogsTemp[i]=" + Arrays.toString(timelogsTemp[i]));
            for (int j = 0; j < timelogsTemp[i].length; j++) {
                //주말(토요일, 일요일)은 이벤트에 영향을 주지 않습니다.
                if (currentday >= 6) {
                    if (currentday == 7) {
                        currentday = 1;
                    } else {
                        currentday++;
                    }
                    continue;
                }

                //직원은 1주일 동안 출근 희망 시각 + 10분 이내에 출근해야 합니다.
                if (schedulesTemp[i] + 10 < timelogsTemp[i][j]) {
                    //System.out.println("schedulesTemp[i]=" + schedulesTemp[i] + " / timelogsTemp[i][j]=" + timelogsTemp[i][j]);
                    flag = false;
                }

                currentday++;
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
