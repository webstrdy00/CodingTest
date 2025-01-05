class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i< nums.length - 2; ++i){
            for(int j = i +1; j< nums.length - 1; ++j){
                for(int k = j +1; k < nums.length; ++k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    private boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); ++i){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
// 각 배열에 3가지 숫자를 순서대로 더한다음에 그 숫자가 소수이면 result에 1를 더하는 문제
// 숫자가 소수인것을 어떻게 알아낼것인가 -> 더한 배열로 나누어 진다면 소수가 아니고 아무리 나누어도 안나누어 지면 소수잖아
// 1를 제외하고 나머지 더한 숫자로 나누어서 나머지가 0이 되면은 그건 소수가 아님 근데 나머지 더한 숫자로 나누어서 나머지가 0이 안된다면 그건 소수가 맞음