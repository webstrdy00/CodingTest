import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(lastSeen.containsKey(currentChar)){
                int lastIndex = lastSeen.get(currentChar);
                answer[i] = i - lastIndex;
            }else{
                answer[i] = -1;
            }
            lastSeen.put(currentChar, i);
        }
        
        return answer;
    }
}
// 각 문자열을 확인하고 앞에 안나오면 -1로 변환, 앞에 나오면 떨어진 칸만큼 숫자로 변환