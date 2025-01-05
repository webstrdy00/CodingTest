import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> tempList = new ArrayList<>();
        
        for(int i = 0;i<numbers.length-1;i++){
            for(int j = i+1;j<numbers.length;j++){
                int result = numbers[i] + numbers[j];
                if(!tempList.contains(result)){
                    tempList.add(result);
                }
            }
        }
        
        int[] answer = tempList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}
// 안에 배열에 숫자를 순서대로 더해서 배열에 추가한뒤에 겹치는 숫자 제거하고 오른차순 배열시키면 될 듯