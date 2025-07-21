package com.algo.programmers.prog_0721_006_크기가작은부분문자열;

//크기가작은부분문자열
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = "3141592";
        n[index++] = "500220839878";
        n[index++] = "10203";
        index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "271";
        m[index++] = "7";
        m[index++] = "15";

        for (int i = 0; i < arrIndex; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //8
        //3
    }
    public static int solution(String t, String p) {
        int totalSize = t.length();
        int size = p.length();

        int count = 0;
        for (int i = 0; i <= totalSize - size; i++) {
            String current = t.substring(i, i + size);
            //System.out.println(current);
            if (Long.parseLong(current) <= Long.parseLong(p)) {
                count++;
            }
        }

        return count;
    }
}
