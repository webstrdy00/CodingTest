import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        boolean[][] visited = new boolean[row][col];  // 방문 여부 체크
        List<Integer> days = new ArrayList<>(); // 각 섬의 머물수 있는 날짜들
        
        // 상하좌우 이동을 위한 범위 설정
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1};
        
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < col; ++j){
                if(!visited[i][j] && maps[i].charAt(j) != 'X'){   // 방문하지 않고 바다가 아닌경우 탐색 시작
                    days.add(bfs(maps, visited, i, j, dx, dy));   // bfs로 이용하여서 구하기
                }
            }
        }
        
        if(days.isEmpty()){   // 비어있으면 -1 리턴
            return new int[]{-1};
        }
        
        Collections.sort(days);  // 오름차순 정렬
        
        return days.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(String[] maps, boolean[][] visited, int startX, int startY, int[] dx, int[] dy){
        int row = maps.length;
        int col = maps[0].length();
        Queue<int[]> queue = new LinkedList<>(); 
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        int total = 0;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();   // 현재 위치 꺼내기
            int x = current[0];
            int y = current[1];
            
            total += maps[x].charAt(y) - '0';    // 현재 위치에 숫자 더하기
            
            for(int i = 0; i < 4; ++i){    // 상하좌우 탐색하기
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < row && ny >=0 && ny < col && !visited[nx][ny] && maps[nx].charAt(ny) != 'X'){  // 경계 조건 및 방문 여부 확인
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return total;
    }
}
// 오름차순 정렬, 무인도가 없으면 -1