import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2]; // 사용할 수 있는 곡갱이 수
        int totalGroups = (int) Math.ceil(minerals.length / 5.0); // 5개씩 그룹했을떄 그룹 갯수
        
        int groupCount = Math.min(totalGroups, totalPicks); // 사용할 곡갱이 갯수 구하기
        
        List<int[]> groups = new ArrayList<>();  
        
        for(int i = 0; i < groupCount; ++i){     // 그룹에 각 광물 종류 갯수 구하는 과정
            int[] count = new int[3]; // {다이아, 철, 돌}
            for(int j = i * 5; j < Math.min(minerals.length, (i + 1) * 5); ++j){
                if(minerals[j].equals("diamond")){
                    count[0]++;
                }else if(minerals[j].equals("iron")){
                    count[1]++;
                }else{
                    count[2]++;
                }
            }
            groups.add(count);
        }
        
        groups.sort((a, b) -> {   // 피로도 크기 순서대로 정렬
            if(a[0] != b[0]){
                return b[0] - a[0]; // 다이아 많은 순서
            }
            if(a[1] != b[1]){
                return b[1] - a[1]; // 철 많은 순서
            }
            return b[2] - a[2]; // 돌 많은 순서
        });
        
        for(int[] group : groups){   // 피로도 큰 순서부터 시작
            if(picks[0] > 0){   // 다이아 곡갱이 남아 있을 경우
                answer += group[0] + group[1] + group[2];    // 모든 광물 피로도 1
                picks[0]--;
            }else if(picks[1] > 0){  // 철 곡갱이 남아 있을 경우
                answer += group[0] * 5 + group[1] + group[2]; 
                picks[1]--;
            }else if(picks[2] > 0){ 
                answer += group[0] * 25 + group[1] * 5 + group[2]; 
                picks[2]--;
            }
        }
        
        return answer;
    }
}