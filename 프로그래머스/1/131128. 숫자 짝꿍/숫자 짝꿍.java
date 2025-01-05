class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] countX = new int[10];
        int[] countY = new int[10];
        for(char c : X.toCharArray()){
            countX[c - '0']++;
        }
        for(char c : Y.toCharArray()){
            countY[c - '0']++;
        }
        
        StringBuilder str = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            int count = Math.min(countX[i], countY[i]);
            while(count-- > 0){
                str.append(i);
            }
        }
        
        if(str.length() == 0){
            return "-1";
        }
        
        answer = str.toString();
        if(answer.matches("0+")){
            return "0";
        }
        
        return answer;
    }
}
// 두 정수에서 공통으로 있는 숫자들을 뽑아서 그 숫자들 조합으로 제일 큰수를 만드는 문제
// 짝궁이 없으면 -1, 있으면 제일 큰수를 앞에 배치시켜서 조합하면 제일 큰수가 됨
// 1. 각 두 정수를 비교해서 공통 된 수가 있는지 비교하기 
// 2. 짝궁이 있는지 없는지 판단하기
// 3. 있으면 제일 큰수를 앞에 배치시켜서 조합시키기
// 4. 리턴하기