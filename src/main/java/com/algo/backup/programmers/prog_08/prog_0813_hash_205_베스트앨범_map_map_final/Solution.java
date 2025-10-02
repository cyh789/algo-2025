package com.algo.backup.programmers.prog_08.prog_0813_hash_205_베스트앨범_map_map_final;

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
        Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];

            Map<Integer, Integer> music = new HashMap<>();
            if (musicMap.containsKey(name)) music = musicMap.get(name);
            music.put(i, count);
            musicMap.put(name, music);

            genreMap.put(name, genreMap.getOrDefault(name, 0) + count);
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        List<Integer> answer = new ArrayList<>();
        for (String name : genreList) {
            Map<Integer, Integer> music = musicMap.get(name);
            List<Integer> musicList = new ArrayList<>(music.keySet());
            musicList.sort((o1, o2) -> music.get(o2) - music.get(o1));

            answer.add(musicList.get(0));
            if (musicList.size() >= 2) answer.add(musicList.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}