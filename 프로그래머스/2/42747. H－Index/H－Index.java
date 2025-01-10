import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오른차순 정렬
        int n = citations.length; 
        
        for(int i = 0; i < n; ++i){
            int h = n - i; // 현재 h 값 = 논문 개수
            if(citations[i] >= h){  // 인용 횟수 >= h
                return h;
            }
        }
        
        return 0;
    }
}
// n = 배열 크기
// h = 인용된 논문 갯수와 횟수 
// h가 겹치는 제일 큰수를 뽑는 문제
// 1. 인용된 논문 갯수를 뽑고
// 2. size를 늘리면서 그 논문 인용된 횟수가 size보다 큰지 확인하기
// 3. 역정렬해서 푸는게 좋을 듯
// [0, 1, 3, 5, 6]