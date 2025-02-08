class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l; i <= r; ++i){
            if(countOnes(n, i - 1)){
                answer++;
            }
        }
        return answer;
    }
    private boolean countOnes(int n, long index){
        if(n == 0){
            return true;
        }
        
        long length = (long) Math.pow(5, n -1);
        
        if((index / length) == 2){  // 3등분한 가운데 부분 (0이 들어감)
            return false;
        }
        
        return countOnes(n - 1, index % length); // 작은 패턴에서 재귀적으로 확인 
    }
}