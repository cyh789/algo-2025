package com.algo.backup.programmers.prog_10.prog_1001_queueNstack_005_다리를_지나는_트럭_999999999;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        int arrIndex = 1;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 2;
//        n[index++] = 100;
//        n[index++] = 100;
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 10;
//        m[index++] = 100;
//        m[index++] = 100;
        index = 0;

        int[][] l = new int[arrIndex][];
        l[index++] = new int[]{7,4,5,6};
//        l[index++] = new int[]{10};
//        l[index++] = new int[]{10,10,10,10,10,10,10,10,10,10};
        index = 0;

        for (int i = 0; i < n.length; i++) {
            int answer = solution(n[i], m[i], l[i]);
            System.out.println(answer);
            System.out.println("=============");
        }
        //8
        //101
        //110
    }

    //트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
    // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
    // 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
    // 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
    // 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
    //
    //예를 들어,
    // 트럭 2대가 올라갈 수 있고
    // 무게를 10kg까지 견디는 다리가 있습니다.
    // 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
    //
    //경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
    //0	    []	        []	    [7,4,5,6]
    //1~2	[]	        [7]	    [4,5,6]
    //3     [7]	        [4]	    [5,6]
    //4     [7]	        [4,5]	[6]
    //5     [7,4]	    [5]	    [6]
    //6~7	[7,4,5]	    [6]	    []
    //8	    [7,4,5,6]	[]	    []
    //따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
    //
    //solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
    // 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
    // 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
    //
    //제한 조건
    //bridge_length는 1 이상 10,000 이하입니다.
    //weight는 1 이상 10,000 이하입니다.
    //truck_weights의 길이는 1 이상 10,000 이하입니다.
    //모든 트럭의 무게는 1 이상 weight 이하입니다.
    //입출력 예
    //bridge_length	    weight	    truck_weights	                    return
    //2	                10	        [7,4,5,6]	                        8
    //100	            100	        [10]	                            101
    //100	            100	        [10,10,10,10,10,10,10,10,10,10]	    110
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        //빈상태 = 0
        int time = 0;
        int currBridgeWeight = 0;
        int currTruckIdx = 0;
        while (true) {

            if (currTruckIdx >= truck_weights.length && currBridgeWeight == 0) {
                break;
            }

            System.out.println(time + " sec | " + queue + " | " + currBridgeWeight);


            // 1.poll
            int prevTruckWeight = queue.poll();
            currBridgeWeight -= prevTruckWeight;

            int currTruckWeight = 0;
            if (currTruckIdx < truck_weights.length) {
                currTruckWeight = truck_weights[currTruckIdx];
            }

            // 2.add
            //무개 초과인 상태
            if (currBridgeWeight > weight) {
                queue.add(0);
            } else if (currBridgeWeight + currTruckWeight > weight) {
                //다음 트럭이 들어오면 무게 초과인 경우
                queue.add(0);
            } else {
                //다음 트럭이 들어와도 무게 초과가 아닌 경우
                queue.add(currTruckWeight);
                currBridgeWeight += currTruckWeight;

                currTruckIdx++;
            }

            // +1초
            time++;
        }

        return time;
    }

}
