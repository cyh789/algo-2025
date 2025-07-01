package com.algo.programmers.prog_0701_004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//[PCCE 기출문제] 10번 / 데이터 분석
public class Solution {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80},
                        {2, 20300804, 847, 37},
                        {3, 20300401, 10, 8},
                        {4, 20300401, 10, 9}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        int[][] answer = solution(data, ext, val_ext, sort_by);
        for (int[] row : answer) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int w = data[0].length;
        int h = data.length;

        int extH = condition.valueOf(ext.toLowerCase()).getIndex();
        int sortH = condition.valueOf(sort_by.toLowerCase()).getIndex();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            if (data[i][extH] < val_ext) {
                list.add(data[i]);
            }
        }

        int[][] answer = new int[list.size()][h];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortH] - o2[sortH];
            }
        });

        return answer;
    }

    public enum condition {
        code(0), date(1), maximum(2), remain(3);

        private int index;

        condition(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
}
