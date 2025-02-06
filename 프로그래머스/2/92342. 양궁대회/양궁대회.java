import java.util.*;

class Solution {
    int[] answer = {-1};
    int maxDiff = 0;
    int n;
    public int[] solution(int n, int[] info) {
        this.n = n;
        int[] ryan = new int[11];
        dfs(0, 0, ryan, info);
        
        return answer;
    }
    private void dfs(int index, int count, int[] ryan, int[] info){
        if(index == 11 || count == n){  // 모든 점수를 탐색했거나 화살을 다 사용했을때
            int[] newRyan = Arrays.copyOf(ryan, 11);
            newRyan[10] += (n - count); // 남은 화살 0점에 넣어버리기
            
            int ryanScore = 0, appeachScore = 0;  // 라이언과 어피치 스코어
            for(int i = 0; i < 11; ++i){
                if(info[i] == 0 && newRyan[i] == 0){    // 둘다 못맞혔을 경우 스킵
                    continue;
                }
                if(newRyan[i] > info[i]){   // 라이언이 화살을 더 많이 맞혔을 경우
                    ryanScore += (10 - i);
                }else{
                    appeachScore += (10 - i);
                }
            }
            
            if(ryanScore > appeachScore){   // 라이언 점수가 더 클 경우
                int diff = ryanScore - appeachScore;
                if(diff > maxDiff || (diff == maxDiff && isBetterChoice(newRyan))){ // 점수가 더 높거나 점수가 같은데 낮은 숫자에 화살을 더많이 꽂은 경우 갱신
                    maxDiff = diff;
                    answer = newRyan;
                }
            }
            return;
        }
        
        dfs(index + 1, count, ryan, info);  // 화살을 쏘지 않는 경우
        
        if(count + info[index] + 1 <= n){   // 어피치보다 해당 점수에 더 많은 화살을 쏘는 경우
            ryan[index] = info[index] + 1;
            dfs(index + 1, count + ryan[index], ryan, info);
            ryan[index] = 0; // 원상복구
        }
    }
    private boolean isBetterChoice(int[] newRyan){  // 더 낮은 점수를 맞혔는지 확인하는 메서드
        for(int i = 10; i >= 0; --i){
            if(newRyan[i] > answer[i]){
                return true;
            }
            if(newRyan[i] < answer[i]){
                return false;
            }
        }
        return false;
    }
}