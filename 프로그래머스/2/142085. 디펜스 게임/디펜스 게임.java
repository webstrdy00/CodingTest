import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // 큰수 우선순위 큐
        
        for(int e : enemy){
            maxHeap.offer(e);
            n -= e;
            
            if(n < 0){  // 병사가 부족하고
                if(k > 0){  // 무적권을 사용할 수 있을떄
                    n += maxHeap.poll(); // 제일 병사가 많은 라운드 무적권 사용
                    k--;
                }else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}