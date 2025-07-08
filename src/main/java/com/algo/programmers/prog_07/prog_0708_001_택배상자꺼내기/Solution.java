package com.algo.programmers.prog_07.prog_0708_001_택배상자꺼내기;

import java.util.ArrayList;
import java.util.List;

//택배 상자 꺼내기
public class Solution {
    public static void main(String[] args) {
//        int n = 22;     //전체 상자 갯수
//        int w = 6;      //전체 열 갯수
//        int num = 8;    //input 상자 넘버
        //answer = 3
        int n = 13;
        int w = 3;
        int num = 6;
        //answer = 4
        int answer = solution(n, w, num);
        System.out.println(answer);
    }

    public static int solution(int n, int w, int num) {
        int answer = 0;
        List<Box> list = new ArrayList<>();
        int rowIndex = 1;
        int columnIndex = 1;
        boolean reverse = false;
        for (int i = 1; i <= n; i++) {
            if (reverse) {
                list.add(new Box(i, columnIndex--, rowIndex));
            } else {
                list.add(new Box(i, columnIndex++, rowIndex));
            }

            if (i % w == 0) {
                rowIndex++;
            }
            if (columnIndex < 1) {
                reverse = false;
                columnIndex = 1;
            }
            if (columnIndex > w) {
                reverse = true;
                columnIndex = w;
            }
        }

//        for (Box box : list) {
//            System.out.println(box.toString());
//        }

        int selectedColumn = 0;
        for (int i = 0; i < list.size(); i++) {
            if (num == list.get(i).getId()) {
                selectedColumn = list.get(i).getColumn();
            }
            if (selectedColumn == list.get(i).getColumn()) {
                answer++;
            }
        }
        return answer;
    }

    private static class Box {
        private final int id;
        private final int column;
        private final int row;

        public Box(int id, int column, int row) {
            this.id = id;
            this.column = column;
            this.row = row;
        }

        public int getId() {
            return id;
        }

        public int getColumn() {
            return column;
        }

        public int getRow() {
            return row;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "id=" + id +
                    ", column=" + column +
                    ", row=" + row +
                    '}';
        }
    }
}
