import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] answer = {0};  // 최대 탐험 수를 저장하는 변수 (재귀 호출 중에도 값 유지하도록 배열로 선언)
        boolean[] visited = new boolean[dungeons.length];  // 던전 반문 여부 확인
        
        exploreDungeons(k, dungeons, visited, 0, answer); // 모둔 순서를 탐색 (DFS 기반)
        
        return answer[0];
    }
    private void exploreDungeons(int k, int[][] dungeons, boolean[] visited, int count, int[] answer){
        answer[0] = Math.max(answer[0], count);  // 최대 탐험 수 갱신
        
        for(int i = 0; i < dungeons.length; ++i){
            if(!visited[i] && k >= dungeons[i][0]){   // 탐험 조건 확인(방문하지 않았고 필요 피로도보다 현재 피로도가 많을떄)
                visited[i] = true; // 던전 방문 처리
                exploreDungeons(k - dungeons[i][1], dungeons, visited, count + 1, answer);  // 다음 탐험 (재귀 호출)
                visited[i] = false; // 던전 방문 해제 (백트래킹)
            }
        }
    }
}
// DFS를 이용해서 문제를 해결해야함 -> 방문 여부 체크 필요