class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int result = 0;
        for(int i = 0;i<number.length-2;i++){
            result = number[i];
            for(int j = i+1;j<number.length-1;j++){
                result += number[j];
                for(int s = j+1;s<number.length;s++){
                    result += number[s];
                    if(result == 0)
                        answer += 1;
                    result = number[i] + number[j];
                }
                result = number[i];
            }
        }
        
        return answer;
    }
}