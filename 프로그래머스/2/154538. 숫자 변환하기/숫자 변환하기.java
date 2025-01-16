import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];  // 방문 체크 배열 생성
        Queue<int[]> queue = new LinkedList<>(); // [현재 값, 연산 횟수]
        
        queue.add(new int[]{x, 0}); 
        visited[x] = true;
        
        while(!queue.isEmpty()){  // 큐가 비어있지 않으면 실행
            int[] current = queue.poll(); // 현재 위치 확인
            int value = current[0];
            int count = current[1];
            
            if(value == y){
                return count;
            }
            
            int[] nextValue = {value + n, value * 2, value * 3};
            for(int next : nextValue){ 
                if(next <= y && !visited[next]){   // 다음 숫자가 y보다 작고 방문하지 않았을떄 진행
                    visited[next] = true;
                    queue.add(new int[] {next, count + 1});
                }
            }
        }
        
        return -1;
    }
}
// BFS을 이용해서 문제 해결