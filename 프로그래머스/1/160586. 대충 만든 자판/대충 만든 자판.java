import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> minPress = new HashMap<>();
        for(String keys : keymap){
            for(int i = 0; i < keys.length(); ++i){
                char c = keys.charAt(i);
                int pressCount = i + 1;
                minPress.put(c, Math.min(minPress.getOrDefault(c, Integer.MAX_VALUE), pressCount));
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; ++i){
            String target = targets[i];
            int totalPress = 0;
            for(char c : target.toCharArray()){
                if(!minPress.containsKey(c)){
                    totalPress = -1;
                    break;
                }
                totalPress += minPress.get(c);
            }
            answer[i] = totalPress;
        }
        return answer;
    }
}
// 배열을 순서대로 돌면서 문자열을 하나씩 없애고 없애면 클릭한 숫자를 더하는 문제
// 1. keymap 