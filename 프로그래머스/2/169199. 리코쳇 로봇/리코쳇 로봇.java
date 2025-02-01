import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int rows = board.length;
        int cols = board[0].length();
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;
        
        for(int i = 0; i < rows; ++i){    // 시작 지점과 목표 지점 좌표 찾기
            for(int j = 0; j < cols; ++j){
                if(board[i].charAt(j) == 'R'){
                    startX = i;
                    startY = j;
                }else if(board[i].charAt(j) == 'G'){
                    goalX = i;
                    goalY = j;
                }
            }
        }
        
        answer = bfs(board, startX, startY, goalX, goalY);
        
        return answer;
    }
    private int bfs(String[] board, int startX, int startY, int endX, int endY){
        int rows = board.length;
        int cols = board[0].length();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0}); // {X좌표, Y좌표, 이동 횟수}
        visited[startX][startY] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], count = current[2];
            
            if(x == endX && y == endY){
                return count;
            }
            
            for(int i = 0; i < 4; ++i){
                int nx = x;
                int ny = y;
                
                // 장애물이나 벽을 만나기 전까지 진행
                while(nx >= 0 && nx < rows && ny >= 0 && ny < cols && board[nx].charAt(ny) != 'D'){ 
                    nx += dx[i];
                    ny += dy[i];
                }
                
                // 장애물을 만나기 직전으로 돌리기
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]){   // 방문한적 없으면 진행
                    queue.offer(new int[]{nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}