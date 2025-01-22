class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sumQueue1 = 0, result = 0;
        for(int num : queue1){
            sumQueue1 += num;
        }
        for(int num : queue2){
            result += num;
        }
        result += sumQueue1;
        
        if(result % 2 != 0){  // 합이 홀수면 달성 불가능
            return -1;
        }
        
        long target = result / 2;
        
        int n = queue1.length;
        int[] queueArr = new int[n * 2]; // 두 큐를 합치기 위한 배열 생성
        for(int i = 0; i < n; ++i){  // 배열에 두 배열에 값을 넣는 과정
            queueArr[i] = queue1[i];
            queueArr[i + n] = queue2[i];
        }
        
        int start = 0, end = n -1;  // 투 포인트 설정
        long sum = sumQueue1;   // queue1에 초기 합 설정
        
        while(start < n *2 && end < n * 2){
            if(sum == target){  // 목표 달성시
                return answer;
            }
            if(sum < target){ // 합이 작으면 end을 오른쪽으로 이동
                end++;
                if(end < n * 2){
                    sum += queueArr[end];
                }
            } else{  // 합이 크면 start를 오른쪽으로 이동
                sum -= queueArr[start];
                start++;
            }
            answer++; // 이동 횟수 증가
        }
        
        return -1;
    }
}