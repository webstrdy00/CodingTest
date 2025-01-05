import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2];
        for(int i = 0; i < park.length; ++i){   // 시작 위치 찾기
            for(int j = 0; j < park[i].length(); ++j){
                if(park[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        
        Map<String, int[]> directions = Map.of(   // 각 명령에 대한 행동 정의하기
        "N", new int[]{-1, 0},
        "S", new int[]{1, 0},
        "W", new int[]{0, -1},
        "E", new int[]{0, 1}
        );
        
        for(String route : routes){   // 명령판단하기
            String[] parts = route.split(" ");
            String direction = parts[0];
            int distance = Integer.parseInt(parts[1]);
            
            int[] move = directions.get(direction);
            int newRow = start[0];
            int newCol = start[1];
            boolean canMove = true;
            for(int i = 1; i <= distance; ++i){
                newRow += move[0];
                newCol += move[1];
                
                if(newRow < 0 || newRow >= park.length || newCol < 0 || newCol >= park[0].length()){
                    canMove = false;
                    break;
                }
                
                if(park[newRow].charAt(newCol) == 'X'){
                    canMove = false;
                    break;
                }
            }
            
            if(canMove){
                start[0] = newRow;
                start[1] = newCol;
            }
        }
        return start;
    }
}
// 로봇 이동거리가 공원을 벗어나거나 장애물을 만나면 다음 명령 수행
// 가로 길이 W, 세로 길이 H
// 인덱스 길이 - 1이 최대 끝에서 끝 거리