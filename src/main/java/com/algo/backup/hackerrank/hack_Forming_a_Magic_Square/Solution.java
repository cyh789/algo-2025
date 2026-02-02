package com.algo.backup.hackerrank.hack_Forming_a_Magic_Square;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

//        List<List<Integer>> s = List.of(List.of(4,8,2), List.of(4,5,7), List.of(6,1,6));
        int result = Result.formingMagicSquare(s);
//        System.out.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}



class Result {
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][] base = {
                {8,1,6},
                {3,5,7},
                {4,9,2}
        };

        List<int[][]> magicSquares = generateAllMagicSquares(base);
//        for (int[][] ints : magicSquares) {
//            for (int[] i : ints) {
//                System.out.println(Arrays.toString(i));
//            }
//        }

        int minCost = Integer.MAX_VALUE;
        for (int[][] magic : magicSquares) {
            int cost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cost += Math.abs(magic[i][j] - s.get(i).get(j));
                }
            }
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    private static List<int[][]> generateAllMagicSquares(int[][] base) {
        List<int[][]> squares = new ArrayList<>();
        int[][] current = base;
        for (int i = 0; i < 4; i++) {
            squares.add(current);
            squares.add(reflect(current));
            current = rotate(current);
        }
        return squares;
    }

    private static int[][] rotate(int[][] m) {
        int[][] r = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                r[j][2-i] = m[i][j];
        return r;
    }

    private static int[][] reflect(int[][] m) {
        int[][] r = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                r[i][2-j] = m[i][j];
        return r;
    }

}
