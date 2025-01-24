import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> graph = new ArrayList<>();   // 그래프 생성
        for(int i = 0; i <= n; ++i){
            graph.add(new ArrayList<>());
        }
        for(int[] wire : wires){  // 전선 정보로 양방향 그래프 생성
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires){  // 전선 하나씩 끊어보기
            int v1 = wire[0], v2 = wire[1];
            
            // 간선 끊어 보기
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));
            
            // 네트워크 크기 계산
            int networkSize1 = bfs(graph, v1, n);
            int networkSize2 = n - networkSize1;
            
            answer = Math.min(answer, Math.abs(networkSize1 - networkSize2)); // 두 네트워크의 차이 계산 및 최솟값 갱신
            
            // 다시 복구 시키기
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return answer;
    }
    private int bfs(List<List<Integer>> graph, int start, int n){  // 네트워크 크기 계산
        boolean[] visited = new boolean[n + 1];   // 방문여부 체크
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);  // 시작 노드 큐에 저장
        visited[start] = true;
        
        int count = 0; // 네트워크 크기
        while(!queue.isEmpty()){
            int node = queue.poll(); // 현재 노드 가져오기
            count++;
            
            for(int s : graph.get(node)){   // 현재 노드와 연결된 노드들 탐색
                if(!visited[s]){  // 방문하지 않았다면 진행
                    visited[s] = true;   
                    queue.add(s);  
                }
            }
        }
        return count;
    }
}