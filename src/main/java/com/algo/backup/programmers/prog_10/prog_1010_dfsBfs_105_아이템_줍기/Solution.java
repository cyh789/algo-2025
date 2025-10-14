package com.algo.backup.programmers.prog_10.prog_1010_dfsBfs_105_아이템_줍기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 5;
        int index = 0;
        int[][][] n = new int[arrIndex][][];
        n[index++] = new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        n[index++] = new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        n[index++] = new int[][]{{1,1,5,7}}						;
        n[index++] = new int[][]{{2,1,7,5},{6,4,10,10}}			;
        n[index++] = new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}};
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 1;
        m[index++] = 9;
        m[index++] = 1;
        m[index++] = 3;
        m[index++] = 1;
        index = 0;

        int[] l = new int[arrIndex];
        l[index++] = 3;
        l[index++] = 7;
        l[index++] = 1;
        l[index++] = 1;
        l[index++] = 4;
        index = 0;

        int[] o = new int[arrIndex];
        o[index++] = 7;
        o[index++] = 6;
        o[index++] = 4;
        o[index++] = 7;
        o[index++] = 6;
        index = 0;

        int[] p = new int[arrIndex];
        p[index++] = 8	;
        p[index++] = 1	;
        p[index++] = 7	;
        p[index++] = 10	;
        p[index++] = 3	;
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i], o[i], p[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //17
        //11
        //9
        //15
        //10
    }

    //rectangle	   characterX	characterY	itemX	itemY	result
    //{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}	1	3	7	8	17
    //{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}	9	7	6	1	11
    //{{1,1,5,7}}								1	1	4	7	9
    //{{2,1,7,5},{6,4,10,10}}					3	1	7	10	15
    //{{2,2,5,5},{1,3,6,4},{3,1,4,6}}			1	4	6	3	10

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];
            transMapFunc(map, x1 * 2, y1 * 2, x2 * 2, y2 * 2);
        }

        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private static int bfs(int[][] map, int x1, int y1, int x2, int y2) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, cnt});

        boolean[][] visited = new boolean[101][101];
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currCnt = curr[2];

            if (currX == x2 && currY == y2) return currCnt / 2;

            for (int i = 0; i < dx.length; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if (nextX < 0 || nextX >= 101) continue;
                if (nextY < 0 || nextY >= 101) continue;
                if (visited[nextX][nextY]) continue;
                if (map[nextX][nextY] != 1) continue;

                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, currCnt + 1});
            }
        }

        return 0;
    }

    private static void transMapFunc(int[][] map, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    if (map[i][j] == 2) continue;
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }
        }
    }

}
