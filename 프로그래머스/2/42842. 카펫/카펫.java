import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 1; i * i <= total; ++i){  
            if(total%i == 0){  // i가 total의 약수인 경우
                int j = total/i;  
                
                if(2 * i + 2 * (j - 2) == brown){ // 갈색 테두리 조건 확인
                    return new int[] {Math.max(i, j), Math.min(i, j)};  // 가로 >= 세로
                }
            }
        }
        return answer;
    }
}
// 전체 격자 = brown + yellow = 가로 x 세로
// brown = 2가로 + 2(세로 - 2) 
// [가로, 세로]