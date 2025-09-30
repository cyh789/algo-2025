package com.algo.backup.programmers.prog_09.prog_0926_queueNstack_001_같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1,1,3,3,0,1,1}	;
        n[index++] = new int[]{4,4,4,3,3}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //1,3,0,1
        //4,3
    }

    //배열 arr가 주어집니다.
    // 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
    // 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
    // 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
    //
    //arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
    //arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
    //배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
    //
    //제한사항
    //배열 arr의 크기 : 1,000,000 이하의 자연수
    //배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    public static int[] solution(int[] arr) {
        int curr = Integer.MAX_VALUE;
        List<Integer> answer = new ArrayList<>();
        for (int next : arr) {
            if (curr != next) {
                curr = next;
                answer.add(curr);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}