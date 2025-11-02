package com.algo.programmers.prog_20251102_real_1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"7b", "6r", "6b"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //
    }

    public static String[] solution(String[] cards) {
        List<String> result = new ArrayList<>();
        String you = cards[0];
        String rival = cards[1];
        String s1 = cards[2];

        boolean[][] visited = new boolean[2][10];
        String[] youArr = new String[2];
        String[] rivalArr = new String[2];
        String[] s1Arr = new String[2];

        chkType(you, visited, youArr);
        chkType(rival, visited, rivalArr);
        chkType(s1, visited, s1Arr);

        for (int i = 1; i < 10; i++) {
            //black
            if (!visited[0][i]) {
                String currS2 = i + "b";
                String[] youTotal = new String[]{you, s1, currS2};
                String[] rivalTotal = new String[]{rival, s1, currS2};

                //System.out.println(currS2);

                if (chkFunc(youTotal) > chkFunc(rivalTotal)) result.add(currS2);
                else if (chkFunc(youTotal) == chkFunc(rivalTotal)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) result.add(currS2);
                    else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && rivalArr[1].equals("b")) result.add(currS2);
                    }
                }
            }

            //red
            if (!visited[1][i]) {
                String currS2 = i + "r";
                String[] youTotal = new String[]{you, s1, currS2};
                String[] rivalTotal = new String[]{rival, s1, currS2};

                //System.out.println(currS2);

                if (chkFunc(youTotal) > chkFunc(rivalTotal)) result.add(currS2);
                else if (chkFunc(youTotal) == chkFunc(rivalTotal)) {
                    if (Integer.parseInt(youArr[0]) > Integer.parseInt(rivalArr[0])) result.add(currS2);
                    else if (Integer.parseInt(youArr[0]) == Integer.parseInt(rivalArr[0])) {
                        if (youArr[1].equals("r") && rivalArr[1].equals("b")) result.add(currS2);
                    }
                }
            }
        }

        if (result.isEmpty()) return new String[]{"lose"};

        return result.toArray(new String[0]);
    }

    private static void chkType(String you, boolean[][] visited, String[] youArr) {
        int youCardNum = Integer.parseInt(you.substring(0, 1));
        String youType = you.substring(1);

        if (youType.equals("b")) visited[0][youCardNum] = true;
        else visited[1][youCardNum] = true;

        youArr[0] = String.valueOf(youCardNum);
        youArr[1] = youType;
    }

    private static int chkFunc(String[] arr) {
        int score = 1;

        String you = arr[0];
        int youCardNum = Integer.valueOf(you.substring(0, 1));
        String youType = you.substring(1);

        String s1 = arr[1];
        int s1CardNum = Integer.valueOf(s1.substring(0, 1));
        String s1Type = s1.substring(1);

        String s2 = arr[2];
        int s2CardNum = Integer.valueOf(s2.substring(0, 1));
        String s2Type = s2.substring(1);

        //pair
        if (youCardNum == s1CardNum || youCardNum == s2CardNum) {
            return 10;
        }

        int[] temp = new int[]{youCardNum, s1CardNum, s2CardNum};
        Arrays.sort(temp);
        //straight
        if (temp[2] - temp[1] == 1 && temp[1] - temp[0] == 1) {
            //straight flush
            if (youType.equals(s1Type) && youType.equals(s2Type)) return 1000;
            return 100;
        }

        //top
        return score;
    }
}
