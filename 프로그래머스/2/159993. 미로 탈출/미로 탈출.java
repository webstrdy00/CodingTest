import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int rows = maps.length;
        int cols = maps[0].length();
        int startX = 0, startY = 0; // S 위치
        int leverX = 0, leverY = 0; // L 위치
        int exitX = 0, exitY = 0; // E 위치
        
        for(int i = 0; i < rows; ++i){    // S, L, E 위치 찾기
            for(int j = 0; j < cols; ++j){
                if(maps[i].charAt(j) == 'S'){
                    startX = i;
                    startY = j;
                }else if(maps[i].charAt(j) == 'L'){
                    leverX = i;
                    leverY = j;
                }else if(maps[i].charAt(j) == 'E'){
                    exitX = i;
                    exitY = j;
                }
            }
        }
        
        int toLever = bfs(maps, startX, startY, leverX, leverY); // S -> L 최단 거리 찾기
        if(toLever == -1){   // 불가능할떄
            return -1;
        }
        
        int toExit = bfs(maps, leverX, leverY, exitX, exitY); // L -> E 최단 거리 찾기
        if(toExit == -1){  // 불가능할떄 
            return -1;
        }
        
        answer = toLever + toExit;  // 최단 거리
        
        return answer;
    }
    private int bfs(String[] maps, int startX, int startY, int endX, int endY){
        int rows = maps.length;
        int cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});  // {x좌표, y좌표, 이동거리} 
        visited[startX][startY] = true; 
        
        // 아래, 위, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            
            if(x == endX && y == endY){   // 목표 지점 도착
                return dist;
            }
            
            for(int i = 0; i < 4; ++i){  // 상하좌우 이동시키기
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols
                  && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;  // 도달 불가능
    }
}