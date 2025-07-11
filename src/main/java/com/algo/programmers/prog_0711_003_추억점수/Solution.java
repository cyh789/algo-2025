package com.algo.programmers.prog_0711_003_추억점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//추억 점수
public class Solution {

    public static void main(String[] args) {
        String[] name={"may", "kein", "kain", "radi"};
        int[] yearning={5, 10, 1, 3};
        String[][] photo={{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}	;
        //{19, 15, 6}
//        String[] name={"kali", "mari", "don"}		;
//        int[] yearning={11, 1, 55}	;
//        String[][] photo={{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}	;
//        //{67, 0, 55}
//        String[] name={"may", "kein", "kain", "radi"};
//        int[] yearning={5, 10, 1, 3};
//        String[][] photo={{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
//        //{5, 15, 0}
        int[] answer = solution(name, yearning, photo);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        //그리워하는 사람의 이름을 담은 문자열 배열 name
        //각 사람별 그리움 점수를 담은 정수 배열 yearning
        // 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        // 추억 점수 = 인물의 그리움 점수를 모두 합산한 값
        // 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다.
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            String nameInPhoto = "";
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                nameInPhoto = photo[i][j];
                int yearningInPhoto = 0;
                if (map.get(nameInPhoto) != null) {
                    yearningInPhoto = map.get(nameInPhoto) != null ? map.get(nameInPhoto) : 0;
                }
                sum += yearningInPhoto;
            }
            answer[i] = sum;
        }

        // 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
        return answer;
    }
}
