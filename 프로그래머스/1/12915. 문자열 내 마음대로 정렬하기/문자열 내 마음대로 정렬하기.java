import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.stream(strings)
            .sorted((s1, s2) -> {
                char c1 = s1.charAt(n);
                char c2 = s2.charAt(n);
                
                if(c1 == c2){
                    return s1.compareTo(s2);
                }
                return Character.compare(c1, c2);
            }).toArray(String[]::new);
        
        return answer;
    }
}

// 정렬하는 방식에 문제
// n번째 글자를 기준으로 오른차순으로 정렬, 각 인덱스에 N번쨰 문자 뽑아서 비교하고 오른차순으로 다시 인덱스 구성하면 됨