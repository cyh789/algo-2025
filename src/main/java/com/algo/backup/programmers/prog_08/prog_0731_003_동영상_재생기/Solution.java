package com.algo.backup.programmers.prog_08.prog_0731_003_동영상_재생기;

//동영상 재생기
public class Solution {
    public static void main(String[] args) {
//        String video_len = "34:33";
//        String pos = "13:00";
//        String op_start = "00:55";
//        String op_end = "02:55";
//        String[] commands = {"next", "prev"};
//        //answer="13:00"
        String video_len = "10:55";
        String pos = "00:05";
        String op_start = "00:15";
        String op_end = "06:55";
        String[] commands = {"prev", "next", "next"};
        //answer="06:55"
//        String video_len = "07:22";
//        String pos = "04:05";
//        String op_start = "00:15";
//        String op_end = "04:07";
//        String[] commands = {"next"};
//        //answer="04:17"
        String answer = solution(video_len, pos, op_start, op_end, commands);
        System.out.println(answer);
    }

    public static String solution(String videoLen, String pos, String opStart, String opEnd, String[] commands) {

        int videoLenTemp = transFunc(videoLen);
        int posTemp = transFunc(pos);
        int opStartTemp = transFunc(opStart);
        int opEndTemp = transFunc(opEnd);

        int current = posTemp;
        //오프닝 건너뛰기
        if (current >= opStartTemp && current <= opEndTemp) current = opEndTemp;

        for (String command : commands) {

            if ("prev".equals(command)) {
                if (current - 10 < 0) {
                    current = 0;
                } else {
                    current -= 10;
                }
            }
            if ("next".equals(command)) {
                if (current + 10 > videoLenTemp) {
                    current = videoLenTemp;
                } else {
                    current += 10;
                }
            }

            //오프닝 건너뛰기
            if (current >= opStartTemp && current <= opEndTemp) current = opEndTemp;
        }

        return String.format("%02d", current / 60)
                + ":"
                + String.format("%02d", current % 60);
    }

    private static int transFunc(String videoLen) {
        String min = videoLen.substring(0, 2);
        String sec = videoLen.substring(3, 5);

        return Integer.parseInt(min) * 60
                + Integer.parseInt(sec);
    }
}
