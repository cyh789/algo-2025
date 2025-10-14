package com.algo.backup.programmers.prog_10.prog_1010_dfsBfs_004_단어_변환;

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
        boolean[] visited = new boolean[words.length];
        String curr = begin;
        int cnt = 0;
        minCnt = Integer.MAX_VALUE;
        dfs(words, curr, target, visited, cnt);

        return minCnt == Integer.MAX_VALUE ? 0 : minCnt;
    }
    static int minCnt;

    private static void dfs(String[] words, String curr, String target, boolean[] visited, int cnt) {
        if (target.equals(curr)) {
            System.out.println("@@@ 도착 @@@ curr=" + curr + " / cnt=" + cnt + " / minCnt=" + minCnt);
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            String next = words[i];
            if (!chkFunc(curr, next)) continue;

            visited[i] = true;
            dfs(words, next, target, visited, cnt + 1);
            visited[i] = false;
        }
    }

    /**
     * from 문자열에서 to 문자열로의 변환이 가능한지 여부를 반환하는 메서드
     */
    private static boolean chkFunc(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == to.charAt(i)) cnt++;
        }

        return from.length() == cnt + 1;
    }

}
