import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = n -1; i >= 0; --i){   // 맨 뒤 부터 반복
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){  // 스택이 비어있지 않고 뒤에 있는 숫자가 현재 숫자보다 작으면
                stack.pop();
            }
            
            if(stack.isEmpty()){   // 스택이 비어있으면 뒤에 큰 숫자가 없다는 의미
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]); // 현재 숫자를 스택에 추가
        }
        
        return answer;
    }
}
// 2중 for문을 사용하면 런타임 에러 발생
// stack을 사용해서 for문을 1개로 줄이면 런타임 에러 해결 가능