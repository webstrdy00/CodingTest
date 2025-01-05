import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] result = new int[k];
        int size = 0;
        for(int i = 0;i<score.length;i++){
            if(size < k){
                result[size++] = score[i];
                Arrays.sort(result, 0 ,size);
            }else{
                if(result[0]<score[i]){
                    result[0] = score[i];
                    Arrays.sort(result);
                }
            }
            answer[i] = result[0];
        }
        return answer;
    }
}
// k일까지는 최하의 점수를 발표하면 되는거고 그 다음일부터 추가할떄 k번째 점수를 발표하면 되는 시스템
// 그러면 k일 이후부터 점수가 최하 점수보다 적으면 그냥 버리고 높으면 k번째 숫자버리고 점수를 추가하면 될듯