package com.algo.backup.programmers.prog_10.prog_1010_dfsBfs_104_단어_변환;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Solution {

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

    public static int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words, 0);
    }

    private static int bfs(String begin, String target, String[] words, int cnt) {
        boolean[] visited = new boolean[words.length];

        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, cnt));

        while (!queue.isEmpty()) {
            Word curr = queue.poll();
            String currStr = curr.begin;
            int currCnt = curr.cnt;

            if (target.equals(currStr)) {
                System.out.println("@@@ 도착 @@@ currStr=" + currStr + " / currCnt=" + currCnt);
                return currCnt;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                String nextStr = words[i];
                if (!chkFunc(currStr, nextStr)) continue;

                visited[i] = true;
                queue.add(new Word(nextStr, currCnt + 1));
            }
        }

        return 0;
    }

    private static boolean chkFunc(String currStr, String nextStr) {
        int cnt = 0;
        for (int i = 0; i < currStr.length(); i++) {
            if (currStr.charAt(i) == nextStr.charAt(i)) cnt++;
        }

        return currStr.length() == cnt + 1;
    }

    static final class Word {
        private final String begin;
        private final int cnt;

        Word(String begin, int cnt) {
            this.begin = begin;
            this.cnt = cnt;
        }
   }

}
