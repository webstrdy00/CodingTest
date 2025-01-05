class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            int result = (n/a) * b; 
            n = n%a;
            answer += result;
            n += result;
        }
        return answer;
    }
}
// n에 계속 몫과 나머지를 더한 값을 넣고 n이 a보다 작아지면 멈추게 while문을 작성하면 될듯
// 그리고 answer에 몫 값을 계속 더하면 최종으로 받은 콜라수가 되겠지