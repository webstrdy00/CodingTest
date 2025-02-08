class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dCap = 0, pCap = 0; // 배달, 수거할 트럭 용량
        
        for(int i = n -1; i >= 0; --i){
            int nDeliver = deliveries[i];
            int nPick = pickups[i];
            
            while(dCap < nDeliver || pCap < nPick){     // 한 번에 처리할 수 없으면 반복
                dCap += cap; // 트럭에 최대한 배달 짐 넣기
                pCap += cap; // 트럭에 최대한 수거 짐 넣기
                answer += (i + 1) * 2; // 왕복 
            }
            
            dCap -= nDeliver; // 배달 완료
            pCap -= nPick; // 수거 완료 
        }
        
        return answer;
    }
}
// 먼 곳부터 배달과 수거를 진행