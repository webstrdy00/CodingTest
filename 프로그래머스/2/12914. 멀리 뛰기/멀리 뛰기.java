class Solution {
    public long solution(int n) {
        if(n == 1){
            return 1;
        }
        
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n;++i){
            int temp = (a + b) % 1234567;
            a = b;
            b = temp;
        }
        
        return b;
    }
}
// f(n) = f(n -1) + f(n - 2)
// f(3) = 1 + 2 = 3
// f(4) = 3 + 2 = 5
// 이게 파보나치 수???