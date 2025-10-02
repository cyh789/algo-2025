package com.algo.backup.programmers.prog_08.prog_0825_017_둘만의_암호_999999999;

//둘만의암호
@SuppressWarnings("UnusedAssignment")
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[] n = new String[1];
        n[index++] = "aukks";
        index = 0;

        String[] m = new String[1];
        m[index++] = "wbqd";
        index = 0;

        int[] l = new int[1];
        l[index++] = 5;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //"happy"
    }

    //문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
    //index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
    //skip에 있는 알파벳은 제외하고 건너뜁니다.

    //예를 들어 s = "aukks", skip = "wbqd", index = 5일 때,
    // a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
    // 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다.
    // 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.
    public static String solution(String s, String skip, int index) {

        char[] sTemp = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char selected = sTemp[i];

            int sTempIdx = 0;
            while (index > sTempIdx) {
                selected++;
                if (selected > 'z') selected = 'a';
                if (!skip.contains(String.valueOf(selected))) sTempIdx++;
            }
            answer.append(selected);
        }

        return answer.toString();
    }
}
