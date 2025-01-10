import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> arr = new HashSet<>();  // 나올수 있는 숫자를 담는 배열 (HashSet으로 중복 제거)
        int n = elements.length;
        
        int[] circle = new int[n * 2]; // 원형 수열 = 기존에 배열을 2배로 늘리면 됨(시작과 끝이 만나야 하기떄문)
        for(int i = 0; i < n; ++i){  // 배열 확장 과정
            circle[i] = elements[i];
            circle[i + n] = elements[i];
        }
        for(int k = 1; k <= n; ++k){ // 연속 부분 수열 길이
            for(int i = 0; i < n; ++i){ // 배열 순회 시작하는 곳
                int sum = 0;
                for(int j = 0; j < k; ++j){  // 길이 k의 부분 수열에 합 계산
                    sum += circle[i + j];
                }
                arr.add(sum);
            } 
        }
        
        return arr.size();  // 배열에 크기 = 합의 갯수
    }
}
// 1. 배열을 만들고
// 2. 각 elements