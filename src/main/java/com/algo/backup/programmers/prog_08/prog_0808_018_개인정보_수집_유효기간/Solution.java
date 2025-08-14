package com.algo.backup.programmers.prog_08.prog_0808_018_개인정보_수집_유효기간;

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
        // 약관의 유효기간을 담은 1차원 문자열 배열 terms와
        // 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가 매개변수로 주어집니다.
        // 이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

        //2000 ≤ YYYY ≤ 2022
        //1 ≤ MM ≤ 12
        //MM이 한 자릿수인 경우 앞에 0이 붙습니다.
        //1 ≤ DD ≤ 28
        //DD가 한 자릿수인 경우 앞에 0이 붙습니다.

        //다음은 오늘 날짜가 2022.05.19일 때의 예시입니다.
        //2022년 5월 19일까지 보관 가능하며, 유효기간이 지나지 않았으므로 아직 보관 가능합니다.
        int todayTemp = transFunc(today);

        int[] privaciesTemp = new int[privacies.length];
        for (int i = 0; i < privacies.length; i++) {
            privaciesTemp[i] = transFunc(privacies[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String name = terms[i].substring(0, 1);
            String month = terms[i].substring(2);
            int monthTemp = Integer.parseInt(month) * 28;
            map.put(name, monthTemp);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privaciesTemp.length; i++) {
            if (todayTemp + 1 > privaciesTemp[i] + map.get(privacies[i].substring(11, 12))) {
                list.add(i + 1);
            }
        }

        int[] answer = list.stream().mapToInt(integer -> integer).toArray();

        return answer;
    }

    private static int transFunc(String today) {
        String year = today.substring(0, 4);
        String mon = today.substring(5, 7);
        String day = today.substring(8, 10);

        return Integer.parseInt(year) * 12 * 28
                + Integer.parseInt(mon) * 28
                + Integer.parseInt(day);
    }
}
