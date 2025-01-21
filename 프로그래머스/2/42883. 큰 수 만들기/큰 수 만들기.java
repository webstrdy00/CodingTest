import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(); // 결과 저장
        int length = number.length();
        
        for(int i = 0; i < length; ++i){
            char current = number.charAt(i); // 현재 숫자
            
            // k > 0이고 현재 숫자가 스택의 마지막 숫자보다 크면 제거
            while(k > 0 && answer.length() > 0 && answer.charAt(answer.length() - 1) < current){
                answer.deleteCharAt(answer.length() - 1);  // 마지막 숫자 제거
                k--;
            }
            
            answer.append(current); // 현재 숫자 결과에 추가
        }
        
        if(k > 0){  // 아직 K번 제거하지 않았으면 제거
            answer.deleteCharAt(answer.length() - k); // 뒤에서 k까지 제거
        }
        
        return answer.toString();
    }
}