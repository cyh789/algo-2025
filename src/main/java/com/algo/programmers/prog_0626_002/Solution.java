package com.algo.programmers.prog_0626_002;

import java.util.*;
import java.util.stream.Collectors;

//[PCCE 기출문제] 10번 / 데이터 분석
public class Solution {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}, {4, 20300401, 10, 9}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        solution(data, ext, val_ext, sort_by);
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int val = Column.valueOf(ext.toUpperCase()).getIndex();
        int sort = Column.valueOf(sort_by.toUpperCase()).getIndex();

        ArrayList<int[]> dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][val] < val_ext) {
                dataList.add(data[i]);
            }
        }

        int[][] answer = new int[dataList.size()][3];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = dataList.get(i);
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sort] - o2[sort];
            }
        });

        for (int[] row : answer) {
            System.out.println(Arrays.toString(row));
        }

        return answer;
    }

    public static int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {
        int val = Column.valueOf(ext.toUpperCase()).getIndex();
        int sort = Column.valueOf(sort_by.toUpperCase()).getIndex();

        List<int[]> dataList = Arrays.stream(data)
                .filter(row -> row[val] < val_ext)
                .sorted(Comparator.comparingInt(row -> row[sort]))
                .collect(Collectors.toList());

        int[][] answer = new int[dataList.size()][3];
        for (int i = 0; i < dataList.size(); i++) {
            answer[i] = dataList.get(i);
        }

        return answer;
    }

    public enum Column {
        CODE(0), DATE(1), MAXIMUM(2), REMAIN(3);

        private int index;

        Column(int index){
            this.index = index;
        }
        public int getIndex(){
            return index;
        }
    }
}
