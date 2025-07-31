package com.algo.backup.programmers.prog_07.prog_0722_002_문자열나누기;

import java.util.ArrayList;
import java.util.List;

//문자열나누기
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "banana";
        m[index++] = "abracadabra";
        m[index++] = "aaabbaccccabba";
        index = 0;

        for (int i = 0; i < m.length; i++) {
            int answer = solution(m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //3
        //6
        //3
    }

    public static int solution(String s) {
        int answer = 0;
        //"banana";
        //"abracadabra";
        //"aaabbaccccabba";

        char[] c = s.toCharArray();
        String sum = "";
        String selected = "";
        boolean stop = true;
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (stop) {
                selected = String.valueOf(c[i]);
                count = 1;
                stop = false;
                sum = selected;

                if (i == c.length - 1) {
                    list.add(sum);
                }
                continue;
            }

            if (selected.equals(String.valueOf(c[i]))) {
                count++;
            } else {
                count--;
            }
            sum += String.valueOf(c[i]);

            if (i == c.length - 1) {
                list.add(sum);
            } else if (count == 0) {
                stop = true;
                list.add(sum);
            }
        }

        System.out.println(list.toString());

        return list.size();
    }
}
