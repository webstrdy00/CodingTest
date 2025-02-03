class Solution {
    private int answer = 0;
    private int[] queens;
    public int solution(int n) {
        queens = new int[n];  // n개의 행 (각 행에 놓인 퀸의 열 위치 저장)
        backtrack(0, n);
        
        return answer;
    }
    private void backtrack(int row, int n){
        if(row == n){   // n개의 퀸 모두 배치 완료
            answer++;
            return;
        }
        
        for(int i = 0; i < n; ++i){
            if(isSafe(row, i)){  // 현재 (row, i)에 퀸을 놓을 수 있는지 확인
                queens[row] = i;
                backtrack(row + 1, n); // 다음 행 탐색
            }
        }
    }
    private boolean isSafe(int row, int col){
        for(int prevRow = 0; prevRow < row; ++prevRow){
            int prevCol = queens[prevRow];    // 이전 행에 놓인 퀸에 열 위치 확인
            
            if(prevCol == col){  // 같은 열에 퀸이 있는 경우
                return false;
            }
            
            if(Math.abs(prevRow - row) == Math.abs(prevCol - col)){   // 대각선 체크 (row1 - row2 == col1 - col2 같은 열)
                return false;
            }
        }
        return true;
    }
}