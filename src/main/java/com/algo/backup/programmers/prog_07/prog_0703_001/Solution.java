package com.algo.backup.programmers.prog_07.prog_0703_001;

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
        String answer;
        long video_len_sec = transFunc(video_len);  //동영상의 총 길이
        long pos_sec = transFunc(pos);  //동영상의 현재위치
        long op_start_sec = transFunc(op_start);
        long op_end_sec = transFunc(op_end);

        long current = pos_sec;
        if (current >= op_start_sec && current <= op_end_sec) {
            current = op_end_sec;
        }
        for (String s : commands) {
            if ("prev".equals(s)) {
                current = current < 10 ? 0 : current - 10;
            }
            if ("next".equals(s)) {
                current = video_len_sec - current < 10 ? video_len_sec : current + 10;
            }

            if (current >= op_start_sec && current <= op_end_sec) {
                current = op_end_sec;
            }
        }

        answer = String.format("%02d", current / 60) + ":" + String.format("%02d", current % 60);

        return answer;
    }

    private static long transFunc(String s) {
        long min = Long.parseLong(s.substring(0, 2));
        long sec = Long.parseLong(s.substring(3, 5));
        return min * 60 + sec;
    }


}
