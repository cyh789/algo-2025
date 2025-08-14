package com.algo.backup.programmers.prog_08.prog_0808_009_데이터_분석;

import java.util.*;

//데이터 분석
public class Solution {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";	int val_ext = 20300501;	String sort_by = "remain";
        //answer = {{3,20300401,10,8},{1,20300104,100,80}}
        int[][] answer = solution(data, ext, val_ext, sort_by);
        for (int[] arr : answer) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        //데이터는 ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]
        //정렬한 데이터들이 담긴 이차원 정수 리스트 data와
        // 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext,
        // 뽑아낼 정보의 기준값을 나타내는 정수 val_ext,
        // 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.

        //map -> string 데이터명, int idx(data[idx])
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        map.put("code", idx++);
        map.put("date", idx++);
        map.put("maximum", idx++);
        map.put("remain", idx++);

        int dataH = data.length;
        int dataW = data[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < dataH; i++) {
            int extIdx = map.get(ext);

            int selected = data[i][extIdx];
            if (selected < valExt) {
                list.add(data[i]);
            }
        }

        int[][] answer = list.stream().toArray(int[][]::new);

        int sortByIdx = map.get(sortBy);
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortByIdx] - o2[sortByIdx];
            }
        });

        //data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후,
        // sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요.
        // 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.
        return answer;
    }


}
