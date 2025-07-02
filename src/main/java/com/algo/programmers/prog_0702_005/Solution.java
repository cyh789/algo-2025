package com.algo.programmers.prog_0702_005;

//[PCCP 기출문제] 1번 / 동영상 재생기
public class Solution {
    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};
        String answer = solution(video_len, pos, op_start, op_end, commands);
        System.out.println(answer);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //00:00 표기를 숫자로 변환해야됨 => 비교가능
        long pos_sec_total = transSec(pos);
        long video_len_sec_total = transSec(video_len);
        long op_start_sec_total = transSec(op_start);
        long op_end_sec_total = transSec(op_end);

        long current = pos_sec_total;

        //오프닝 건너뛰기
        //  현재 재생위치가 오프닝 구간인 경우, 오프닝이 끝나는 위치로 이동
        if (current >= op_start_sec_total && current <= op_end_sec_total) current = op_end_sec_total;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            //prev : 10초 전
            //  현재 위치가 00:10초 미만인 경우, 처음위치로 이동 => 00:00
            if (command.equals("prev")) {
                current = current < 10 ? 0 : current -10;
                //current = Math.max(current -10, 0);
            }
            //next : 10초 후
            //  동영상의 남은 시간이 00:10초 미만인 경우. 마지막 위치로 이동 => 동영상의길이
            else if (command.equals("next")) {
                current = video_len_sec_total - current < 10 ? video_len_sec_total : current +10;
                //current = Math.min(current +10, video_len_sec_total);
            }

            //오프닝 건너뛰기
            if (current >= op_start_sec_total && current <= op_end_sec_total) current = op_end_sec_total;
        }

        long answer_min = current / 60;
        long answer_sec = current % 60;

        String answer = String.format("%02d", answer_min)
                + ":"
                + String.format("%02d", answer_sec);

        return answer;
    }

    private static long transSec(String pos) {
        long pos_min = Long.parseLong(pos.substring(0, 2));
        long pos_sec = Long.parseLong(pos.substring(3, 5));
        return (pos_min * 60) + pos_sec;
    }


}
