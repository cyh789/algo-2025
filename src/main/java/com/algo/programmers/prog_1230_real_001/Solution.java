package com.algo.programmers.prog_1230_real_001;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{1, 8, 1, 13}, {5, 18, 6, 9}};
        n[index++] = new int[][]{{1, 22, 3, 8}, {13, 12, 13, 17}, {14, 22, 15, 0}};

        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 10000;
        m[index++] = 15000;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //
    }

    //근로자의 한달 동안의 근로시간 기록과 시간당 급여를 입력받아 근로자가 받아야 할 한달 이금을 알려주는 함수
    //기본수당 : 1시간 근무할떄마다 시간당 급여 지급받음
    //연장수당 : 하루에 8시간 초과시, 초과시간 만큼 시간당 급여의 0.5배 추가 지급
    //야간수당 : 22~24시에 근무하는 경우, 야간 근무시간 만큼 시간당 급여의 0.5배 추가 지급
    //주말수당 : 주말에 근무하는 경우, 시간당 급여의 0.5배 추가 지급
    //주휴수당 : 일주일에 15시간 이상 근무시, 일주일 총 근무시간 만큼 시간당 급여의 0.2배를 추가 지급. 단 순서대로 연속된 월화수목금토일을 일주일로 정의하고, 이번 달 마지막 주 주휴수당은 이번 달 임금에 포함되지 않음. 이번 달 1일은 월요일임.

    //임금 계산 예시 1
    //works = new int[][]{{1, 8, 1, 13}, {5, 18, 6, 9}};
    //wage=10000
    //result=300000
    //부연설명
    //기본수당:200000
    //연장수당:5000
    //야간수당:10000
    //주말수당:45000
    //주휴수당:40000

    //works = new int[][]{{1, 22, 3, 8}, {13, 12, 13, 17}, {14, 22, 15, 0}};
    //wage=15000
    //result=934500
    //부연설명
    //기본수당:615000
    //연장수당:120000
    //야간수당:45000
    //주말수당:52500
    //주휴수당:102000
    public static int solution(int[][] works, int wage) {
        int base = 0;
        int overtime = 0;
        int night = 0;
        int weekend = 0;
        int total = 0;

        for (int i = 0; i < works.length; i++) {
            int a = works[i][0];    // start day
            int b = works[i][1];    // start time
            int c = works[i][2];    // end day
            int d = works[i][3];    // end time

            //근무시각
            int start = chkFunc(a, b);
            int end = chkFunc(c, d);

            //기본수당
            base += getBase(end, start);
            //연장수당
            overtime += getOvertime(works[i]);
            //야간수당
            night += getNight(works[i]);
            //주말수당
            weekend += getWeekend(works[i]);
        }
        //주휴수당
        int[] weeklyHolidayTemp = new int[33];
        int weeklyHoliday = getWeeklyHoliday(weeklyHolidayTemp, works);

        //계산
        base *= wage;
        overtime *= (wage * 0.5);
        night *= (wage * 0.5);
        weekend *= (wage * 0.5);
        weeklyHoliday *= (wage * 0.2);
        System.out.print("base=" + base + " ");
        System.out.print(" / overtime=" + overtime + " ");
        System.out.print(" / weekend=" + weekend + " ");
        System.out.print(" / weekend=" + weekend + " ");
        System.out.print(" / weeklyHoliday=" + weeklyHoliday + " ");
        total = base + overtime + night + weekend + weeklyHoliday;

        return total;
    }

    private static int getWeekend(int[] work) {
        int total = 0;
        for (int i = work[0]; i <= work[2]; i++) {
            if (!isWeekend(i)) continue;

            int start = 0;
            int end = 24;
            if (i == work[0]) start = work[1];
            if (i == work[2]) end = work[3];

            if (start < end) {
                total += end - start;
            }
        }

        return total;
    }

    private static boolean isWeekend(int day) {
        return day % 7 == 6 || day % 7 == 0;
    }

    private static int getNight(int[] work) {
        int total = 0;
        for (int i = work[0]; i <= work[2]; i++) {
            int start = 0;
            int end = 24;
            if (i == work[0]) start = work[1];
            if (i == work[2]) end = work[3];

            start = Math.max(start, 22);
            end = Math.min(end, 24);
            if (start < end) {
                total += end - start;
            }
        }

        return total;
    }

    private static int getOvertime(int[] work) {
        int total = 0;
        for (int i = work[0]; i <= work[2]; i++) {
            int start = 0;
            int end = 24;

            if (i == work[0]) start = work[1];
            if (i == work[2]) end = work[3];

            int worked = end - start;
            if (worked > 8) {
                total += (worked - 8);
            }
        }

        return total;
    }

    private static int getBase(int end, int start) {
        return end - start;
    }

    private static int getWeeklyHoliday(int[] weeklyHolidayTemp, int[][] works) {
        int total = 0;

        int lastDay = 0;
        for (int i = 0; i < works.length; i++) {
            int a = works[i][0];    // start day
            int b = works[i][1];    // start time
            int c = works[i][2];    // end day
            int d = works[i][3];    // end time

            lastDay = Math.max(lastDay, c); //마지막날

            //시작일과 종료일이 같은 경우
            if (a == c) {
                weeklyHolidayTemp[a] += d - b;
            } else {
                //시작일
                weeklyHolidayTemp[a] += 24 - b;
                //중간
                for (int j = a + 1; j < c; j++) {
                    weeklyHolidayTemp[j] += 24;
                }
                //종료일
                weeklyHolidayTemp[c] += d;
            }
        }

        //마지막주 주휴수당은 제외
        for (int i = 1; i < 5; i++) {
            int weeklySum = 0;
            int start = (i - 1) * 7 + 1;
            int end = i * 7;

            //일주일 15시간 미만은 제외
            for (int j = start; j <= end; j++) {
                weeklySum += weeklyHolidayTemp[j];
            }

            if (weeklySum >= 15) total += weeklySum;
        }

        return total;
    }

    private static int chkFunc(int day, int time) {
        if (day == 1) return time;
        return day * 24 + time - 24;
    }
}
