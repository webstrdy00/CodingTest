class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int result = n % 3;
            sb.insert(0, result);
            n /= 3;
        }
        sb.reverse();
        int length = sb.length();
        for(int i=0;i<length;i++){
            char digit = sb.charAt(length -1 -i);
            answer += (digit - '0') * Math.pow(3, i);
        }
        return answer;
    }
}