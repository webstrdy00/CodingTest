class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int sum = 0;  // 현재 부분 수열의 합
        int start = 0, end = 0;  // 시작, 끝 인덱스
        int minLength = Integer.MAX_VALUE; // 최소 길이 저장
        
        while(end < n){   // 모든 배열을 모두 돌떄까지 반복
            sum += sequence[end];  // 현재 합에 끝에 값을 추가
            
            while(sum >= k){    // 현재 합이 K이 이상일떄 start 포인터를 이동하면서 처리
                if(sum == k){    // 합이 k와 같고 더 짧은 인덱스를 발견하면 갱신
                    int length = end - start + 1;
                    if(length < minLength){
                        minLength = length;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                sum -= sequence[start];   // satrt 포인터를 이동시키면서 합을 줄임
                start++;
            }
            end++;
        }
        
        return answer;
    }
}
// [시작 인덱스, 마지막 인덱스] 리턴
// 투 포인터 활용