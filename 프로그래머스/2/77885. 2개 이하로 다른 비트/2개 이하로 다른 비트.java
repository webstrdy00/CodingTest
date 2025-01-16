class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; ++i){
            long num = numbers[i];
            
            if(num %2 == 0){   // 짝수인 경우 다음 숫자가 정답
                answer[i] = num + 1;
                continue;
            }
            
            // 홀수인 경우
            // 오른쪽부터 첫 번째 0을 찾아 1로 바꾸고, 
            // 그 바로 오른쪽 비트를 0으로 바꿈
            long rightOne = num & -num; // 가장 오른쪽 1의 위치
            long rightZero = ~num & (num + 1); // 가장 오른쪽 0의 위치
            answer[i] = num + rightZero - (rightZero >> 1);
        }
        
        return answer;
    }
}
// 짝수는 다음 수가 정답 f(x) = x + 1
// 홀수는 x의 가장 오른쪽 0을 1로 바꾸고 그 바로 오른쪽에 잇는 1를 0으로 바꾸고 찾아야함
// x ^ x+1 이게 XOR 연산임 (즉 두 비트를 더하는 연산, 한 자리라도 1이 있으면 1로 계산함) = 7 ^ 8 = 15