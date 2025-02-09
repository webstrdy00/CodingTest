class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; ++i){
            int a = balls[i][0]; // 목표 공 x 좌표
            int b = balls[i][1]; // 목표 공 y 좌표
            
            int minDist = Integer.MAX_VALUE;
            
            int[][] redis = {
                {-startX, startY},  // 왼쪽 벽 반사
                {2 * m - startX, startY},   // 오른쪽 벽 반사
                {startX, -startY},  // 아래쪽 벽 반사
                {startX, 2 * n - startY}    // 위쪽 벽 반사
            };
            
            for(int j = 0; j < 4; ++j){
                int rx = redis[j][0];
                int ry = redis[j][1];
                
                // 벽을 맞기 전에 목표 공에 맞는 것은 제외
                if(startX == a && ((j == 2 && startY > b) || (j == 3 && startY < b))){   // 아래쪽 벽과 위쪽 벽 반사 불가능
                    continue;
                }
                
                if(startY == b && ((j == 0 && startX > a) || (j == 1 && startX < a))){  // 왼쪽 벽과 오른쪽 벽 반사 불가능
                    continue;
                }
                
                int distance = (rx - a) * (rx - a) + (ry - b) * (ry - b);   // 거리 제곱 계산
                minDist = Math.min(minDist, distance);
            }
            
            answer[i] = minDist;
        }
        
        return answer;
    }
}