package com.algo.backup.programmers.prog_11.prog_1107_real_001;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 6;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"7b", "6r", "6b"};
        n[index++] = new String[]{"6b", "7r", "7b"};
        n[index++] = new String[]{"1b", "4r", "3b"};
        n[index++] = new String[]{"9b", "9r", "7b"};
        n[index++] = new String[]{"1r", "9b", "9r"};
        n[index++] = new String[]{"9b", "1r", "9r"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //
    }

    public static String[] solution(String[] cards) {
        ArrayList<String> result = new ArrayList<>();

        String you = cards[0];
        String rival = cards[1];
        String s1 = cards[2];

        String[] youArr = new String[2];
        String[] rivalArr = new String[2];
        String[] s1Arr = new String[2];

        boolean[][] visited = new boolean[2][10];
        chkFunc(you, youArr, visited);
        chkFunc(rival, rivalArr, visited);
        chkFunc(s1, s1Arr, visited);

        for (int i = 1; i < 10; i++) {
            //black
            if (!visited[0][i]) {
                String s2 = i + "b";

                if (calFunc(youArr, s1Arr, s2) > calFunc(rivalArr, s1Arr, s2)) {
                    result.add(s2);
                } else if (calFunc(youArr, s1Arr, s2) == calFunc(rivalArr, s1Arr, s2)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) {
                        result.add(s2);
                    } else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && !rivalArr[1].equals("r")) {
                            result.add(s2);
                        }
                    }
                }
            }

            //red
            if (!visited[1][i]) {
                String s2 = i + "r";

                if (calFunc(youArr, s1Arr, s2) > calFunc(rivalArr, s1Arr, s2)) {
                    result.add(s2);
                } else if (calFunc(youArr, s1Arr, s2) == calFunc(rivalArr, s1Arr, s2)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) {
                        result.add(s2);
                    } else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && !rivalArr[1].equals("r")) {
                            result.add(s2);
                        }
                    }
                }

            }
        }

        if (result.isEmpty()) return new String[]{"lose"};

        return result.toArray(new String[0]);
    }

    private static int calFunc(String[] youArr, String[] s1Arr, String s2) {
        int youNum = Integer.parseInt(youArr[0]);
        String youType = youArr[1];
        int s1Num = Integer.parseInt(s1Arr[0]);
        String s1Type = s1Arr[1];
        int s2Num = Integer.parseInt(s2.substring(0, 1));
        String s2Type = s2.substring(1);

        //pair
        if (youNum == s1Num || youNum == s2Num) return 10;

        //straight
        int[] temp = new int[]{youNum, s1Num, s2Num};
        Arrays.sort(temp);

        if (temp[1] - temp[0] == 1 && temp[2] - temp[1] == 1) {
            //straight flush
            if (youType.equals(s1Type) || youType.equals(s2Type)) return 1000;
            return 100;
        }

        //top
        return 1;
    }

    private static void chkFunc(String you, String[] youArr, boolean[][] visited) {
        String num = you.substring(0, 1);
        String type = you.substring(1);

        youArr[0] = num;
        youArr[1] = type;

        if ("b".equals(type)) visited[0][Integer.parseInt(num)] = true;
        else visited[1][Integer.parseInt(num)] = true;
    }
}
