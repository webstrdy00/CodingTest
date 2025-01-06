class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int original = s.length(); // 원래 길이  
            s = s.replace("0", ""); // 0 제거
            int newLength = s.length();  // 제거후 길이
            answer[1] += (original - newLength);  // 제거후 길이 - 원래 길이 = 제거된 0의 갯수
            
            s = Integer.toBinaryString(newLength); // 길이를 이진수로 변환
            
            answer[0]++;
            }
    
        return answer;
    }
}