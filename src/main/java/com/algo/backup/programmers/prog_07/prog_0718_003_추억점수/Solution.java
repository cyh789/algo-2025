package com.algo.backup.programmers.prog_07.prog_0718_003_추억점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//추억 점수
public class Solution {

    public static void main(String[] args) {
        String[][] name = new String[3][];
        name[0] = new String[]{"may", "kein", "kain", "radi"};
        name[1] = new String[]{"kali", "mari", "don"}		;
        name[2] = new String[]{"may", "kein", "kain", "radi"};
        int[][] yearning = new int[3][];
        yearning[0] = new int[]{5, 10, 1, 3};
        yearning[1] = new int[]{11, 1, 55}	;
        yearning[2] = new int[]{5, 10, 1, 3};
        String[][][] photo = new String[3][][];
        photo[0] = new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}	;
        photo[1] = new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}	;
        photo[2] = new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
        for (int i = 0; i < 3; i++) {
            int[] answer = solution(name[i], yearning[i], photo[i]);
            System.out.println(Arrays.toString(answer));
        }
        //{19, 15, 6}
        //{67, 0, 55}
        //{5, 15, 0}
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        //mapping(name, yearning)
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int photoH = photo.length;
        int[] answer = new int[photoH];
        //for i photoH  =>  for i photoW
        //selected = photo[i][j]  =>  if map.containsKey(selected)  =>  score += map.get(selected)
        //answer[i] = score
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            String[] strings = photo[i];
            for (int j = 0; j < strings.length; j++) {
                String selected = strings[j];
                if (map.containsKey(selected)) score += map.get(selected);
            }
            answer[i] = score;
        }

        return answer;
    }
}
