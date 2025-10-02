package com.algo.backup.programmers.prog_09.prog_0908_graph_002_모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1,2,3,4,5};
        n[index++] = new int[]{1,3,2,4,2};
        index = 0;

        for (int[] ints : n) {
            int[] answer = solution(ints);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //[1]
        //[1,2,3]
    }

    //수포자는 수학을 포기한 사람의 준말입니다.
    // 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
    // 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
    //
    //1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    //2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    //3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    //
    //1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    // 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    //제한 조건
    //시험은 최대 10,000 문제로 구성되어있습니다.
    //문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    //가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    //입출력 예
    //answers	return
    //[1,2,3,4,5]	[1]
    //[1,3,2,4,2]	[1,2,3]
    //입출력 예 설명
    //입출력 예 #1
    //수포자 1은 모든 문제를 맞혔습니다.
    //수포자 2는 모든 문제를 틀렸습니다.
    //수포자 3은 모든 문제를 틀렸습니다.
    //따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
    //
    //입출력 예 #2
    //모든 사람이 2문제씩을 맞췄습니다.
    public static int[] solution(int[] answers) {

        int[] arr = new int[3];
        List<Integer> answer = new ArrayList<>();

        int[] condition_1 = new int[]{1, 2, 3, 4, 5};
        int count_1 = 0;
        int idx_1 = 0;
        for (int k : answers) {
            if (idx_1 >= condition_1.length) idx_1 = 0;
            if (k == condition_1[idx_1]) {
                count_1++;
            }
            idx_1++;
        }
        arr[0] = count_1;


        int condition_2A = 2;
        int[] condition_2B = new int[]{1, 3, 4, 5};
        int count_2 = 0;
        int idx_2 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (idx_2 >= condition_2B.length) idx_2 = 0;
            //짝수
            if ((i+1) % 2 == 0) {
                if (answers[i] == condition_2B[idx_2]) {
                    count_2++;
                }
                idx_2++;
            } else {
                if (answers[i] == condition_2A) {
                    count_2++;
                }
            }
        }
        arr[1] = count_2;

        int[] condition_3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count_3 = 0;
        int idx_3 = 0;
        for (int j : answers) {
            if (idx_3 >= condition_3.length) idx_3 = 0;
            if (j == condition_3[idx_3]) {
                count_3++;
            }
            idx_3++;
        }
        arr[2] = count_3;

        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        if (max == arr[0]) answer.add(1);
        if (max == arr[1]) answer.add(2);
        if (max == arr[2]) answer.add(3);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
