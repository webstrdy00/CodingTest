class Solution {
    public int solution(String word) {
        int answer = 0;
        char[] words = {'A', 'E', 'I', 'O', 'U'};  // 알파벳 모음 배열
        int[] weights = {781, 156, 31, 6, 1};  // 각 자리별 단어 갯수
        
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i); // 현재 자리의 단어
            int index = findIndex(words, c); // 단어의 인덱스 구하기
            answer += index * weights[i] + 1; // 자리별 단어 갯수 계산
        }
        
        return answer;
    }
    private int findIndex(char[] words, char c){
        for(int i = 0; i < words.length; ++i){
            if(words[i] == c){
                return i;
            }
        }
        return -1; // 없을 경우
    }
}
// 단어 위치 = 단어 순서 * (5의 5-n승) 자리별로 반복
// I 가 1563번째 인 이유 = 2(단어 순서) * (5의 4승) + 1 = 2 * 781 + 1 = 1563
// EIO = (1 * 781 + 1)+ (2 * 156 + 1) + (3 * 31 + 1) = 782 + 313 + 94 = 1095 + 94 = 1189