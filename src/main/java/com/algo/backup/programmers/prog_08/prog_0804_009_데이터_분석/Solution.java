package com.algo.backup.programmers.prog_08.prog_0804_009_데이터_분석;

import java.util.*;

//데이터 분석
@SuppressWarnings("UnusedAssignment")
public class Solution {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";	int val_ext = 20300501;	String sort_by = "remain";
        //answer = {{3,20300401,10,8},{1,20300104,100,80}}
        int[][] answer = solution(data, ext, val_ext, sort_by);
        for (int[] arr : answer) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] solution(int[][] data, String ext, int valExt, String sortBy) {

        Map<String, Integer> map = new HashMap<>();
        int mapIndex = 0;
        map.put("code", mapIndex++);
        map.put("date", mapIndex++);
        map.put("maximum", mapIndex++);
        map.put("remain", mapIndex++);

        List<int[]> list = new ArrayList<>();
        for (int[] datum : data) {
            int extTemp = datum[map.get(ext)];
            if (extTemp <= valExt) {
                list.add(datum);
            }
        }

        int[][] answer = list.toArray(int[][]::new);
        int sortIndex = map.get(sortBy);
        Arrays.sort(answer, (o1, o2) -> o1[sortIndex] - o2[sortIndex]);

        return answer;
    }


}
