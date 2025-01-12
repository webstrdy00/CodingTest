import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1); // 결과에 필요한 크기
        int[] result = new int[size]; // 결과에 필요한 만큼만 배열 생성
        
        int idx = 0; // result 인덱스 번호
        for(long i = left; i <= right;++i){   // 필요한 부분 직접 계산하는 과정
            int row = (int) (i/n); // 행 번호
            int col = (int) (i%n); // 열 번호
            result[idx++] = Math.max(row+1, col+1); // 값 계산
        }
        
        return result;
    }
}
// row = i/n 행 번호
// col = i%n 열 번호