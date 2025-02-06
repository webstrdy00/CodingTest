import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<int[]> points = new ArrayList<>(); // 교점 저장 리스트
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        
        int n = line.length;
        for(int i = 0; i < n; ++i){     // 모든 직선 상의 교점 찾기
            for(int j = i + 1; j < n; ++j){
                long A1 = line[i][0], B1 = line[i][1], C1 = line[i][2];
                long A2 = line[j][0], B2 = line[j][1], C2 = line[j][2];
                
                long dis = A1 * B2 - A2 * B1;   // AD - BC = 0인 경우 두 직선은 평행 또는 일치
                if(dis == 0){   // 평행 또는 일치
                    continue;
                }
                
                long xNum = B1 * C2 - B2 * C1;
                long yNum = C1 * A2 - C2 * A1;
                
                if(xNum % dis != 0 || yNum % dis != 0){ // 정수가 아님
                    continue;
                }
                
                int x = (int) (xNum / dis);
                int y = (int) (yNum / dis);
                points.add(new int[]{x, y});
                
                // 최소, 최대 좌표 갱신
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        
        // 격자 만들기 (y축은 위에서 아래, x축은 왼쪽에서 오른쪽)
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        char[][] grid = new char[height][width];    // y기준으로 생성하는 이유 : 이차원 배열에서 row(행)을 먼저 출력하기 떄문에
        
        for(char[] row : grid){
            Arrays.fill(row, '.');
        }
        
        for(int[] point : points){
            int x = point[0] - minX;    // 좌 -> 우 로 설정해야 하기때문에
            int y = maxY - point[1];    // 위 -> 아 로 설정해야 하기때문에
            grid[y][x] = '*';
        }
        
        String[] answer = new String[height];
        for(int i = 0; i < height; ++i){
            answer[i] = new String(grid[i]);
        }
        
        return answer;
    }
}