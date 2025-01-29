import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> {  // 정렬 수행
            if(a[col - 1] == b[col -1]){   // col번째 값이 같으면
                return Integer.compare(b[0], a[0]); // 첫번쨰 칼럼 기준으로 내림차순 정렬
            }
            return Integer.compare(a[col -1], b[col - 1]); // col 번쨰 기준으로 오름차순 정렬
        });
        
        for(int i = row_begin - 1; i < row_end; ++i){  // row_begin ~ row_end 까지의 범위
            int S_i = 0;
            for(int value : data[i]){
                S_i += value % (i + 1); // (각 원소 % i)의 합
            }
            answer ^= S_i; // XOR 연산 수행
        }
        
        return answer;
    }
}
// col번째 컬럼을 기준으로 오름차순 정렬
// col번째 값이 같으면 첫번쨰 값 기준으로 내림차순 정렬
// col 번쨰 오름차순 정렬 -> 기본키 기준 내림차순 정렬
// XOR 연산 -> 비트단위 연산으로 같으면 0, 다르면 1