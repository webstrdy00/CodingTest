class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int current = storey % 10; // 현재 자리수
            int nextCurrent = (storey / 10) % 10; // 다음 자리수
            
            if(current > 5){
                answer += 10 - current; // 6, 7, 8, 9는 더하기가 유리함
                storey += 10; // 올림
            }else if(current == 5 && nextCurrent >= 5){
                answer += 5;
                storey += 10;
            }else{  
                answer += current;  // 0, 1, 2, 3, 4는 뺴기가 유리함
            }
            storey /= 10; // 다음 자리로 이동
        }
        
        return answer;
    }
}