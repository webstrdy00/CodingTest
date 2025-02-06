import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1])); // 미사일 종료 지점 기준으로 오름차순 정렬
        
        int end = -1;    // 발사한 미사일 x좌표
        
        for(int[] target : targets){
            int s = target[0];  // 시작 지점
            int e = target[1];  // 끝나는 지점
            
            if(s >= end){   // 현재 미사일로 한번더 막을 수 있는 지 확인
                answer++;
                end = e;
            }
        }
        
        return answer;
    }
}