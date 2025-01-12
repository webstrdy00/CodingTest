import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;  // 곱셈을 위해서 1로 초기화
        HashMap<String, Integer> newMap = new HashMap<>();
        for(int i = 0; i < clothes.length; ++i){  // 각 옷에 종류에 갯수를 구하는 과정
            newMap.put(clothes[i][1], newMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 각 옷 조합의 수 계산하기
        for(int i : newMap.values()){
            answer *= (i + 1);  // (의상 갯수 + 1 = 아무것도 착용하지 않는 경우 포함)
        }
        return answer - 1;  // 최소 한 가지는 착용해야함으로 1를 뻄
    }
}