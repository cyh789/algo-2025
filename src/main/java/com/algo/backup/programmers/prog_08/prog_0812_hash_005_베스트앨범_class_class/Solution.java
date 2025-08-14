package com.algo.backup.programmers.prog_08.prog_0812_hash_005_베스트앨범_class_class;

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
        Map<String, Genre> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            genreMap.putIfAbsent(name, new Genre(name));
            genreMap.get(name).addMusicCount(new Music(name, i, plays[i]));
        }

        List<Genre> genreList = new ArrayList<>(genreMap.values());
        genreList.sort((a, b ) -> b.totalCount - a.totalCount);

        List<Integer> result = new ArrayList<>();
        for (Genre genre : genreList) {
            for (Music music : genre.getTopMusics()) {
                result.add(music.index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Music {
        private String genre;
        private int index;
        private int count;

        public Music(String genre, int index, int count) {
            this.genre = genre;
            this.index = index;
            this.count = count;
        }
    }

    static class Genre {
        private String name;
        private int totalCount;
        private List<Music> musics;

        public Genre(String name) {
            this.name = name;
            this.totalCount = 0;
            this.musics = new ArrayList<>();
        }

        public void addMusicCount(Music music) {
            musics.add(music);
            totalCount += music.count;
        }

        public List<Music> getTopMusics() {
            musics.sort((a, b) -> b.count - a.count);
            return musics.subList(0, Math.min(2, musics.size()));
        }
    }
}