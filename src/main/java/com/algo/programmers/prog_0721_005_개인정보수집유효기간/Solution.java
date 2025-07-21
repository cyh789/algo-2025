package com.algo.programmers.prog_0721_005_개인정보수집유효기간;

import java.util.*;

//2023 KAKAO BLIND RECRUITMENT
//개인정보 수집 유효기간
public class Solution {

    public static void main(String[] args) {
        int index = 0;
        String[] n = new String[2];
        n[index++] = "2022.05.19";
        n[index++] = "2020.01.01";
        index = 0;

        String[][] m = new String[2][];
        m[index++] = new String[]{"A 6", "B 12", "C 3"};
        m[index++] = new String[]{"Z 3", "D 5"}			;
        index = 0;

        String[][] l = new String[2][];
        l[index++] = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}				;
        l[index++] = new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int[] answer = solution(n[i], m[i], l[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //{1, 3}
        //{1, 4, 5}
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        //모든 달은 28일까지 있다고 가정합니다.
        //오늘 날짜를 의미하는 문자열 today,
        // 약관의 유효기간을 담은 1차원 문자열 배열 terms
        // 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies
        // 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return

        int todaytemp = transFunc(today);

        Map<String, Integer> termsTemp = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String key = terms[i].substring(0, 1);
            int value = Integer.parseInt(terms[i].substring(2)) * 28;
            termsTemp.put(key, value);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String key = privacies[i].substring(11, 12);
            int privaciesDay = transFunc(privacies[i]);
            int plusDay = termsTemp.get(key);
            //System.out.println("key = " + key + " / month=" + (privaciesDay + plusDay) + " / todaytemp=" + todaytemp + " / " + (i+1));
            if (termsTemp.containsKey(key) && privaciesDay + plusDay - 1 < todaytemp) {
                //System.out.println("---------------------");
                list.add(i + 1);
            }
        }

        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();

        return answer;
    }

    private static int transFunc(String date) {
        //"2022.05.19"
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);

        return Integer.parseInt(year) * 12 * 28
                + (Integer.parseInt(month) - 1) * 28
                + Integer.parseInt(day);
    }
}
