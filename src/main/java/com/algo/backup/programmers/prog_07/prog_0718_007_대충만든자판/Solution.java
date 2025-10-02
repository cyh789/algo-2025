package com.algo.backup.programmers.prog_07.prog_0718_007_대충만든자판;

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


        //map keymap<char, Integer>  => Integer는 1부터 시작
        Map<String, Integer> map = new HashMap<>();
        for (String s : keymap) {
            char[] keymapTemp = s.toCharArray();
            for (int j = 0; j < keymapTemp.length; j++) {
                String selected = String.valueOf(keymapTemp[j]);
                int value = map.getOrDefault(selected, j + 1);
                map.put(selected, Math.min(value, j + 1));
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            char[] targetsTemp = targets[i].toCharArray();
            for (char c : targetsTemp) {
                String selected = String.valueOf(c);
                if (!map.containsKey(selected)) {
                    sum = -1;
                    break;
                }
                sum += map.get(selected);
            }
            answer[i] = sum;
        }

        return answer;
    }
}
