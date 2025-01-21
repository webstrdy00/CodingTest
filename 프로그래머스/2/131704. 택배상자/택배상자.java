import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();   // 기존 컨테이너 배열
        Stack<Integer> stack = new Stack<>();   // 보조 컨테이너 배열
        for(int i = 1; i <= order.length; ++i){   // 기존 컨테이너 큐의 값 넣기
            queue.add(i);
        }
        
        int index = 0;  // order 배열에 인덱스를 가리킴
        
        while(!queue.isEmpty() || !stack.isEmpty()){
            if(!queue.isEmpty() && queue.peek() == order[index]){   // 기존 컨테이너 확인
                queue.poll(); // 트럭에 넣는 작업
                answer++;
                index++;
            }else if(!stack.isEmpty() && stack.peek() == order[index]){  // 보조 컨테이너 확인
                stack.pop(); // 트럭에 넣는 작업
                answer++;
                index++;
            }else if(!queue.isEmpty()){  // 값이 다르면 보조 컨테이너로 이동
                stack.push(queue.poll()); 
            }else{   // 더 이상 진행할 수 없으면 종료
                break;
            }
        }
        return answer;
    }
}
// 기존 컨테이너 = queue
// 보조 컨테이너 = stack