class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k); // n을 k진수로 변환
        
        String[] parts = s.split("0", -1); // 조건에 맞게 숫자 추출
        
        for(String part : parts){
            if(part.isEmpty()){  // 빈 문자열은 건너뛰게 설정
                continue;
            }
            long a = Long.valueOf(part); // long 형 변환(int 범위를 넘어 갈 수 있어서 long으로 형 변환)
            
            boolean isValid = true;
            if(a < 2){
                continue;
            }
            for(long i = 2; i * i <= a; ++i){
                if(a % i == 0){
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
}