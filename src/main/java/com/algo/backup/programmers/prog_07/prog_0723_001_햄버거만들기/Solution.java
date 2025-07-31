package com.algo.backup.programmers.prog_07.prog_0723_001_햄버거만들기;

import java.util.LinkedList;
import java.util.List;

//카드뭉치
public class Solution {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        int[][] n = new int[arrIndex][];
        n[index++] = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
        n[index++] = new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2};

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //2
        //0
    }

    public static int solution(int[] ingredient) {

        //for i ingredient
        //ingredient[i] 가 1231 인지 확인
        //맞으면 해당 [i]부터 4칸 삭제, count++
        //[i-1] 부터 다시 1231인지 확인
        //맞으면 해당 [i-1]부터 4칸 삭제, count++
        //반복

        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (int k : ingredient) {
            list.add(k);
            if (list.size() >= 4) {
                if (list.get(list.size() - 4) == 1 && list.get(list.size() - 3) == 2
                 && list.get(list.size() - 2) == 3 && list.get(list.size() - 1) == 1) {

                    //4칸삭제
//                    for (int j = 0; j < 4; j++) {
//                        list.remove(list.size() - 1);
//                    }
                    list.subList(list.size() - 4, list.size()).clear();

                    count++;
                }
            }
        }

        return count;
    }
}
