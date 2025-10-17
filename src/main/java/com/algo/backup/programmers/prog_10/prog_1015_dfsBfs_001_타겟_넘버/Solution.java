package com.algo.backup.programmers.prog_10.prog_1015_dfsBfs_001_타겟_넘버;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{1, 1, 1, 1, 1};
        n[index++] = new int[]{4, 1, 2, 1};
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 3;
        m[index++] = 4;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //5
        //2
    }

    //n개의 음이 아닌 정수들이 있습니다.
    // 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.

    // 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
    //-1+1+1+1+1 = 3
    //+1-1+1+1+1 = 3
    //+1+1-1+1+1 = 3
    //+1+1+1-1+1 = 3
    //+1+1+1+1-1 = 3

    //사용할 수 있는 숫자가 담긴 배열 numbers,
    // 타겟 넘버 target이 매개변수로 주어질 때
    // 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
    //각 숫자는 1 이상 50 이하인 자연수입니다.
    //타겟 넘버는 1 이상 1000 이하인 자연수입니다.
    //입출력 예
    //numbers	        target	return
    //[1, 1, 1, 1, 1]	3	    5
    //[4, 1, 2, 1]	    4	    2

    //입출력 예 설명

    //입출력 예 #1
    //문제 예시와 같습니다.
    //
    // 입출력 예 #2
    //+4+1-2+1 = 4
    //+4-1+2-1 = 4
    //총 2가지 방법이 있으므로, 2를 return 합니다.

    public static int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }

    private static int bfs(int[] numbers, int target) {
        Queue<Node> queue = new LinkedList<>();
        int sum = 0;
        int depth = 0;
        queue.add(new Node(sum, depth));

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.depth == numbers.length) {
                if (curr.sum == target) cnt++;
                continue;
            }

            queue.add(new Node(curr.sum + numbers[curr.depth], curr.depth + 1));
            queue.add(new Node(curr.sum - numbers[curr.depth], curr.depth + 1));
        }

        return cnt;
    }

    private static class Node {
        private final int sum;
        private final int depth;

        public Node(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }
    }
}