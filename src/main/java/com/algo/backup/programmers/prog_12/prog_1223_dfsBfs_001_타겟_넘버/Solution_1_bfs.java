package com.algo.backup.programmers.prog_12.prog_1223_dfsBfs_001_타겟_넘버;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution_1_bfs {

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
        Queue<Node> q = new LinkedList<>();
        int sum = 0;
        int depth = 0;
        String text = "";
        q.add(new Node(sum, depth, text));

        int result = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currSum = curr.sum;
            int currDepth = curr.depth;
            String currText = curr.text;

            if (currDepth == numbers.length) {
                if (currSum == target) {
                    //System.out.println(currText);
                    result++;
                }
                continue;
            }

            q.add(new Node(currSum + numbers[currDepth], currDepth + 1, currText + "+" + numbers[currDepth]));
            q.add(new Node(currSum - numbers[currDepth], currDepth + 1, currText + "-" + numbers[currDepth]));
        }

        return result;
    }

    private static final class Node {
        private final int sum;
        private final int depth;
        private final String text;

        private Node(int sum, int depth, String text) {
            this.sum = sum;
            this.depth = depth;
            this.text = text;
        }

        public int sum() {
            return sum;
        }

        public int depth() {
            return depth;
        }

        public String text() {
            return text;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Node) obj;
            return this.sum == that.sum &&
                    this.depth == that.depth &&
                    Objects.equals(this.text, that.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sum, depth, text);
        }

        @Override
        public String toString() {
            return "Node[" +
                    "sum=" + sum + ", " +
                    "depth=" + depth + ", " +
                    "text=" + text + ']';
        }

        }
}