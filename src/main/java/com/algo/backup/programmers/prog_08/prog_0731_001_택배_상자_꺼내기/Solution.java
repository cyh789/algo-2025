package com.algo.backup.programmers.prog_08.prog_0731_001_택배_상자_꺼내기;

import java.util.Arrays;

//택배 상자 꺼내기
public class Solution {
    public static void main(String[] args) {
        int n = 22;     //전체 상자 갯수
        int w = 6;      //전체 열 갯수
        int num = 8;    //input 상자 넘버
        //answer = 3
//        int n = 13;
//        int w = 3;
//        int num = 6;
        //answer = 4
        int answer = solution(n, w, num);
        System.out.println(answer);
    }

    public static int solution(int n, int w, int num) {
        int boxH = n / w + 1;
        int boxNumber = 1;
        boolean reverse = false;
        int selectedBoxNumH = 0;
        int selectedBoxNumW = 0;
        int[][] boxTable = new int[boxH][w];
        for (int i = 0; i < boxH; i++) {
            if (reverse) {
                for (int j = w - 1; j >= 0; j--) {
                    if (boxNumber == num) {
                        selectedBoxNumH = i;
                        selectedBoxNumW = j;
                    }
                    if (boxNumber > n) break;
                    boxTable[i][j] = boxNumber++;
                }
                reverse = false;
            } else {
                for (int j = 0; j < w; j++) {
                    if (boxNumber == num) {
                        selectedBoxNumH = i;
                        selectedBoxNumW = j;
                    }
                    if (boxNumber > n) break;
                    boxTable[i][j] = boxNumber++;
                }
                reverse = true;
            }
        }

        System.out.println("selectedBoxNumH=" + selectedBoxNumH);
        System.out.println("selectedBoxNumW=" + selectedBoxNumW);
        for (int[] ints : boxTable) {
            System.out.println(Arrays.toString(ints));
        }

        int sum = 0;
        for (int i = selectedBoxNumH; i < boxTable.length; i++) {
            System.out.println("boxTable[i][selectedBoxNumW]=" + boxTable[i][selectedBoxNumW]);
            if (boxTable[i][selectedBoxNumW] > 0) {
                sum++;
            }
        }

        return sum;
    }
}
