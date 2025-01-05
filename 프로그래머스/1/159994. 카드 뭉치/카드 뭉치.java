import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int size1 = 0;
        int size2 = 0;
        for(int i = 0; i < goal.length; ++i){
            if(size1 < cards1.length && cards1[size1].equals(goal[i])){
                size1 += 1;
            }else if(size2 < cards2.length && cards2[size2].equals(goal[i])){
                size2 += 1;
            }else{
                answer = "No";
                return answer;                
            }
        }
        answer = "Yes";
        return answer;
    }
}
// cards1, cards2에 단어를 순서대로 꺼내서 goal에 문자열을 만드는 문제
// 그러면 각각의 문자열을 비교하고 그 순서에 있으면 꺼내서 goal 문자열 없애면 되는거네
// 그러면 각각 사이즈를 줘서 꺼내면 더하는 식으로 하고 만약에 꺼낼 수 없으면 answer에 no 넣어서 리턴시키면 될듯