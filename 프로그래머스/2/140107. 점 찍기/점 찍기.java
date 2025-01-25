class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int x = 0; x <= d; x += k){    // x를 0부터 d까지 k만큼 증가
            long maxY = (long)Math.sqrt((long) d * d - (long)x * x);  // 현재 x에서 가능한 y 값 계산 (제곱근 계산)
            answer += (maxY / k) + 1;   // y의 가능한 점 갯수 계산
        }
        
        return answer;
    }
}