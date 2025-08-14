package com.algo.backup.programmers.prog_08.prog_0813_hash_105_베스트앨범_map_class;

import java.util.*;

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
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];
            genreMap.put(name, genreMap.getOrDefault(name, 0) + count);
        }

        List<String> genreList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genreMap.get(o2) - genreMap.get(o1);
            }
        });


        Map<String, List<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];
            if (!musicMap.containsKey(name)) {
                List<Music> musicList = new ArrayList<>();
                musicList.add(new Music(i, count));
                musicMap.put(name, musicList);
            } else {
                List<Music> musicList = musicMap.get(name);
                musicList.add(new Music(i, count));
                musicMap.put(name, musicList);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (String name : genreList) {
            List<Music> musicList = musicMap.get(name);
            Collections.sort(musicList, new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    return o2.count - o1.count;
                }
            });

            answer.add(musicList.get(0).index);
            if (musicList.size() >= 2) answer.add(musicList.get(1).index);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    static class Music {
        private int index;
        private int count;

        public Music(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}