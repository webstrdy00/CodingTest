import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        int totalWeight = 0; // 다리 위 트럭의 총 무게
        Queue<int[]> queue = new LinkedList<>();  // 다리 위에 있는 차들을 추가하는 Queue [차의 무게, 이동 거리]
        int index = 0; // 대기 트럭 인덱스
        while(index < truck_weights.length || !queue.isEmpty()){  // 대기 트럭이 있거나 다리 위에 트럭이 있는 경우 진행
            answer++;
            
            if(!queue.isEmpty() && queue.peek()[1] >= bridge_length){   // 큐 맨앞에 값을 보고 이동 거리가 다리 길이를 넘어서면 제거
                totalWeight -= queue.poll()[0];
            }
            
            if(index < truck_weights.length && totalWeight + truck_weights[index] <= weight){  // 대기 트럭이 있고 다음 트럭을 더한 무게가 최대 무게보다 적을떄
                queue.add(new int[] {truck_weights[index], 0}); // 다리에 새로운 트럭 올리기
                totalWeight += truck_weights[index];
                index++;
            }
            
            for(int[] truck : queue){  // 다리위에 트럭 이동 거리 증가시키기
                truck[1]++;
            }
        }
        
        return answer;
    }
}
// 1초마다 다리 길이에 1를 이동함
// bridge_length = 다리 길이, weight = 견딜 수 있는 무게, truck_weights = 대기하고 있는 차들에 무게