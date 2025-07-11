package com.algo.backup.programmers.prog_07.prog_0708_008_데이터분석;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//데이터 분석
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
        int extTemp = Data.valueOf(ext).getIndex();

        List<int[]> list = new ArrayList<>();
        for (int[] arr : data) {
            if (arr[extTemp] < valExt) {
                list.add(arr);
            }
        }

        int[][] answer = list.stream()
                .toArray(int[][]::new);

        int sortByTemp = Data.valueOf(sortBy).getIndex();
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortByTemp] - o2[sortByTemp];
            }
        });

        return answer;
    }

    public enum Data {
        code(0), date(1), maximum(2), remain(3);

        private final int index;

        Data(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

}
