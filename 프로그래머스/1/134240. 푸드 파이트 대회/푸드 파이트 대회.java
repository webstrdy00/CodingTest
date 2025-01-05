import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1;i<food.length;++i){
            int result = food[i]/2;
            answer += String.valueOf(i).repeat(result);
        }
        String reAnswer = new StringBuilder(answer).reverse().toString();
        
        answer = answer + "0" + reAnswer;
        
        return answer;
    }
}
// food[0] 은 무조건 1 그러면 제외시키고 진행하고
// 그러면 각 음식을 공평하게 나누기위해서 2로 나누어서 나온 몫을 각각 배치하면 될듯
// 그리고 배열에 가운데에 0을 추가하면 될듯
// 그러면 먼저 배열로 각 음식을 먼저 정순서로 배치시키고 반전시켜서 배열하나더 만들고 두 배열을 합치기 전에 0을 넣고 합치면 만들어질듯