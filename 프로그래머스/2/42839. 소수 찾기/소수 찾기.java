import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>(); // 생성할 수 있는 모든 숫자를 담을 set
        
        addInt("", numbers, set);
        
        for(int num : set){   // 값 전부를 돌면서 소수가 맞는지 판단하는 과정
            boolean isValid = true;
            if(num < 2){
                continue;
            }
            for(int i = 2; i * i <= num; ++i){   // 소수인지 판단하는 과정
                if(num % i == 0){  
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                answer++;
            }
        }
        
        return answer;
    }
    private void addInt(String prefix, String remain, HashSet<Integer> set){
        if(!prefix.isEmpty()){  // 현재 생성된 숫자가 비어있지 않으면 set에 추가
            set.add(Integer.valueOf(prefix));
        }
        for(int i = 0; i < remain.length(); ++i){  // 남아있는 숫자를 모두 진행할떄 까지 진행
            addInt(prefix + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1), set);   // 현재 추가한 i 번째 숫자를 제외하고 제귀함수 호출
        }
    }
}