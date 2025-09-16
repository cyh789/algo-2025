package com.algo.backup.programmers.prog_09.prog_0912_graph_003_소수_찾기;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = new String("17");
        n[index++] = new String("011");

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //3
        //2
    }

    //한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
    // 흩어진 종이 조각을 붙여
    // 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    //
    //각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
    // 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //numbers는 길이 1 이상 7 이하인 문자열입니다.
    //numbers는 0~9까지 숫자만으로 이루어져 있습니다.
    //"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

    //입출력 예
    //numbers	return
    //"17"	    3
    //"011"	    2

    //입출력 예 설명
    //예제 #1
    //[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
    //
    //예제 #2
    //[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
    //
    //11과 011은 같은 숫자로 취급합니다.
    public static int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        int depth = 0;
        String start = "";
        dfs(numbers, start, depth, visited, set);

        System.out.println(set.toString());

        int count = 0;
        for (int i : set) {
            if (chkFunc(i)) count++;
        }

        return count;
    }

    private static void dfs(String numbers, String start, int depth, boolean[] visited, Set<Integer> set) {
        if (depth >= numbers.length()) return;

        char[] numbersTemp = numbers.toCharArray();
        for (int i = 0; i < numbersTemp.length; i++) {
            char selected = numbersTemp[i];

            if (visited[i]) continue;

            visited[i] = true;
            set.add(Integer.parseInt(start + selected));
            dfs(numbers, start + selected, i, visited, set);
            visited[i] = false;
        }
    }

    private static boolean chkFunc(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
