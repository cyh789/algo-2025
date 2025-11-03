package com.algo.backup.programmers.prog_11.prog_20251103_real_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_1 {

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

        boolean[][] visited = new boolean[2][10];
        String[] youArr = new String[2];
        String[] rivalArr = new String[2];
        String[] s1Arr = new String[2];

        chkFunc(you, visited, youArr);
        chkFunc(rival, visited, rivalArr);
        chkFunc(s1, visited, s1Arr);

        for (int i = 1; i < 10; i++) {
            //black
            if (!visited[0][i]) {
                visited[0][i] = true;
                String s2 = i + "b";
                String[] youTotal = new String[]{you, s1, s2};
                String[] rivalTotal = new String[]{rival, s1, s2};

                if (calcFunc(youTotal) > calcFunc(rivalTotal)) result.add(s2);
                else if (calcFunc(youTotal) == calcFunc(rivalTotal)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) result.add(s2);
                    else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && rivalArr[1].equals("b")) result.add(s2);
                    }
                }
            }

            //red
            if (!visited[1][i]) {
                visited[1][i] = true;
                String s2 = i + "r";
                String[] youTotal = new String[]{you, s1, s2};
                String[] rivalTotal = new String[]{rival, s1, s2};

                if (calcFunc(youTotal) > calcFunc(rivalTotal)) result.add(s2);
                else if (calcFunc(youTotal) == calcFunc(rivalTotal)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) result.add(s2);
                    else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && rivalArr[1].equals("b")) result.add(s2);
                    }
                }
            }
        }

        if (result.isEmpty()) return new String[]{"lose"};

        return result.toArray(new String[0]);
    }

    private static int calcFunc(String[] youTotal) {
        String you = youTotal[0];
        int youCardNum = Integer.parseInt(you.substring(0, 1));
        String youType = you.substring(1);

        String s1 = youTotal[1];
        int s1CardNum = Integer.parseInt(s1.substring(0, 1));
        String s1Type = s1.substring(1);

        String s2 = youTotal[2];
        int s2CardNum = Integer.parseInt(s2.substring(0, 1));
        String s2Type = s2.substring(1);

        //pair
        if (youCardNum == s1CardNum || youCardNum == s2CardNum) {
            return 10;
        }

        //straight
        if (chkStraight(youCardNum, s1CardNum, s2CardNum)) {
            //straight flush
            if (youType.equals(s1Type) && youType.equals(s2Type)) {
                return 1000;
            }

            return 100;
        }

        //top
        return 1;
    }

    private static boolean chkStraight(int youCardNum, int s1CardNum, int s2CardNum) {
        int[] temp = new int[]{youCardNum, s1CardNum, s2CardNum};
        Arrays.sort(temp);
        if (temp[1] - temp[0] == 1 && temp[2] - temp[1] == 1) {
            return true;
        }
        return false;
    }

    private static void chkFunc(String you, boolean[][] visited, String[] youArr) {
        int youCardNum = Integer.parseInt(you.substring(0, 1));
        String youType = you.substring(1);

        if (youType.equals("b")) visited[0][youCardNum] = true;
        else visited[1][youCardNum] = true;

        youArr[0] = String.valueOf(youCardNum);
        youArr[1] = youType;
    }
}
