class Solution {
    public long solution(int w, int h) {   
        long result = (long) w * h; // 총 정사각형에 갯수
        long result2 = w + h - gcd(w, h);   // 대각선이 지나가는 정사각형 갯수
        
        long answer = result - result2;   // 남은 정사각형에 갯수
        
        return answer;
    }
    private long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}