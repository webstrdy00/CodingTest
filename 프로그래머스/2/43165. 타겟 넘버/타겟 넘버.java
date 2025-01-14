class Solution {
    public int solution(int[] numbers, int target) {
        int[] answer = {0};
        
        exploreNumbers(numbers, target, 0, 0, answer); // 모든 순서 탐색
        
        return answer[0];
    }
    private void exploreNumbers(int[] numbers, int target, int count, int size, int[] answer){
        if(size != numbers.length){   // 아직 모든 숫자를 돌지 않았다면
            exploreNumbers(numbers, target, count - numbers[size], size + 1, answer);  // 현재 숫자를 뺸 경우
            exploreNumbers(numbers, target, count + numbers[size], size + 1, answer);  // 현재 숫자를 더한 경우
        }else{  // 모든 숫자를 돌았다면
            if(count == target){   // count와 target 숫자가 같다면
                answer[0]++; // 경우의 수 1 증가
            }
        }
    }
}