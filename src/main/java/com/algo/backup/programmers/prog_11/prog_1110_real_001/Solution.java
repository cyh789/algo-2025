package com.algo.backup.programmers.prog_11.prog_1110_real_001;

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
        String[] youArr = new String[3];
        String[] rivalArr = new String[3];
        String[] s1Arr = new String[3];

        youArr[0] = cards[0];
        rivalArr[0] = cards[1];
        s1Arr[0] = cards[2];

        boolean[][] visited = new boolean[2][10];
        chkFunc(visited, youArr);
        chkFunc(visited, rivalArr);
        chkFunc(visited, s1Arr);

        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            //black
            if (!visited[0][i]) {
                String s2 = i + "b";
                String[] s2Arr = new String[]{s2, String.valueOf(i), "b"};

                if (calcFunc(youArr, s1Arr, s2Arr) > calcFunc(rivalArr, s1Arr, s2Arr)) {
                    result.add(s2);
                } else if (calcFunc(youArr, s1Arr, s2Arr) == calcFunc(rivalArr, s1Arr, s2Arr)) {
                    if (Integer.parseInt(youArr[1]) > Integer.parseInt(rivalArr[1])) {
                        result.add(s2);
                    } else if (Integer.parseInt(youArr[1]) == Integer.parseInt(rivalArr[1])) {
                        if ("r".equals(youArr[2]) && "b".equals(rivalArr[2])) {
                            result.add(s2);
                        }
                    }
                }
            }

            //red
            if (!visited[1][i]) {
                String s2 = i + "r";
                String[] s2Arr = new String[]{s2, String.valueOf(i), "r"};

                if (calcFunc(youArr, s1Arr, s2Arr) > calcFunc(rivalArr, s1Arr, s2Arr)) {
                    result.add(s2);
                } else if (calcFunc(youArr, s1Arr, s2Arr) == calcFunc(rivalArr, s1Arr, s2Arr)) {
                    if (Integer.parseInt(youArr[1]) > Integer.parseInt(rivalArr[1])) {
                        result.add(s2);
                    } else if (Integer.parseInt(youArr[1]) == Integer.parseInt(rivalArr[1])) {
                        if ("r".equals(youArr[2]) && "b".equals(rivalArr[2])) {
                            result.add(s2);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) return new String[]{"lose"};

        return result.toArray(new String[0]);
    }

    private static int calcFunc(String[] youArr, String[] s1Arr, String[] s2Arr) {
        //pair
        if (Integer.parseInt(youArr[1]) == Integer.parseInt(s1Arr[1]) || Integer.parseInt(youArr[1]) == Integer.parseInt(s2Arr[1])) {
            return 10;
        }

        String[] temp = new String[]{youArr[1], s1Arr[1], s2Arr[1]};
        Arrays.sort(temp);
        //straight
        if (Integer.parseInt(temp[2]) - Integer.parseInt(temp[1]) == 1 && Integer.parseInt(temp[2]) - Integer.parseInt(temp[0]) == 2) {
            //straight flush
            if (youArr[2].equals(s1Arr[2]) && youArr[2].equals(s2Arr[2])) {
                return 1000;
            }

            return 100;
        }

        //top
        return 1;
    }

    private static void chkFunc(boolean[][] visited, String[] youArr) {
        String you = youArr[0];
        String youNum = you.substring(0, 1);
        String youType = you.substring(1);

        youArr[1] = youNum;
        youArr[2] = youType;

        if ("b".equals(youType)) visited[0][Integer.parseInt(youNum)] = true;
        else visited[1][Integer.parseInt(youNum)] = true;
    }
}
