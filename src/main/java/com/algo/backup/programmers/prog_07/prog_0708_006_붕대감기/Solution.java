package com.algo.backup.programmers.prog_07.prog_0708_006_붕대감기;

import java.util.ArrayList;
import java.util.List;

//붕대 감기
public class Solution {
    public static void main(String[] args) {

//        int[] bandage = {5, 1, 5};	int health = 30	;	int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        //answer=5
//        int[] bandage = {3, 2, 7};	int health = 20	;	int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
//        //answer=-1
//        int[] bandage = {4, 2, 7};	int health = 20	;	int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
//        //answer=-1
        int[] bandage = {1, 1, 1};	int health = 5	;	int[][] attacks = {{1, 2}, {3, 2}};
//        //answer=3
        int answer = solution(bandage, health, attacks);
        System.out.println(answer);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;

        List<Creep> list = new ArrayList<>();
        for (int[] arr : attacks) {
            list.add(new Creep(arr[0], arr[1]));
        }

        int currentHp = health;
        int bandingTime = 0;
        int listIndex = 0;
        for (int i = 1; i <= list.get(list.size()-1).getTime(); i++) {
            if (i == list.get(listIndex).getTime()) {
                currentHp -= list.get(listIndex).getDamage();
                listIndex++;

                if (currentHp <= 0) {
                    return -1;
                }

                bandingTime = 0;

                //System.out.println("i=" + i + " / currentHp=" + currentHp);
                continue;
            }

            currentHp += bandage[1];

            if (bandingTime < bandage[0]) {
                bandingTime++;
            }
            if (bandingTime == bandage[0]) {
                currentHp += bandage[2];
                bandingTime = 0;
            }

            if (currentHp > health) {
                currentHp = health;
            }

            //System.out.println("i=" + i + " / currentHp=" + currentHp);
        }

        answer = currentHp;
        return answer;
    }

    private static class Creep {
        private final int time;
        private final int damage;

        public Creep(int time, int damage) {
            this.time = time;
            this.damage = damage;
        }

        public int getTime() {
            return time;
        }

        public int getDamage() {
            return damage;
        }
    }
}
