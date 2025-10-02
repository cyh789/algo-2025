package com.algo.backup.programmers.prog_08.prog_0820_hash_005_베스트앨범_999999999;

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
    }

    public static int[] solution(String[] genres, int[] plays) {
        //스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
        // 노래는 고유 번호로 구분하며,
        // 노래를 수록하는 기준은 다음과 같습니다.
        //
        //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        //  ㄴ장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        //  ㄴ장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

        //노래의 장르를 나타내는 문자열 배열 genres와
        // 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
        // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
        //
        //제한사항
        //genres[i]는 고유번호가 i인 노래의 장르입니다.
        //plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
        //genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
        //장르 종류는 100개 미만입니다.
        //장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
        //모든 장르는 재생된 횟수가 다릅니다.

        Map<String, Integer> genreMap = new HashMap<>();    //String genre name, int total count
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];

            genreMap.put(name, genreMap.getOrDefault(name, 0) + count);
        }

        Map<String, List<int[]>> musicMap = new HashMap<>();    //String genre name, int[int music index, int music count]
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int count = plays[i];

            List<int[]> musicList = new ArrayList<>();
            if (musicMap.containsKey(name)) musicList = musicMap.get(name);
            musicList.add(new int[]{i, count});
            musicMap.put(name, musicList);
        }

        //정렬 -> String genre name 순으로만 나기면 됨. sort by int count
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        genreList.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));   //내림차순

        //정렬 -> int music index 순으로만 나기면 됨. sort by int music count
        //int[] 라서 fori 안에서 해야함
        List<Integer> ansewr = new ArrayList<>();
        for (String name : genreList) {
            List<int[]> musicList = musicMap.get(name);
            musicList.sort((o1, o2) -> o2[1] - o1[1]); //내림차순

            ansewr.add(musicList.get(0)[0]);    //int music index
            if (musicList.size() > 1) ansewr.add(musicList.get(1)[0]);    //int music index
        }
        return ansewr.stream().mapToInt(i -> i).toArray();
    }
}