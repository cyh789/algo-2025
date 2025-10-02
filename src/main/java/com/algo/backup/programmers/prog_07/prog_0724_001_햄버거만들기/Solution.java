package com.algo.backup.programmers.prog_07.prog_0724_001_햄버거만들기;

import java.util.LinkedList;
import java.util.List;

//카드뭉치
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
        n[index++] = new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2};

        for (int[] ints : n) {
            int answer = solution(ints);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //0
    }

    public static int solution(int[] ingredient) {
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int i : ingredient) {
            list.add(i);
            if (list.size() >= 4) {
                if (list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2
                &&  list.get(list.size() - 2) == 3 && list.get(list.size() - 1) == 1) {
                    for (int j = 0; j < 4; j++) {
                        list.remove(list.size() - 1);
                    }

                    count++;
                }
            }
        }

        return count;
    }
}
