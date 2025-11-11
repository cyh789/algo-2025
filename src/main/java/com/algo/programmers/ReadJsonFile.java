package com.algo.programmers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            if (args.length < 4) {
                System.err.println("사용법: java -jar TeamBuilder.jar <min> <max> <fixedUsers> <ignoreUsers>");
                System.err.println("예시: java -jar TeamBuilder.jar 180.0 187.0 \"클리드1:정글,칸_김동하:탑\" \"김민교.:미드,이자리:미드,이라333:원딜\"");
                return;
            }

            double min = Double.parseDouble(args[0]);
            double max = Double.parseDouble(args[1]);

            String[][] fixedUsers = parseUserArgs(args[2]);
            String[][] ignoreUsers = parseUserArgs(args[3]);


            // 1. 파일 경로 지정
            String fileName = "json.txt";

            InputStream is = ReadJsonFile.class.getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException("json.txt not found in resources!");
            }

            // 2. 파일 내용 읽기
            String content = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            // 3. JSON 파싱
            JSONObject root = new JSONObject(content);
            JSONObject table = root.getJSONObject("table");
            //JSONArray cols = table.getJSONArray("cols");
            JSONArray rows = table.getJSONArray("rows");

            // 리스트 입력
            ArrayList<ArrayList<String[]>> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ArrayList<String[]> temp = new ArrayList<>();
                list.add(temp);
            }

            int[] cntArr = new int[5];
            for (int i = 0; i < rows.length(); i++) {
                JSONObject row = rows.getJSONObject(i);
                JSONArray cells = row.getJSONArray("c");
                makeList(cells, list, cntArr);
            }

//            int totalCnt = rows.length();
            int maxCnt = 0;
            for (int i = 0; i < cntArr.length; i++) {
                maxCnt = Math.max(maxCnt, cntArr[i]);
//                System.out.print(cntArr[i] + " ");
            }
//            System.out.println();
//            System.out.println("total=" + totalCnt + " / max=" + maxCnt);

            //5개의 포지션(탑/정글/미드/원딜/서폿)에서 각각 1명씩 선택하여, 5명으로 이루어진 팀을 만들려고 한다.
            //이때 팀의 점수 총합이 min 이상, max 이하로 구성되야 하며
            //5개의 포지션 중 1개에 해당하응 유저의 이름은 주어진 채로 시작된다.
            //모든 팀을 구하는 solution
            boolean[][] visited = new boolean[5][maxCnt];
            ArrayList<ArrayList<String>> team = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ArrayList<String[]> temp = new ArrayList<>();
                list.add(temp);
            }

