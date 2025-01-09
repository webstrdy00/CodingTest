import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int i : tangerine){  // 귤 크기별 갯수 세기
            numMap.put(i, numMap.getOrDefault(i, 0) + 1);
        }
        
        // 저장된 갯수 기준으로 내림차순 정렬하기
        List<Integer> counts = new ArrayList<>(numMap.values());
        counts.sort(Collections.reverseOrder()); // 내림차순 정렬
        
        // 다른 종류 갯수 카운트 하기
        int sum = 0;
        for(int count : counts){
            sum += count;
            answer++;
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }
}
// 1. 배열을 정렬시키기
// 2. 제일 많은 숫자 찾기
// 3. 많은 숫자에 갯수를 더해서 k를 넘어가는지 확인
// 4. 넘어가면 숫자 갯수 return
// 5. 넘어가지 않으면 answer + 1하고 다음으로 많은 숫자 갯수 더하기
// 6. 넘어가는지 안넘어가는지 확인하는 작업 반복