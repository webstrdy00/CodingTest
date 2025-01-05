class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = 0;
        int min = 0;
        for(int i = 1;i<=(n*m);i++){
            if(n%i == 0 && m%i == 0){
                if(i > max)
                    max = i;
            }
            if(i%n == 0 && i%m == 0){
                min = i;
                break;
            }
        }
        answer[0] = max;
        answer[1] = min;
        return answer;
    }
}