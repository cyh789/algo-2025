package com.algo.backup.programmers.prog_11.prog_1121_queueNstack_005_다리를_지나는_트럭_999999999;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"DataFlowIssue", "UnusedAssignment"})
public class Solution_1 {

    public static void main(String[] args) {
        int arrIndex = 3;
        int index = 0;
        int[] n = new int[arrIndex];
        n[index++] = 2;
        n[index++] = 100;
        n[index++] = 100;
        index = 0;

        int[] m = new int[arrIndex];
        m[index++] = 10;
        m[index++] = 100;
        m[index++] = 100;
        index = 0;

        int[][] l = new int[arrIndex][];
        l[index++] = new int[]{7,4,5,6};
        l[index++] = new int[]{10};
        l[index++] = new int[]{10,10,10,10,10,10,10,10,10,10};
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
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        int cnt = 0;
        int truckIdx = 0;
        int bridgeSum = 0;
        while (true) {
            int currTruck = 0;
            if (truckIdx > truck_weights.length - 1) {
                if (bridgeSum == 0) break;
            } else {
                currTruck = truck_weights[truckIdx];
            }

            //다리 위에 있는 트럭의 무게 + 들어갈 트럭의 무게 - 빠져나갈 트럭의 무게 > weight => 무게 초과될 수 있으므로 대기
            if (bridgeSum + currTruck - q.peek() > weight) {
                //1초 경과
                cnt++;
                //다리에서 트럭 1칸씩 이동(마지막 트럭 제거)
                int removeTruck = q.poll();
                //빈칸 1칸 추가
                q.add(0);

                //트럭 무게 갱신
                bridgeSum = bridgeSum + 0 - removeTruck;

            } else {
                //1초 경과
                cnt++;
                //다리에서 트럭 1칸씩 이동(마지막 트럭 제거)
                int removeTruck = q.poll();
                //다음 트럭 추가
                q.add(currTruck);

                //트럭 무게 갱신
                bridgeSum = bridgeSum + currTruck - removeTruck;

                //다음트럭 준비
                truckIdx++;
            }
        }

        return cnt;
    }

}
