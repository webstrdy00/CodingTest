import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length();++i){
            String r = s.substring(i) + s.substring(0, i); // i 만큼 회전한 문자열
            Stack<Character> stack = new Stack<>(); 
            
            boolean isValid = true;
            for(char c : r.toCharArray()){
                if(c == '(' || c == '['|| c == '{'){
                    stack.push(c);  // 여는 괄호는 스택에 추가
                }else{
                    if(stack.isEmpty() ||    // 스택이 비어 있거나(시작할떄 닫는 괄호로 시작하기 떄문에 올바르지 못함)
                      (c == ')' && stack.pop() != '(') ||  // 닫는 괄호랑 매칭하는 과정
                      (c == '}' && stack.pop() != '{') ||
                      (c == ']' && stack.pop() != '[')){
                        isValid = false;
                        break;
                    }
                }
            }
            if(isValid && stack.isEmpty()){  
                answer++;
            }
        }
        return answer;
    }
}
// 1. 문자열을 왼쪽으로 x칸 만큼 