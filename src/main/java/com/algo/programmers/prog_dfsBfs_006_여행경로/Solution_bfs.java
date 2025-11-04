package com.algo.programmers.prog_dfsBfs_006_여행경로;

import java.util.*;

public class Solution_bfs {

    public static void main(String[] args) {
        int arrIndex = 2;
        int index = 0;
        String[][][] n = new String[arrIndex][][];
        n[index++] = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        n[index++] = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            String[] answer = solution(n[i]);
            System.out.println(Arrays.toString(answer));
            System.out.println("=============");
        }
        //{"ICN", "JFK", "HND", "IAD"}
        //{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
    }
    //주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
    //
    //항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //모든 공항은 알파벳 대문자 3글자로 이루어집니다.
    //주어진 공항 수는 3개 이상 10,000개 이하입니다.
    //tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
    //주어진 항공권은 모두 사용해야 합니다.
    //만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
    //모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
    //입출력 예
    //tickets	return
    //[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
    //[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    //입출력 예 설명
    //예제 #1
    //
    //["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
    //
    //예제 #2
    //
    //["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.

    public static String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        ArrayList<String> result = new ArrayList<>();
        bfs(tickets, result);
        return result.toArray(new String[0]);
    }

    private static void bfs(String[][] tickets, ArrayList<String> result) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add("ICN");
        q.add(new Node("ICN", new boolean[tickets.length], list));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.list.size() == tickets.length + 1) {
                //result = curr.list;
                result.clear();
                result.addAll(curr.list);
                break;
            }

            for (int i = 0; i < tickets.length; i++) {
                String v1 = tickets[i][0];
                String v2 = tickets[i][1];

                if (!curr.now.equals(v1)) continue;
                if (curr.visited[i]) continue;

                boolean[] nextVisited = Arrays.copyOf(curr.visited, tickets.length);
                nextVisited[i] = true;
                ArrayList<String> nextList = new ArrayList<>(curr.list);
                nextList.add(v2);
                q.add(new Node(v2, nextVisited, nextList));
            }
        }
    }

    private static final class Node {
        private final String now;
        private final boolean[] visited;
        private final ArrayList<String> list;

        private Node(String now, boolean[] visited, ArrayList<String> list) {
            this.now = now;
            this.visited = visited;
            this.list = list;
        }

        public String now() {
            return now;
        }

        public boolean[] visited() {
            return visited;
        }

        public ArrayList<String> list() {
            return list;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Node) obj;
            return Objects.equals(this.now, that.now) &&
                    Objects.equals(this.visited, that.visited) &&
                    Objects.equals(this.list, that.list);
        }

        @Override
        public int hashCode() {
            return Objects.hash(now, visited, list);
        }

        @Override
        public String toString() {
            return "Node[" +
                    "now=" + now + ", " +
                    "visited=" + visited + ", " +
                    "list=" + list + ']';
        }

        }
}
