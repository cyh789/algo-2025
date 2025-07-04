package com.algo.programmers.prog_0704_004;

import java.util.ArrayList;
import java.util.List;

//2025 프로그래머스 코드챌린지 2차 예선
//택배 상자 꺼내기
public class Solution {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        //answer = 3
//        int n = 13;
//        int w = 3;
//        int num = 6;
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
            list.add(new Box(i, rowIndex, columnIndex));

            if (reverse) {
                if (i % w == 0) {
                    columnIndex++;
                    reverse = false;
                } else {
                    rowIndex--;
                }
            } else {
                if (i % w == 0) {
                    columnIndex++;
                    reverse = true;
                } else {
                    rowIndex++;
                }
            }
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }

        int selectedRowIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == num) {
                selectedRowIndex = list.get(i).getRowIndex();
            }

            if (list.get(i).getId() >= num && list.get(i).getRowIndex() == selectedRowIndex) {
                answer++;
            }
        }

        return answer;
    }

    private static class Box {
        private final int id;
        private final int rowIndex;
        private final int columnIndex;

        public Box(int id, int rowIndex, int columnIndex) {
            this.id = id;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "id=" + id +
                    ", rowIndex=" + rowIndex +
                    ", columnIndex=" + columnIndex +
                    '}';
        }
    }
}
