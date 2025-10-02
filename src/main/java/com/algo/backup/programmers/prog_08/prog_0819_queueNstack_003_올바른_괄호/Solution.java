package com.algo.backup.programmers.prog_08.prog_0819_queueNstack_003_올바른_괄호;

import java.util.Stack;

@SuppressWarnings("UnusedAssignment")
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

        for (String s : m) {
            boolean answer = solution(s);
            System.out.println(answer);
            System.out.println("=============");
        }
        //true
        //true
        //false
        //false
    }

    public static boolean solution2(String s) {
        //괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
        //
        //"()()" 또는 "(())()" 는 올바른 괄호입니다.
        //")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
        //'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
        //
        //제한사항
        //문자열 s의 길이 : 100,000 이하의 자연수
        //문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

        char[] c = s.toCharArray();
        int leftCount = 0;  //'('
        int rightCount = 0; //')'
        for (int i = 0; i < s.length(); i++) {
            char selected = c[i];
            if (selected == '(') leftCount++;
            if (selected == ')') rightCount++;
            if (leftCount < rightCount) return false;
        }

        return leftCount == rightCount;
    }

    public static boolean solution(String s) {
        Stack<Character> leftCount = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char selected = c[i];
            if (leftCount.isEmpty()) {
                if (selected == '(') leftCount.push(selected);
                else return false;
            } else {
                if (selected == '(') leftCount.push(selected);
                else leftCount.pop();
            }
        }

        return leftCount.isEmpty();
    }
}
