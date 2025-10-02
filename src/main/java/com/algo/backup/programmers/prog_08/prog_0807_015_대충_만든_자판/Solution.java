package com.algo.backup.programmers.prog_08.prog_0807_015_대충_만든_자판;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//대충만든자판
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[][] n = new String[3][];
        n[index++] = new String[]{"ABACD", "BCEFD"}	;
        n[index++] = new String[]{"AA"}				;
        n[index++] = new String[]{"AGZ", "BSSS"}	;
        index = 0;
        String[][] m = new String[3][];
        m[index++] = new String[]{"ABCD","AABB"}	;
        m[index++] = new String[]{"B"}			;
        m[index++] = new String[]{"ASA","BGZ"}	;
        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], m[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("==========");
        }
        //{9, 4}
        //{-1}
        //{4, 6}
    }

    public static int[] solution(String[] keymap, String[] targets) {
        //1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap
        // 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때,
        // 각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
        //
        //단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.

        //keymap to map => string, int
        //keymap fori
        //string to char[] => fori
        //int는 최소값 => math.min => get 해서 확인 후 다시 put
        Map<String, Integer> map = new HashMap<>();
        for (String s : keymap) {
            char[] c = s.toCharArray();
            for (int j = 0; j < c.length; j++) {
                String selected = String.valueOf(c[j]);
                map.put(selected, Math.min(map.getOrDefault(selected, j + 1), j + 1));
            }
        }

        //targets fori => []
        //string to char[] => fori
        //sum += map.get
        //단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            char[] c = targets[i].toCharArray();
            for (char item : c) {
                String selected = String.valueOf(item);
                int value = map.getOrDefault(selected, -1);

                //단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
                if (value == -1) {
                    sum = -1;
                    break;
                }
                sum += value;
            }

            answer[i] = sum;
        }

        //문자열과 count를 저장하는 map
        // map에는 더 작은 값을 담는다 math.min
        return answer;
    }
}
