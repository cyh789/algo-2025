package com.algo.backup.programmers.prog_07.prog_0704_001;

//[PCCP 기출문제] 1번 / 동영상 재생기
public class Solution {
    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};
        //answer = 04:17
        String answer = solution(video_len, pos, op_start, op_end, commands);
        System.out.println(answer);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer;
        int video_len_temp = transFunc(video_len);  //비디오 전체 길이
        int pos_temp = transFunc(pos);      //현재 재생 위치
        int op_start_temp = transFunc(op_start);
        int op_end_temp = transFunc(op_end);

        int current = pos_temp;
        if (current >= op_start_temp && current <= op_end_temp) {
            current = op_end_temp;
        }
        for (String command : commands) {
            if ("prev".equals(command)) {
                current = Math.max(0, current - 10);
            }
            if ("next".equals(command)) {
                current = Math.min(current + 10, video_len_temp);
            }

            if (current >= op_start_temp && current <= op_end_temp) {
                current = op_end_temp;
            }
        }

        answer = String.format("%02d", current / 60) + ":" + String.format("%02d", current % 60);

        return answer;
    }

    private static int transFunc(String s) {
        int min = Integer.parseInt(s.substring(0, 2));
        int sec = Integer.parseInt(s.substring(3, 5));
        return min * 60 + sec;
    }


}
