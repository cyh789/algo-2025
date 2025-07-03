package com.algo.programmers.prog_0703_004;

import java.util.ArrayList;
import java.util.List;

//2025 프로그래머스 코드챌린지 2차 예선
//택배 상자 꺼내기
public class Solution {
    public static void main(String[] args) {
//        int n = 22;
//        int w = 6;
//        int num = 8;
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
        int idIndex = 1;
        int rowIndex = 1;
        int columnIndex = 1;
        boolean reverseFlag = false;
        for (int i = 0; i < n; i++) {
            if (reverseFlag) {
                list.add(new Box(idIndex++, rowIndex, columnIndex));
                rowIndex--;
            } else {
                list.add(new Box(idIndex++, rowIndex, columnIndex));
                rowIndex++;
            }

            if (rowIndex > w) {
                columnIndex++;
                reverseFlag = true;
                rowIndex--;
            }
            if (rowIndex < 1) {
                columnIndex++;
                reverseFlag = false;
                rowIndex++;
            }
        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }

        int selectedRow = 0;
        for (int i = 0; i < list.size(); i++) {
            if (num == list.get(i).getId()) {
                selectedRow = list.get(i).getRow();
            }
            if (selectedRow == list.get(i).getRow()) {
                answer++;
            }
        }
        return answer;
    }

    static class Box {
        private int id;
        private int row;
        private int column;

        public Box(int id, int x, int y) {
            this.id = id;
            this.row = x;
            this.column = y;
        }

        public int getId() {
            return id;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "id=" + id +
                    ", row=" + row +
                    ", column=" + column +
                    '}';
        }
    }




}
