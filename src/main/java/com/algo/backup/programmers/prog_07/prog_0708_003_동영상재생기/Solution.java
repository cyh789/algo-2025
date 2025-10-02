package com.algo.backup.programmers.prog_07.prog_0708_003_동영상재생기;

//동영상 재생기
public class Solution {
    public static void main(String[] args) {
//        String video_len = "34:33";
//        String pos = "13:00";
//        String op_start = "00:55";
//        String op_end = "02:55";
//        String[] commands = {"next", "prev"};
//        //answer="13:00"
//        String video_len = "10:55";
//        String pos = "00:05";
//        String op_start = "00:15";
//        String op_end = "06:55";
//        String[] commands = {"prev", "next", "next"};
//        //answer="06:55"
        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};
        //answer="04:17"
        String answer = solution(video_len, pos, op_start, op_end, commands);
        System.out.println(answer);
    }

    public static String solution(String videoLen, String pos, String opStart, String opEnd, String[] commands) {
        String answer;
        int videoLenTemp = transFunc(videoLen);
        int posTemp = transFunc(pos);
        int opStartTemp = transFunc(opStart);
        int opEndTemp = transFunc(opEnd);

        int current = posTemp;
        if (opStartTemp <= current && opEndTemp >= current) {
            current = opEndTemp;
        }
        for (String command : commands) {
            if ("prev".equals(command)) {
                current = Math.max(current - 10, 0);
            }
            if ("next".equals(command)) {
                current = Math.min(current + 10, videoLenTemp);
            }

            if (opStartTemp <= current && opEndTemp >= current) {
                current = opEndTemp;
            }
        }

        String min = String.format("%02d", current / 60);
        String sec = String.format("%02d", current % 60);
        answer = min + ":" + sec;
        return answer;
    }

    private static int transFunc(String time) {
        int answer;
        int min = Integer.parseInt(time.substring(0, 2));
        int sec = Integer.parseInt(time.substring(3, 5));
        answer = min * 60 + sec;
        return answer;
    }
}
