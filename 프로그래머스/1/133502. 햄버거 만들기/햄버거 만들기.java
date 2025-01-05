import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList();
        for(int i : ingredient){
            stack.add(i);
            if(stack.size() >= 4){
                int size = stack.size();
                if(stack.get(size - 4) == 1 && stack.get(size - 3) == 2 && stack.get(size - 2) == 3 && stack.get(size - 1) == 1){
                    for(int j = 0; j < 4; ++j){
                        stack.remove(stack.size() - 1);
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
// 1 = 빵, 2 = 야채, 3= 고기
// 1231 순서로 햄버거를 포장해야함, 무조건 1231이 붙어있어야 햄버거 포장 가능
// 스택 이용해서 배열에 내용을 순서대로 넣고 1231이 만들어지면 제거하고 answer에 1를 더하는 식으로 진행