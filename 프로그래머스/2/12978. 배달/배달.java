import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();   // 그래프를 인접 리스트로 변환
        for(int i = 0; i <= N; ++i){
            graph.add(new ArrayList<>());
        }
        for(int[] r : road){   // 인접 노드 연결시키기
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        
        // 거리 배열 및 우선순위 큐 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 모든 거리를 초기화
        dist[1] = 0; // 1번 마을부터 시작
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0}); // {마을 번호, 거리}
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int now = current[0];  // 현재 위치
            int nowDist = current[1];  // 현재 거리
            
            if(nowDist > dist[now]){  // 이미 처리한 경우 건너뜀
                continue;
            }
            
            for(int[] n : graph.get(now)){   // 현재 노드와 연결되어 있는 노드 가져오기
                int next = n[0];   // 연결되어 잇는 다음 노드
                int cost = n[1];   // 다음 노드에 걸리는 거리
                if(dist[next] > dist[now] + cost){   // 더 짧은 경로 발견시
                    dist[next] = dist[now] + cost;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        for(int i = 1; i <= N; ++i){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}