import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] arr = s.split(" ", -1);  // 공백을 유지하면서 split 수행
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < arr.length; ++i){
            String r = arr[i];
            if(!r.isEmpty()){
                char firstChar = r.charAt(0);
                if('a' <= firstChar && firstChar <= 'z'){
                    firstChar = Character.toUpperCase(firstChar);
                }
                String result = firstChar + r.substring(1);
                answer.append(result);
            }
            
            if(i < arr.length -1){
                answer.append(" ");  // 단어 사이에 공백 추가
            }
        }
        
        return answer.toString();
    }
}