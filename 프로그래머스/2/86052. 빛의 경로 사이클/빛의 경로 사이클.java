import java.util.*;

class Solution {
    private int rows, cols;
    private boolean[][][] visited;  // {행, 열, 방향} 방문 여부
    private int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상우하좌
    private char[][] grid;
    
    public int[] solution(String[] grids) {
        rows = grids.length;
        cols = grids[0].length();
        grid = new char[rows][cols];
        visited = new boolean[rows][cols][4];
        
        for(int i = 0; i < rows; ++i){  // 문자열 배열을 2D 문자 배열로 벼환
            grid[i] = grids[i].toCharArray();
        }
        
        List<Integer> cycles = new ArrayList<>();
        
        for(int r = 0; r < rows; ++r){
            for(int c = 0; c < cols; ++c){
                for(int d = 0; d < 4; ++d){
                    if(!visited[r][c][d]){
                        cycles.add(getLength(r, c, d));
                    }
                }
            }
        }
        
        Collections.sort(cycles);   // 오름차순 정렬
        
        return cycles.stream().mapToInt(i -> i).toArray();
    }
    private int getLength(int r, int c, int d){
        int length = 0;
        while(!visited[r][c][d]){
            visited[r][c][d] = true;
            length++;
            
            d = changeDir(grid[r][c], d); // 현재 칸에서 방향 변화 적용
            
            // 다음 위치 계산 (격자 벗어날떄도 대비)
            r = (r + dir[d][0] + rows) % rows;
            c = (c + dir[d][1] + cols) % cols;
        }
        
        return length;
    }
    private int changeDir(char type, int d){
        if(type == 'S'){
            return d;   // 직진
        }
        if(type == 'L'){
            return (d + 3) % 4; // 시계 반향
        }
        return (d + 1) % 4; // 반 시계 반향
    }
}