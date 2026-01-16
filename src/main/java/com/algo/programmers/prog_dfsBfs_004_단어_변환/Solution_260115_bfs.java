package com.algo.programmers.prog_dfsBfs_004_단어_변환;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution_260115_bfs {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[] n = new String[arrIndex];
        n[index++] = "hit";
        n[index++] = "hit";
        index = 0;

        String[] m = new String[arrIndex];
        m[index++] = "cog";
        m[index++] = "cog";
        index = 0;

        String[][] l = new String[arrIndex][];
        l[index++] = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        l[index++] = new String[]{"hot", "dot", "dog", "lot", "log"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //4
        //0
    }

    //두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
    //
    //1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
    //2. words에 있는 단어로만 변환할 수 있습니다.
    //예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
    //
    //두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //각 단어는 알파벳 소문자로만 이루어져 있습니다.
    //각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
    //words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
    //begin과 target은 같지 않습니다.
    //변환할 수 없는 경우에는 0를 return 합니다.
    //입출력 예
    //begin	target	words	return
    //"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
    //"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
    //입출력 예 설명
    //예제 #1
    //문제에 나온 예와 같습니다.
    //
    //예제 #2
    //target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.

    public static int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Queue<Node> q = new LinkedList<>();
        int cnt = 0;
        String str = begin;
        q.add(new Node(cnt, str));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currCnt = curr.cnt;
            String currStr = curr.str;

            if (currStr.equals(target)) {
                return currCnt;
            }

            for (int i = 0; i < words.length; i++) {
                String nextStr = words[i];

                //단어체크
                if (!chkFunc(currStr, nextStr)) continue;
                if (visited[i]) continue;

                visited[i] = true;
                q.add(new Node(currCnt + 1, nextStr));
            }
        }


        return cnt;
    }

    private static boolean chkFunc(String currStr, String nextStr) {
        int diff = 0;
        for (int i = 0; i < currStr.length(); i++) {
            if (currStr.charAt(i) != nextStr.charAt(i)) diff++;
        }
        return diff == 1;
    }

    private static final class Node {
        private final int cnt;
        private final String str;

        private Node(int cnt, String str) {
            this.cnt = cnt;
            this.str = str;
        }

        public int cnt() {
            return cnt;
        }

        public String str() {
            return str;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Node) obj;
            return this.cnt == that.cnt &&
                    Objects.equals(this.str, that.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cnt, str);
        }

        @Override
        public String toString() {
            return "Node[" +
                    "cnt=" + cnt + ", " +
                    "str=" + str + ']';
        }

        }
}