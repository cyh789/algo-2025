package com.algo.backup.programmers.prog_08.prog_0814_queueNstack_003_올바른_괄호;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 4;
        int index = 0;
        String[] m = new String[arrIndex];
        m[index++] = "()()"		;
        m[index++] = "(())()"	;
        m[index++] = ")()("		;
        m[index++] = "(()("		;
        index = 0;

        for (int i = 0; i < m.length; i++) {
            boolean answer = solution(m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //true
        //true
        //false
        //false
    }

    public static boolean solution(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char current : c) {
            if (stack.isEmpty()) {
                if (current == '(') stack.push(current);
                else return false;
                continue;
            }

            if (current == ')') stack.pop();
            else stack.push(current);
        }

        return stack.isEmpty();
    }
}
