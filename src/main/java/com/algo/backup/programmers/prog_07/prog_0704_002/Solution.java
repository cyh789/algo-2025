package com.algo.backup.programmers.prog_07.prog_0704_002;

import java.util.ArrayList;
import java.util.List;

//[PCCP 기출문제] 1번 / 붕대 감기
public class Solution {
    public static void main(String[] args) {
        int[] bandage = {5,1,5};
        int health = 30;
        int[][] attacks = {{2,10}, {9,15}, {10,5}, {11,5}};
        //answer = 5
        int answer = solution(bandage, health, attacks);
        System.out.println(answer);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int endTime = 0;
        List<Monster> list = new ArrayList<>();
        for (int[] attack : attacks) {
            list.add(new Monster(attack[0], attack[1]));
            endTime = Math.max(endTime, attack[0]);
        }

        int hp = health;
        int bandageCastingTime = 0;
        int listIndex = 0;
        for (int i = 1; i <= endTime; i++) {
            if (i == list.get(listIndex).getCoolTime()) {
                hp -= list.get(listIndex).getDamage();
                listIndex++;
                bandageCastingTime = 0;
            } else {
                bandageCastingTime++;
                hp += bandage[1];
                if (bandageCastingTime == bandage[0]) {
                    hp += bandage[2];
                    bandageCastingTime = 0;
                }

                hp = Math.min(hp, health);
            }

            if (hp <= 0) {
                return -1;
            }
        }

        answer = hp;
        return answer;
    }

    private static class Monster {
        private final int coolTime;
        private final int damage;

        public Monster(int coolTime, int damage) {
            this.coolTime = coolTime;
            this.damage = damage;
        }

        public int getCoolTime() {
            return coolTime;
        }

        public int getDamage() {
            return damage;
        }
    }
}
