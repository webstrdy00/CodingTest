import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> filter = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        for(char c : alphabet.toCharArray()){
            if(!skip.contains(String.valueOf(c))){
                filter.add(c);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(char c : s.toCharArray()){
            int currentIndex = filter.indexOf(c);
            int newIndex = (currentIndex + index) % filter.size();
            answer.append(filter.get(newIndex));
        }
        return answer.toString();
    }
}
// 배열 안에 소문자들을 skip에 들어 잇는 소문자면 패스시키고 배열 만들기 -> 
// 1. 소문자 영어 배열을 만들기
// 2. 배열 만들떄 skip안에 있는 소문자 제외시키고 만들기
// 3. index 만큼 s에 소문자들을 배열을 통해서 이동시키기
// 4. 배열에 크기를 넘어가면 다시 처음으로 돌아가도록 설계하기 (현재 위치 % 배열에 크기)