//            double max = 187.0;
//            double min = 180.0;
//            String[][] fixedUsers = new String[][]{
//                    {"클리드1", "정글"},
//                    {"칸_김동하", "탑"}
//            };
//            String[][] ignoreUsers = new String[][]{
//                    {"김민교.", "미드"},
//                    {"이자리", "미드"},
//                    {"이라333", "원딜"}
//            };
            dfs(fixedUsers, ignoreUsers, visited, list, max, min, team);

            saveTeamsToFile(team, list, "src/main/resources/team_result.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[][] parseUserArgs(String arg) {
        String[] pairs = arg.split(",");
        String[][] result = new String[pairs.length][2];
        for (int i = 0; i < pairs.length; i++) {
            String[] parts = pairs[i].split(":");
            result[i][0] = parts[0];
            result[i][1] = parts[1];
        }
        return result;
    }

    private static void saveTeamsToFile(ArrayList<ArrayList<String>> teamList,
                                        ArrayList<ArrayList<String[]>> list,
                                        String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("[가능한 팀 조합 수]: " + teamList.size());
            writer.newLine();

            for (int i = 0; i < teamList.size(); i++) {
                ArrayList<String> t = teamList.get(i);
                double sum = 0.0;
                StringBuilder sb = new StringBuilder();
                sb.append("팀 ").append(i + 1).append(": ");

                // 포지션 순서대로 유저 탐색 및 점수 누적
                for (Positions pos : Positions.values()) {
                    ArrayList<String[]> posList = list.get(pos.value);
                    for (String[] user : posList) {
                        if (t.contains(user[0])) {
                            double score = Double.parseDouble(user[2]);
                            sum += score;
                            sb.append(String.format("%s(%.1f)", user[0], score)).append(", ");
                            break;
                        }
                    }
                }

                sb.append(String.format("총점: %.1f", sum));
                writer.write(sb.toString());
                writer.newLine();
            }

            System.out.println("팀 결과가 파일에 저장되었습니다: " + filePath);
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    private static void dfs(String[][] fixedUsers, String[][] ignoreUsers, boolean[][] visited,
                            ArrayList<ArrayList<String[]>> list,
                            double max, double min,
                            ArrayList<ArrayList<String>> team) {

        ArrayList<String> currentTeam = new ArrayList<>();
        double totalScore = 0.0;
        HashSet<Integer> fixedPositions = new HashSet<>();
        HashSet<String> ignoreSet = new HashSet<>();

        // 제외 유저 목록 구성
        for (String[] ignore : ignoreUsers) {
            ignoreSet.add(ignore[0]);
        }

        // 고정 유저 처리
        for (String[] userInfo : fixedUsers) {
            String userName = userInfo[0];
            String position = userInfo[1];
            int posIdx = -1;
            int userIdx = -1;

            for (Positions pos : Positions.values()) {
                if (pos.name.equals(position)) {
                    posIdx = pos.value;
                    ArrayList<String[]> posList = list.get(posIdx);
                    for (int i = 0; i < posList.size(); i++) {
                        if (posList.get(i)[0].equals(userName)) {
                            userIdx = i;
                            break;
                        }
                    }
                    break;
                }
            }

            if (posIdx == -1 || userIdx == -1) {
                System.err.println("고정 유저 정보 오류: " + Arrays.toString(userInfo));
                return;
            }

            if (fixedPositions.contains(posIdx)) {
                System.err.println("중복 포지션 고정: " + position);
                return;
            }

            if (ignoreSet.contains(userName)) {
                System.err.println("고정 유저가 제외 대상에 포함됨: " + userName);
                return;
            }

            visited[posIdx][userIdx] = true;
            currentTeam.add(userName);
            totalScore += Double.parseDouble(list.get(posIdx).get(userIdx)[2]);
            fixedPositions.add(posIdx);
        }

        // 고정 유저만으로 팀 완성
        if (fixedPositions.size() == 5) {
            if (totalScore >= min && totalScore <= max) {
                team.add(new ArrayList<>(currentTeam));
            }
            return;
        }

        dfsHelper(0, list, visited, currentTeam, totalScore, max, min, team, fixedPositions, ignoreSet);

        // 백트래킹
        for (String[] userInfo : fixedUsers) {
            String userName = userInfo[0];
            String position = userInfo[1];
            for (Positions pos : Positions.values()) {
                if (pos.name.equals(position)) {
                    int posIdx = pos.value;
                    ArrayList<String[]> posList = list.get(posIdx);
                    for (int i = 0; i < posList.size(); i++) {
                        if (posList.get(i)[0].equals(userName)) {
                            visited[posIdx][i] = false;
                            break;
                        }
                    }
                    break;
                }
            }
            currentTeam.remove(userName);
        }
    }

    private static void dfsHelper(int depth, ArrayList<ArrayList<String[]>> list, boolean[][] visited,
                                  ArrayList<String> currentTeam, double totalScore,
                                  double max, double min, ArrayList<ArrayList<String>> team,
                                  Set<Integer> fixedPositions, Set<String> ignoreSet) {

        if (depth == 5) {
            if (totalScore >= min && totalScore <= max) {
                team.add(new ArrayList<>(currentTeam));
            }
            return;
        }

        if (fixedPositions.contains(depth)) {
            dfsHelper(depth + 1, list, visited, currentTeam, totalScore, max, min, team, fixedPositions, ignoreSet);
            return;
        }

        for (int i = 0; i < list.get(depth).size(); i++) {
            String[] user = list.get(depth).get(i);
            if (visited[depth][i]) continue;
            if (ignoreSet.contains(user[0])) continue;

            visited[depth][i] = true;
            currentTeam.add(user[0]);
            double score = Double.parseDouble(user[2]);

            dfsHelper(depth + 1, list, visited, currentTeam, totalScore + score, max, min, team, fixedPositions, ignoreSet);

            visited[depth][i] = false;
            currentTeam.remove(currentTeam.size() - 1);
        }
    }

    private static void makeList(JSONArray cells, ArrayList<ArrayList<String[]>> list, int[] cnt) {
        String userName = cells.getJSONObject(0).getString("v");
        String position = cells.getJSONObject(1).getString("v");
        String score = cells.getJSONObject(2).get("v").toString();
        for (Positions s : Positions.values()) {
            if (s.name.equals(position)) {
                cnt[s.value]++;
                list.get(s.value).add(new String[]{userName, position, score});
            }
        }
    }

    public enum Positions {
        TOP("탑", 0),
        JG("정글", 1),
        MID("미드", 2),
        AD("원딜", 3),
        SUP("서폿", 4);

        private final String name;
        private final int value;

        Positions(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }
    }

}