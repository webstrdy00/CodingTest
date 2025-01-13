import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> arr = new LinkedList<>();  // 남은 일수를 넣을 배열
        for(int i = 0; i < progresses.length; ++i){  // 남은 일수를 계산하여 Queue에 저장하는 과정
            int remainWork = 100 - progresses[i];
            int day = (int) Math.ceil((double) remainWork / speeds[i]);
            arr.add(day);
        }

        List<Integer> answer = new ArrayList<>(); // 결과를 담을 배열 생성
        while(!arr.isEmpty()){
            int deploy = arr.poll(); // 첫 번쨰 작업 완료일
            int count = 1;
            
            while(!arr.isEmpty() && arr.peek() <= deploy){  // Queue가 안 비어있고 이후에 배포일이 첫 번쨰 작업 완료일보다 작은지 체크
                arr.poll(); // 작으면 요소 제거
                count++;  // 배포된 작업 수 추가
            }
            
            answer.add(count);  // 배포된 작업 수 추가
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
// Math.ceil = 안에 있는 정수를 올림처리해서 반환
// Queue.poll = 가장 앞에 있는 값을 꺼내고 제거
// Queue.peek = 가장 앞에 있는 값을 꺼내고 제거하지 않음