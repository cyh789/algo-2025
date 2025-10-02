package com.algo.backup.programmers.prog_08.prog_0811_hash_004_의상;

import java.util.*;
import java.util.Map.Entry;

@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[][][] n = new String[arrIndex][][];
        n[index++] = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}	;
        n[index++] = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}	;
        index = 0;

        for (String[][] strings : n) {
            int answer = solution(strings);
            System.out.println(answer);
            System.out.println("=============");
        }
        //5
        //3
        //
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String tag = clothe[1];
            map.put(tag, map.getOrDefault(tag, 0) + 1);
        }

        int sum = 1;
        for (Entry<String, Integer> e : map.entrySet()){
            sum *= e.getValue() + 1;
        }

        return sum -= 1;
    }
}
