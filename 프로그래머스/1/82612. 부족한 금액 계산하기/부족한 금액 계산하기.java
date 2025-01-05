class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long result =0;
        for(int i = 1;i<=count;i++){
            result += (long)(price * i);
        }
        if(result < money){
            answer = 0;
        }else{
            answer = (long)(result - money);
        }

        return answer;
    }
}