package com.algo.backup.programmers.prog_11.prog_1123_sort_002_가장_큰_수;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

@SuppressWarnings("UnusedAssignment")
public class Solution_1_bfs_memory_over {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{6, 10, 2};
        n[index++] = new int[]{3, 30, 34, 5, 9};
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
    public static String solution(int[] numbers) {
        Deque<Node> q = new ArrayDeque<>();
        int number = 0;
        int depth = 0;
        boolean[] visited = new boolean[numbers.length];
        q.add(new Node(number, depth, visited));

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currNum = curr.number;
            int currDepth = curr.depth;
            boolean[] currVisited = curr.visited;

            if (currDepth == numbers.length) {
                //System.out.println(curr.toString());
                max = Math.max(max, currNum);
            }

            for (int i = 0; i < numbers.length; i++) {
                String nextStr = String.valueOf(currNum) + numbers[i];
                int next = Integer.parseInt(nextStr);

                if (currVisited[i]) continue;

                boolean[] nextVisited = Arrays.copyOf(currVisited, numbers.length);
                nextVisited[i] = true;

                q.add(new Node(next, currDepth + 1, nextVisited));
            }
        }

        return String.valueOf(max);
    }

    private static final class Node {
        private final int number;
        private final int depth;
        private final boolean[] visited;

        private Node(int number, int depth, boolean[] visited) {
            this.number = number;
            this.depth = depth;
            this.visited = visited;
        }

        public int number() {
            return number;
        }

        public int depth() {
            return depth;
        }

        public boolean[] visited() {
            return visited;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Node) obj;
            return this.number == that.number &&
                    this.depth == that.depth &&
                    Objects.equals(this.visited, that.visited);
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, depth, visited);
        }

        @Override
        public String toString() {
            return "Node[" +
                    "number=" + number + ", " +
                    "depth=" + depth + ", " +
                    "visited=" + visited + ']';
        }

    }
}
