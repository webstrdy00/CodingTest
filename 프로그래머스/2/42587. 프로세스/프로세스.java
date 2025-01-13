import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> arr = new LinkedList<>(); // 우선순위를 담을 배열 생성
        for(int i = 0; i < priorities.length; ++i){
            arr.add(new int[] {priorities[i], i});  // [우선순위, 위치] 로 생성
        }
        
        while(!arr.isEmpty()){
            int[] first = arr.poll(); // 제일 앞에 있는 값을 추출
            boolean isValid = false;
            
            for(int[] process : arr){  // 나머지 프로세스 중에 더 높은 우선 순위가 있는지 확인
                if(process[0] > first[0]){
                    isValid = true;
                    break;
                }
            }
            
            if(isValid){ 
                arr.add(first);  // 더 높은 우선순위가 있으면 다시 Queue에 추가
            }else{ // 실행 가능한 경우
                answer++; // 실행 순서 증가
                if(first[1] == location){  // 목표하는 프로세스가 맞는지 확인
                    return answer;
                }
            }
        }
        return answer;
    }
}