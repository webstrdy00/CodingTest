import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long intP = Long.parseLong(p);
        int count = p.length();
        
        for(int i = 0;i <= t.length()-count;i++){
            String subArr = t.substring(i, i+count);
            long subInt = Long.parseLong(subArr);
            
            if(subInt <= intP)
                answer++;
        }
        
        return answer;
    }
}