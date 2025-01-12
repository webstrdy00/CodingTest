import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int wantSize = 10; // number 원소값 = 10
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; ++i){  // 원하는 물품과 수량 HashMap 형태로 변경
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - wantSize; ++i){   
            HashMap<String, Integer> newMap = new HashMap<>();
            for(int j = i; j < i + wantSize; ++j){    // 지나간 날을 제외하고 새로운 배열 생성하는 과정
                newMap.put(discount[j], newMap.getOrDefault(discount[j], 0) + 1); 
            }
            
            boolean isValid = true;  
            for(String s : wantMap.keySet()){    // 원하는 물품 포함하는지 확인
                if(newMap.getOrDefault(s, 0) < wantMap.get(s)){   // 원하는 물품에 갯수보다 적게 있으면 불가능
                    isValid = false;
                    break;
                }
            }
            
            if(isValid){  // 원하는 물품이 모두 포함하고 있으면 answer에 값 추가
                answer++;
            }
        }
        return answer;
    }
}