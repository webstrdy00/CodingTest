import java.util.*;

class Solution {
    int n,m;
    int[][] map;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] ans = new int[queries.length];
        n = rows;
        m = columns;
        int num = 1;
        map = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){ // 행렬을 1부터 순서대로 채우기
            for(int j = 0 ; j < m ; j++){
                map[i][j] = num++;  // 숫자를 순서대로 채움
            }
        }
        
        int idx = 0; // 결과 배열의 인덱스
        for(int[] q : queries){
            int sr = q[0]-1;int sc = q[1]-1;
            int er = q[2]-1;int ec = q[3]-1;
            
            int minValue = rotate(sr,sc,er,ec); // 회전을 수행하고 최솟값을 구함
            ans[idx++] = minValue; // 결과 배열에 최솟값 저장
        }
        
        return ans;
    }
    int rotate(int sr,int sc,int er,int ec){ // 회전을 수행하고 최솟값을 반환하는 메서드
        int tmp = map[sr][sc];
        int min = map[sr][sc];
        
        int vl = er-sr; // 세로 길이 (행의 차이)
        int hl = ec-sc; // 가로 길이 (열의 차이)
        
        for(int i = 0 ; i < vl ; i++){ //좌
            min = Math.min(min, map[sr+1+i][sc]);
            map[sr+i][sc] = map[sr+1+i][sc]; // 아래쪽 값을 위로 이동
        }
        for(int i = 0 ; i < hl ; i++){ //하
            min = Math.min(min, map[er][sc+1+i]);
            map[er][sc+i] = map[er][sc+1+i]; // 오른쪽 값을 왼쪽으로 이동
        }
        for(int i = 0 ; i < vl ; i++){ //우
            min = Math.min(min, map[er-1-i][ec]);
            map[er-i][ec] = map[er-1-i][ec]; // 위쪽 값을 아래로 이동
        }
        for(int i = 0 ; i < hl ; i++){ //상
            min = Math.min(min, map[sr][ec-1-i]);
            map[sr][ec-i] = map[sr][ec-1-i]; // 왼쪽 값을 오른쪽으로 이동
        }
        map[sr][sc+1] = tmp;
        return min;
    }
}