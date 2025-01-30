import java.util.*;

class Solution {
    public List<int[]> moves; // 이동 경로를 저장할 리스트
    public int[][] solution(int n) {
        moves = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        return moves.toArray(new int[moves.size()][]);
    }
    
    private void hanoi(int n, int start, int end, int aux){
        if(n == 1){   // 원판이 1개일 경우
            moves.add(new int[]{start, end});
            return;
        }
        
        hanoi(n - 1, start, aux, end); // n-1개의 원판을 보조 기둥으로 이동
        
        moves.add(new int[]{start, end}); // 가장 큰 원판을 목적지로 이동
        
        hanoi(n - 1, aux, end, start); // n-1개의 원판을 보조 기둥에서 목적지로 이동
    }
}
// 이동 횟수 = 2^n - 1