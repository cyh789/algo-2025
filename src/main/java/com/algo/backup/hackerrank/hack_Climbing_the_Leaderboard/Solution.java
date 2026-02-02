package com.algo.backup.hackerrank.hack_Climbing_the_Leaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        Map<Integer, Integer> map = new HashMap<>(); //int score, int rank

        int idx = 1;
        for (int i = 0; i < ranked.size(); i++) {
            if (map.containsKey(ranked.get(i))) continue;
            map.put(ranked.get(i), map.getOrDefault(ranked.get(i), idx));
            idx++;
        }
        //System.out.println("map=" + map);


        //player가 더 크면 덮어쓰고 => 1위는 덮어쓰고
        //player와 ranked가 동일하면 skip
        //player가 더 작으면 player를 추가  => + 그 다음 순위들 전부 없앰
        List<Integer> rankedTemp = new ArrayList<>(ranked);
        Collections.sort(rankedTemp, Collections.reverseOrder());
        //System.out.println("rankedTemp=" + rankedTemp);

        int rankIdx = 0;
        boolean remove = true;


        List<Integer> playerTemp = new ArrayList<>(player);
        Collections.sort(playerTemp, Collections.reverseOrder());
        //System.out.println("playerTemp=" + playerTemp);

        for (int i = 0; i < playerTemp.size(); i++) {
            if (map.containsKey(playerTemp.get(i))) continue;
            else {
                if (playerTemp.get(i) > rankedTemp.get(rankIdx)) {
                    rankedTemp.remove(rankIdx);
                    rankedTemp.add(playerTemp.get(i));
                    rankIdx++;
                    Collections.sort(rankedTemp, Collections.reverseOrder());
                } else {
                    if (remove) {
                        for (int j = rankedTemp.size() - 1; j >= 0; j--) {
                            if (rankedTemp.get(j) < playerTemp.get(i)) {
                                rankedTemp.remove(j);
                            }

                        }
                        remove = false;
                    }

                    rankedTemp.add(playerTemp.get(i));
                }
            }
        }

        Collections.sort(rankedTemp, Collections.reverseOrder());
        //System.out.println("rankedTemp=" + rankedTemp);

        Map<Integer, Integer> resultMap = new HashMap<>(); //int score, int rank
        int rank = 1;
        for (int i = 0; i < rankedTemp.size(); i++) {
            if (resultMap.containsKey(rankedTemp.get(i))) continue;
            resultMap.put(rankedTemp.get(i), rank);
            rank++;
        }
        //System.out.println("result=" + resultMap);

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < player.size(); i++) {
            resultList.add(resultMap.get(player.get(i)));
        }

        return resultList;


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

//        List<Integer> ranked = List.of(100, 90, 90, 80);
//        List<Integer> player = List.of(70, 80, 105);
//        List<Integer> ranked = List.of(100,90,90,80,75,60);
//        List<Integer> player = List.of(50,65,77,90,102);
        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        System.out.println(result);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
