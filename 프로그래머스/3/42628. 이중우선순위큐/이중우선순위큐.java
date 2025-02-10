import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 합 (오름차순)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 합 (내림차순)
        HashMap<Integer, Integer> count = new HashMap<>();  // 삭제된 값 동기화
        
        for(String oper : operations){
            String[] parts = oper.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if(cmd.equals("I")){    // 숫자 삽입
                minHeap.offer(num);
                maxHeap.offer(num);
                count.put(num, count.getOrDefault(num, 0) + 1);
            } else if(cmd.equals("D")){ // 숫자 삭제
                if(count.isEmpty()){    // 큐가 비어있으면 스킵
                    continue;
                }
                
                // 대상 힙 선택 및 유효하지 않은 요소 제거
                PriorityQueue<Integer> targetHeap = (num == 1) ? maxHeap : minHeap;
                removeSync(targetHeap, count);
                
                if(!targetHeap.isEmpty()){
                    int value = targetHeap.poll();
                    int cnt = count.get(value);
                    if(cnt == 1){
                        count.remove(value);
                    }else{
                        count.put(value, cnt - 1);
                    }
                }
            }
        }
        
        // 유효한 요소만 남기기
        removeSync(maxHeap, count);
        removeSync(minHeap, count);
        
        if(count.isEmpty()){    // 비어있으면 {0,0} 반환
            return new int[]{0, 0};
        }
        
        int max = maxHeap.isEmpty() ? 0 : maxHeap.poll();
        int min = minHeap.isEmpty() ? 0 : minHeap.poll();
        
        return new int[]{max, min};
    }
    private void removeSync(PriorityQueue<Integer> heap, HashMap<Integer, Integer> count){
        while(!heap.isEmpty() && !count.containsKey(heap.peek())){  // HashMap에 해당 값이 없으면 Queue에서 제거
            heap.poll();
        }
    }
}
// 최소합, 최대합 동기화를 HashMap을 이용해서 진행
// HashMap에 해당 숫자가 있으면 삭제가 안된거고 없으면 이미 삭제 한거