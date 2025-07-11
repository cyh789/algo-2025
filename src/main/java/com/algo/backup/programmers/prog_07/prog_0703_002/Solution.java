package com.algo.backup.programmers.prog_07.prog_0703_002;

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
        int w = attacks[0].length;
        int h = attacks.length;
        List<Monster> list = new ArrayList<>();
        for (int[] i : attacks) {
            list.add(new Monster(i[0], i[1]));
        }

        int currentHealth = health;
        int healCount = 0;
        int index = 0;
        for (int i = 1; i < attacks[h-1][0] + 1; i++) {
            if (i == list.get(index).getTime()) {
                currentHealth -= list.get(index).getDamage();
                index++;
                healCount = 0;
            } else {
                healCount++;
                currentHealth += bandage[1];
                if (healCount == bandage[0]) {
                    currentHealth += bandage[2];
                    healCount = 0;
                }

                if (currentHealth > health) {
                    currentHealth = health;
                }
            }

            if (currentHealth <= 0) {
                return -1;
            }
        }

        answer = currentHealth;

        return answer;
    }

    public static class Monster {
        private int time;
        private int damage;

        public Monster(int time, int damage) {
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
