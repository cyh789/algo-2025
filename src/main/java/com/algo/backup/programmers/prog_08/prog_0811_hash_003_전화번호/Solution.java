package com.algo.backup.programmers.prog_08.prog_0811_hash_003_전화번호;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        String[][] n = new String[arrIndex][];
        n[index++] = new String[]{"119", "97674223", "1195524421"}	;
        n[index++] = new String[]{"123","456","789"}				;
        n[index++] = new String[]{"12","123","1235","567","88"}		;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            boolean answer = solution(n[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //false
        //true
        //false
        //
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
