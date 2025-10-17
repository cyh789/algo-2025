package com.algo.programmers.prog_1016_dfsBfs_004_단어_변환;

public class Solution_dfs {

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
        cnt = 0;
        answer = Integer.MAX_VALUE;
        boolean[] visited = new boolean[words.length];
        String currStr = begin;
        int idx = 0;
        int cnt = 0;
        dfs(currStr, target, visited, words, idx, cnt);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static void dfs(String currStr, String target, boolean[] visited, String[] words, int idx, int cnt) {
        if (currStr.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (idx == words.length) return;

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            String nextStr = words[i];
            if (!chkFunc(currStr, nextStr)) continue;

            visited[i] = true;
            dfs(nextStr, target, visited, words, i, cnt + 1);
            visited[i] = false;
        }
    }

    private static boolean chkFunc(String currStr, String nextStr) {
        int cnt = 0;
        for (int i = 0; i < currStr.length(); i++) {
            if (currStr.charAt(i) == nextStr.charAt(i)) cnt++;
        }
        return cnt == currStr.length() - 1;
    }

    static int answer;
    static int cnt;

}