import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strNum = new String[numbers.length];
        for(int i = 0; i < numbers.length; ++i){  // 숫자 배열을 문자열 배열로 변환
            String str = String.valueOf(numbers[i]);
            strNum[i] = str;
        }
        
        Arrays.sort(strNum, (a,b) -> (b + a).compareTo(a + b)); // 정렬 기준 정의
        
        if(strNum[0].equals("0")){  // 모든 원소가 0일떄 처리
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : strNum){  // 정렬된 배열을 붙여서 결과를 생성
            sb.append(str);
        }
        
        return sb.toString();
    }
}
// x.compareTo(y) -> x > y : 양수 반환, x < y : 음수 반환 x == y : 0 반환
// (b + a).compareTo(a + b) -> 내림차순 정렬, (a + b).compareTo(b + a) -> 오름차순 정렬