import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int w : weights){   
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for(int w : map.keySet()){
            long count = map.get(w);
            
            if(count > 1){   // 같은 무게일 떄 짝궁 조합 구하기
                answer += (count * (count -1)) / 2; 
            }
            
            if(map.containsKey(w * 2 / 3) && (w * 2) % 3 == 0){   // 비율조건(2 : 3) 만족하는 경우
                answer += count * map.get(w * 2 / 3);
            }
            if(map.containsKey(w * 2 / 4) && (w * 2) % 4 == 0){   // 비율조건(2 : 4) 만족하는 경우
                answer += count * map.get(w * 2 / 4);
            }
            if(map.containsKey(w * 3 / 4) && (w * 3) % 4 == 0){   // 비율조건 (3 : 4) 만족하는 경우
                answer += count * map.get(w  * 3 / 4);
            }
        }
        return answer;
    }
}