package com.algo.backup.programmers.prog_07.prog_0723_005_숫자짝꿍;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 5;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = "100";
        n[index++] = "100";
        n[index++] = "100";
        n[index++] = "12321";
        n[index++] = "5525";
        index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "2345";
        m[index++] = "203045";
        m[index++] = "123450";
        m[index++] = "42531";
        m[index++] = "1255";
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"-1"
        //"0"
        //"10"
        //"321"
        //"552"
    }

    public static String solution(String X, String Y) {

        StringBuilder answer = new StringBuilder();
        int[] xCntArr = new int[10];
        int[] yCntArr = new int[10];
        char[] xArr = X.toCharArray();
        for (int i = 0; i < X.length(); i++) {
            xCntArr[Integer.parseInt(String.valueOf(xArr[i]))]++;
        }
        char[] yArr = Y.toCharArray();
        for (int i = 0; i < Y.length(); i++) {
            yCntArr[Integer.parseInt(String.valueOf(yArr[i]))]++;
        }

        for (int i = 9; i >= 0; i--) {
            while (xCntArr[i] > 0 && yCntArr[i] > 0) {
                answer.append(i);

                xCntArr[i]--;
                yCntArr[i]--;
            }
        }

        if (answer.toString().isEmpty()) return "-1";
        //if (answer.toString().matches("0+")) return "0";
        if ("".equals(answer.toString().replaceAll("0",""))) return "0";

        return String.valueOf(answer);
    }
}
