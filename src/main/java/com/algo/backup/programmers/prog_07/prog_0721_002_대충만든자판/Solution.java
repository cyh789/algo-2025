package com.algo.backup.programmers.prog_07.prog_0721_002_대충만든자판;

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

        //mapping keymap
        //for i keymap
        //  String => char[] keymapTemp
        //      for j keymapTemp
        //          if map.contain(keymapTemp[i])  =>  continue
        //          map.put(keymapTemp[i], i+1)
        Map<Character, Integer> map = new HashMap<>();
        for (String s : keymap) {
            char[] keymapTemp = s.toCharArray();
            for (int j = 0; j < keymapTemp.length; j++) {
                if (map.containsKey(keymapTemp[j])) {
                    map.put(keymapTemp[j], Math.min(j + 1, map.get(keymapTemp[j])));
                } else {
                    map.put(keymapTemp[j], j + 1);
                }
            }
        }

        //for i target
        //  String => char[] targetTemp
        //  for j targetTemp
        //      !map.containsKey(targetTemp[i]  =>  count = -1  =>  break
        //      count += map.get(targetTemp[i])
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            char[] targetTemp = targets[i].toCharArray();
            for (char c : targetTemp) {
                if (!map.containsKey(c)) {
                    count = -1;
                    break;
                }
                count += map.get(c);
            }
            answer[i] = count;
        }

        return answer;
    }
}
