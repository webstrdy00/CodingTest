import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];   // 방문 처리 배열
        List<Integer> cycle = new ArrayList<>();
        
        for(int i = 0; i < n; ++i){
            if(!visited[i]){   // 아직 방문하지 않았을떄
                int count = 0;
                int current = i;
                
                while(!visited[current]){  // 이미 방문한 상자를 만날떄까지 반복
                    visited[current] = true;
                    current = cards[current] - 1;   // 상자에 맞는 인덱스를 찾아가기위해서 -1 실행
                    count++;
                }
                
                cycle.add(count);
            }
        }
        
        if(cycle.size() < 2){
            return 0;
        }
        
        cycle.sort(Collections.reverseOrder()); // 내림차순 정렬 후 상위 2개 곱하기
        return cycle.get(0) * cycle.get(1);
    }
}