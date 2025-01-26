import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; ++i){
            if(checkDistance(places[i])){     // 안전거리 지켰는지 확인하기
                answer[i] = 1;   // 지켰으면 1
            }else{
                answer[i] = 0; // 아니면 0
            }
        }
        
        return answer;
    }
    private boolean checkDistance(String[] place){
        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < 5; ++j){
                if(place[i].charAt(j) == 'P'){   // 사람이 앉아 있는 자리이면 
                    if(!isSafe(place, i, j)){   // 안전한지 판단
                        return false;  // 위반시 false 반환
                    }
                }
            }
        }
        return true;  // 거리두기가 모두지켰으면 true 반환
    }
    private boolean isSafe(String[] place, int x, int y){
        // 아래, 위, 왼쪽, 오른쪽 이동 정의
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[5][5]; // 방문 여부 확인
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});  // {x 위치, y 위치, 거리}
        visited[x][y] = true;  // 현재 위치 방문처리
        
        while(!queue.isEmpty()){
            int[] current = queue.poll(); // 현재 위치 꺼내기
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];
            
            if(distance > 2){
                continue;
            }
            if(distance > 0 && place[cx].charAt(cy) == 'P'){  // 현재 위치에 사람이 있으면 거리두기 실패
                return false;
            }
            
            for(int d = 0; d < 4; ++d){    // 위, 아래, 왼쪽, 오른쪽 이동시켜서 확인시키기
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if(nx >= 0 && nx < 5 && ny >=0 && ny < 5 && !visited[nx][ny] && place[nx].charAt(ny) != 'X'){   // 조건 확인하기
                    queue.offer(new int[]{nx, ny, distance + 1});  // 조건에 모두 충족하면 큐에 넣기
                    visited[nx][ny] = true;
                }
            }
        }
        return true;
    }
}