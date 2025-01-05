import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int i = 0;i<sizes.length;i++){
            int width = Math.max(sizes[i][0], sizes[i][1]);  // 10  12  15  14  15
            int height = Math.min(sizes[i][0], sizes[i][1]);  // 7  3   8   7   5
            
            maxWidth = Math.max(maxWidth, width);  // 10    12  15  15  15
            maxHeight = Math.max(maxHeight, height);  // 7  7   8   8   8
        }
        
        answer = maxWidth * maxHeight;
        
        return answer;
    }
}

// width = 80, height = 30
// 

// 명함의 최대 크기보다는 지갑의 크기가 크고 그중에 제일 작은 지갑크기를 구하기
// 1. 명함의 최대 크기 구하기 
// 2. 명함의 최대 크기보다 큰 지갑 중에 제일 작은 지갑크기 구하기 