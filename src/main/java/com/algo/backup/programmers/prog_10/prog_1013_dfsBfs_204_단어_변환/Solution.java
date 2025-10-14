package com.algo.backup.programmers.prog_10.prog_1013_dfsBfs_204_단어_변환;

import java.util.ArrayList;
import java.util.LinkedList;
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
        return bfs(begin, target, words);
    }

    private static int bfs(String begin, String target, String[] words) {
        Queue<Object> queue = new LinkedList<>();
        int cnt = 0;
        ArrayList<Object> list = new ArrayList<>();
        list.add(begin);
        list.add(cnt);
        queue.add(list);

        boolean[] visited = new boolean[words.length];
        while (!queue.isEmpty()) {
            ArrayList<Object> curr = (ArrayList<Object>) queue.poll();
            String currStr = (String) curr.get(0);
            int currCnt = (int) curr.get(1);

            if (currStr.equals(target)) {
                System.out.println("@@@ 도착 @@@ currStr=" + currStr + " / currCnt=" + currCnt);
                return currCnt;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;

                ArrayList<Object> next = new ArrayList<>();
                String nextStr = words[i];
                if (!chkFunc(currStr, nextStr)) continue;

                visited[i] = true;

                next.add(nextStr);
                next.add(currCnt + 1);
                queue.add(next);
            }
        }

        return cnt;
    }

    private static boolean chkFunc(String currStr, String nextStr) {
        int nextCnt = 0;
        for (int i = 0; i < currStr.length(); i++) {
            if (currStr.charAt(i) == nextStr.charAt(i)) nextCnt++;
        }

        return currStr.length() == nextCnt + 1;
    }

}
