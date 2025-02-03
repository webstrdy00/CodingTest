class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i <= r2; ++i){  // 한 영역에 정수가 몇개 있는지 계산
            long yMax = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));  // floor사용하여 내림 처리하여 y가 r2 내부에 있도록 
            long yMin = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));  // ceil사용하요 올림 처리하여 y가 r1을 벗어나도록 
            
            answer += (yMax - yMin + 1);
        }
         
        return answer * 4;  // 4개의 영역
    }
}