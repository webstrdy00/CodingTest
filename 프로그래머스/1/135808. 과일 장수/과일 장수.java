import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] reverseScore = new int[score.length];
        int size = score.length / m;  // 4
        Arrays.sort(score);
        for(int i = 1; i <= score.length; ++i){
            reverseScore[i - 1] = score[score.length - i];
        }
        
        for(int i = 1; i <= size; ++i){
            answer += reverseScore[(i*m) - 1] * m;
        }
        return answer;
    }
}
// 그러면 최대 점수를 얻을 수 있는 방법 = 점수가 높은 사과끼리만 포장시켜서 파는 방법
// 그러면 점수가 높은 순서대로 정렬시키고 m개씩 잘라서 묶어서 판매한 금액 answer에 더하면 되는듯
// 제일 낮은 남은 사과는 버리고
// 444444222211