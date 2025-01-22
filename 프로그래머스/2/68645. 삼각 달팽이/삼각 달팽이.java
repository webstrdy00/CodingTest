class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n]; // 삼각형을 표현할 2차원 배열
        int num = 1; // 채울 숫자
        int row = 0, col = 0; // 현재 위치
        int maxNum = n * (n + 1) / 2; // 삼각형에 채울 총 숫자 개수
        int direction = 0; // 방향: 0 = 아래, 1 = 오른쪽, 2 = 대각선 위
        
        int[] dr = {1, 0, -1};  // 행 이동
        int[] dc = {0, 1, -1};  // 열 이동
        
        while(num <= maxNum){
            triangle[row][col] = num++; // 현재 위치 숫자 채우기
            
            // 다음 위치 계산
            int nextRow = row + dr[direction]; 
            int nextCol = col + dc[direction];
            
            // 범위를 벗어나거나 이미 숫자가 채워져 있는 경우
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || triangle[nextRow][nextCol] != 0){   
                direction = (direction + 1) % 3; // 방향 전환
                nextRow = row + dr[direction];
                nextCol = col + dc[direction];
            }
            
            // 위치 갱신
            row = nextRow;
            col = nextCol;
        }
        
        int[] answer = new int[maxNum];
        int idx = 0;
        for(int i = 0; i < n; ++i){    // 결과를 1차원 배열로 변환하는 과정
            for(int j = 0; j <= i; ++j){  // 삼각형 모양에 해당하는 부분만 추출
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}
// 총 숫자 = 1 ~ n 까지 더한 숫자