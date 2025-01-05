import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for(int i = 0; i < answers.length;++i){
            if(student1[i%student1.length] == answers[i]){
                score1 += 1;
            }
            if(student2[i%student2.length] == answers[i]){
                score2 += 1;
            }
            if(student3[i%student3.length] == answers[i]){
                score3 += 1;
            }
        }
        
        int maxScore = Math.max(score1, Math.max(score2, score3));
        List<Integer> topStudents = new ArrayList<>();
        
        if(score1 == maxScore){
            topStudents.add(1);
        }
        if(score2 == maxScore){
            topStudents.add(2);
        }
        if(score3 == maxScore){
            topStudents.add(3);
        }
        
        Collections.sort(topStudents);
        return topStudents.stream().mapToInt(i -> i).toArray();
    }
}
// 문제에 답이 들은 배열에서 1,2,3 번 수포자에 방식으로 
// 수포자 방식이 반복되는 부분을 배열로 만들고 답이 들은 배열에 값들을 비교해서 맞추면 각각 점수를 하나씩 올리면 될듯