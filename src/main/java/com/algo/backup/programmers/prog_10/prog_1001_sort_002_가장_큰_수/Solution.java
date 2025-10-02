package com.algo.backup.programmers.prog_10.prog_1001_sort_002_가장_큰_수;

import java.util.Arrays;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 4;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{6, 10, 2};
        n[index++] = new int[]{3, 30, 34, 5, 9};
        n[index++] = new int[]{1, 1, 2, 2};
        n[index++] = new int[]{0, 0, 0};
        index = 0;

        for (int[] ints : n) {
            String answer = solution(ints);
            System.out.println(answer);
            System.out.println("=============");
        }
        //6210
        //9534330
    }

    //0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
    //
    //예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
    //
    //0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
    //
    //제한 사항
    //numbers의 길이는 1 이상 100,000 이하입니다.
    //numbers의 원소는 0 이상 1,000 이하입니다.
    //정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
    //입출력 예
    //numbers	return
    //[6, 10, 2]	"6210"
    //[3, 30, 34, 5, 9]	"9534330"
//    public static String solution(int[] numbers) {
//        boolean[] visited = new boolean[numbers.length];
//        String curr = "";
//        int depth = 0;
//        maxNum = 0;
//        dfs(numbers, curr, depth, visited);
//
//        return String.valueOf(maxNum);
//    }
//    static int maxNum;
//
//    private static void dfs(int[] numbers, String curr, int depth, boolean[] visited) {
//        if (depth == numbers.length) {
//            //System.out.println(curr);
//            maxNum = Math.max(Integer.valueOf(curr), maxNum);
//            return;
//        }
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (visited[i]) continue;
//
//            String next = curr + String.valueOf(numbers[i]);
//            visited[i] = true;
//            dfs(numbers, next, depth + 1, visited);
//            visited[i] = false;
//        }
//    }
    public static String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }
//        System.out.println(Arrays.toString(temp));
//        Arrays.sort(temp, (o1, o2) -> o2.compareTo(o1));
//        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
//        System.out.println(Arrays.toString(temp));

        if (temp[0].equals("0")) return "0";

        String sum = "";
        for (String s : temp) {
            sum += s;
        }

        return sum;
    }
}
