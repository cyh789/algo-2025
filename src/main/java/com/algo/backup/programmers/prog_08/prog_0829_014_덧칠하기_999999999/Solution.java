package com.algo.backup.programmers.prog_08.prog_0829_014_덧칠하기_999999999;

//덧칠하기
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int maxIndex = 3;
        int index = 0;
        int[] n = new int[maxIndex];
        n[index++] = 8;
        n[index++] = 5;
        n[index++] = 4;
        index = 0;
        int[] m = new int[maxIndex];
        m[index++] = 4;
        m[index++] = 4;
        m[index++] = 1;
        index = 0;
        int[][] section = new int[maxIndex][];
        section[index++] = new int[]{2, 3, 6}   ;
        section[index++] = new int[]{1, 3}      ;
        section[index++] = new int[]{1, 2, 3, 4};
        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], section[i]);
            System.out.println(answer);
            System.out.println("==========");
        }
        //2
        //1
        //4
    }

    //페인트가 칠해진 길이가 n미터인 벽
    //벽을 1미터 길이의 구역 n개로 나누고,
    //각 구역에 왼쪽부터 순서대로 1번부터 n번까지 번호
    //페인트를 다시 칠해야 할 구역들을 정했습니다.

    //벽에 페인트를 칠하는 롤러의 길이는 m미터
    //롤러로 벽에 페인트를 한 번 칠하는 규칙은 다음과 같습니다.
    //  한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만
    //  롤러가 벽에서 벗어나면 안 됩니다.
    //  구역의 일부분만 포함되도록 칠하면 안 됩니다.

    //다시 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열 section

    //롤러로 페인트칠을 하는 횟수를 최소화하려고 합니다.
    //롤러로 페인트칠해야 하는 최소 횟수를 return
    public static int solution(int n, int m, int[] section) {

        int end = section[0] + m - 1;

        int count = 1;
        for (int i = 1; i < section.length; i++) {
            int selected = section[i];
            int length = m - 1;

            if (end < selected) {
                end = selected + length;
                count++;
            }
        }

        return count;
    }
}
