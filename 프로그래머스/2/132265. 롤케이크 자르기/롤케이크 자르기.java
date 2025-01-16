import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> firstMap = new HashMap<>();  // 철수 토핑을 담을 배열
        HashMap<Integer, Integer> secondMap = new HashMap<>();  // 동생 토핑을 담을 배열
        
        for(int t : topping){   // 처음에 모든 토핑을 동생 배열에 담음
            secondMap.put(t, secondMap.getOrDefault(t, 0) + 1); 
        }
        
        for(int t : topping){
            firstMap.put(t, firstMap.getOrDefault(t, 0) + 1); // 철수에게 토핑을 추가
            
            secondMap.put(t, secondMap.get(t) - 1);  // 동생 배열에서 토핑 제거
            if(secondMap.get(t) == 0){ // 동생 배열에서 해당 토핑에 갯수가 0이면 제거
                secondMap.remove(t);  
            }
            
            if(firstMap.size() == secondMap.size()){  // 철수 토핑 갯수와 동생 토핑 갯수가 같으면 결과에 1 추가
                answer++;
            }
        }
        
        return answer;
    }
}
// 토핑의 가짓수가 같으면 똑같이 나눠진거