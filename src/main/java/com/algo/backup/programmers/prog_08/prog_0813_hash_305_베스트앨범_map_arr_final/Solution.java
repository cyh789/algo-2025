package com.algo.backup.programmers.prog_08.prog_0813_hash_305_베스트앨범_map_arr_final;

import java.util.*;

@SuppressWarnings("UnusedAssignment")
class Solution {
    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"classic", "pop", "classic", "classic", "pop"}	;
        index = 0;

        int[][] m = new int[arrIndex][];
        m[index++] = new int[]{500, 600, 150, 800, 2500}	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], m[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //4, 1, 3, 0
        //
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<int[]>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];

            List<int[]> music = new ArrayList<>();
            if (musicMap.containsKey(name)) music = musicMap.get(name);
            music.add(new int[]{i, count});
            musicMap.put(name, music);

            genreMap.put(name, genreMap.getOrDefault(name, 0) + count);
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        List<Integer> answer = new ArrayList<>();
        for (String name : genreList) {
            List<int[]> musicList = musicMap.get(name);
            musicList.sort((o1, o2) -> o2[1] - o1[1]);

            answer.add(musicList.get(0)[0]);
            if (musicList.size() >= 2) answer.add(musicList.get(1)[0]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}