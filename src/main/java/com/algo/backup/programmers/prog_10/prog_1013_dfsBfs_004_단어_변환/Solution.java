package com.algo.backup.programmers.prog_10.prog_1013_dfsBfs_004_단어_변환;

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
        minCnt = Integer.MAX_VALUE;
        int cnt = 0;
        boolean[] visited = new boolean[words.length];
        String curr = begin;
        dfs(target, words, curr, visited, cnt);

        return minCnt == Integer.MAX_VALUE ? 0 : minCnt;
    }
    static int minCnt;

    private static void dfs(String target, String[] words, String curr, boolean[] visited, int cnt) {
        if (minCnt <= cnt) return;

        if (curr.equals(target)) {
            //System.out.println("@@@ 도착 @@@ curr=" + curr + " / cnt=" + cnt + " / minCnt=" + minCnt);
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            if (!chkFunc(curr, words[i])) continue;
            String next = words[i];
            //System.out.println("이동 curr=" + curr + " / next=" + next + " / cnt=" + cnt);

            visited[i] = true;
            dfs(target, words, next, visited, cnt + 1);
            visited[i] = false;
        }

    }

    private static boolean chkFunc(String curr, String next) {
        int nextCnt = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) == next.charAt(i)) nextCnt++;
        }

        return nextCnt == curr.length() - 1;
    }

}
