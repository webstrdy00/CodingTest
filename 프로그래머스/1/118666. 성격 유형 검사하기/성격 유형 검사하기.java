import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for(int i = 0; i < survey.length; ++i){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int score = choices[i];
            
            if(score < 4){
                hashmap.put(first, hashmap.getOrDefault(first, 0) + (4 - score));
            }else if(score > 4){
                hashmap.put(second, hashmap.getOrDefault(second, 0) + (score - 4));
            }
        }
        
        StringBuilder result = new StringBuilder();
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        for(char[] c : types){
            char type1 = c[0];
            char type2 = c[1];
            int score1 = hashmap.getOrDefault(type1, 0);
            int score2 = hashmap.getOrDefault(type2, 0);
            
            if(score1 > score2){
                result.append(type1);
            }else if (score1 < score2){
                result.append(type2);
            }else{
                result.append(type1);
            }
        }
        
        return result.toString();
    }
}
// 사전상으로 RCJA가 더 빠름
// 그러면 RT, CF, JM, AN을 비교해서 점수가 높으쪽으로 성격유형을 결정하고 점수가 같으면 R C J A로 넣으면 될듯
// 숫자를 보고 4보다 큰지 작은지 판단하고 작으면 4 - 숫자 , 크면 숫자 - 4 를 더하면 될듯
// 그러면 해쉬맵으로 각 문자열 담고 choices가 4보다 큰지 작은지 판단해서 survey에 문자열에서 문자 뽑아서 해쉬맵안에 key찾아서 값을 추가하면될듯