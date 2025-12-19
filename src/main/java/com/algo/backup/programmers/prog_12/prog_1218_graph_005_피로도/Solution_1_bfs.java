package com.algo.backup.programmers.prog_12.prog_1218_graph_005_피로도;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@SuppressWarnings("UnusedAssignment")
public class Solution_1_bfs {

    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 80;
        index = 0;

        int[][][] m = new int[arrIndex][][];
        m[index++] = new int[][]{{80,20},{50,40},{30,10}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //3
    }

    //XX게임에는
    // 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며,
    // 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
    // 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와
    // 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다.
    //
    // 예를 들어 "최소 필요 피로도"가 80,
    // "소모 피로도"가 20인 던전을 탐험하기 위해서는
    // 유저의 현재 남은 피로도 >= 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 -20이 소모됩니다.
    //
    // 유저의 현재 피로도 k와
    // 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때,
    // 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.
    //
    //제한사항
    //k는 1 이상 5,000 이하인 자연수입니다.
    //dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.
    //dungeons의 가로(열) 길이는 2 입니다.
    //dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.

    //"최소 필요 피로도"는 항상 >=  "소모 피로도"보다 크거나 같습니다.
    //"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.
    //서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다.

    //입출력 예
    //k	    dungeons	                result
    //80	[[80,20],[50,40],[30,10]]	3

    //입출력 예 설명
    //현재 피로도는 80입니다.
    //만약, 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험한다면
    //
    //현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다. 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
    //남은 피로도는 60이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 20입니다.
    //남은 피로도는 20이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30입니다. 따라서 세 번째 던전은 탐험할 수 없습니다.
    //만약, 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험한다면
    //
    //현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다. 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
    //남은 피로도는 60이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30이므로, 세 번째 던전을 탐험할 수 있습니다. 세 번째 던전의 "소모 피로도"는 10이므로, 던전을 탐험한 후 남은 피로도는 50입니다.
    //남은 피로도는 50이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 10입니다.
    //따라서 이 경우 세 던전을 모두 탐험할 수 있으며, 유저가 탐험할 수 있는 최대 던전 수는 3입니다.
    public static int solution(int k, int[][] dungeons) {
        return bfs(k, dungeons);
    }

    private static int bfs(int k, int[][] dungeons) {
        Queue<Node> q = new LinkedList<>();
        int cnt = 0;
        boolean[] visited = new boolean[dungeons.length];
        int energy = k;
        q.add(new Node(cnt, visited, energy));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int currCnt = curr.cnt;
            boolean[] currVisited = curr.visited;
            int currEnergy = curr.energy;

            cnt = Math.max(cnt, currCnt);

            for (int i = 0; i < dungeons.length; i++) {
                if (currVisited[i]) continue;
                boolean[] nextVisited = Arrays.copyOf(currVisited, currVisited.length);
                nextVisited[i] = true;

                int nextEnergy = currEnergy - dungeons[i][1];
                if (nextEnergy < 0) continue;

                if (currEnergy < dungeons[i][0]) continue;
                int nextCnt = currCnt + 1;

                //System.out.println("currEnergy=" + currEnergy + " / dungeons=" + Arrays.toString(dungeons[i]) + " / cnt=" + currCnt);
                q.add(new Node(nextCnt, nextVisited, nextEnergy));
            }
        }

        return cnt;
    }

    private static final class Node {
        private final int cnt;
        private final boolean[] visited;
        private final int energy;

        private Node(int cnt, boolean[] visited, int energy) {
            this.cnt = cnt;
            this.visited = visited;
            this.energy = energy;
        }

        public int cnt() {
            return cnt;
        }

        public boolean[] visited() {
            return visited;
        }

        public int energy() {
            return energy;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Node) obj;
            return this.cnt == that.cnt &&
                    Objects.equals(this.visited, that.visited) &&
                    this.energy == that.energy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cnt, visited, energy);
        }

        @Override
        public String toString() {
            return "Node[" +
                    "cnt=" + cnt + ", " +
                    "visited=" + visited + ", " +
                    "energy=" + energy + ']';
        }

        }
}
