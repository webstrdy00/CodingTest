class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; ++i){
            if(!visited[i]){
                dfs(i, computers, visited); // 연결된 컴퓨터 방문 처리
                answer++;
            }
        }
        
        return answer;
    }
    private void dfs(int i, int[][] computers, boolean[] visited){
        visited[i] = true;
        for(int next = 0; next < computers.length; ++next){ // 현재 컴퓨터랑 연결된 다른 컴퓨터 확인
            if(computers[i][next] == 1 && !visited[next]){  // 연결되어있고 아직 방문 안했으면 진행
                dfs(next, computers, visited);
            }
        }
    }
}