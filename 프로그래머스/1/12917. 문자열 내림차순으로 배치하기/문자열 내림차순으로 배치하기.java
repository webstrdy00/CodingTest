import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str);
        }
        answer = sb.toString().trim();
        return answer;
    }
}