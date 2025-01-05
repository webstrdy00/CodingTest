import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> numberMap = new HashMap<>();
        numberMap.put("zero", "0");
        numberMap.put("one", "1");
        numberMap.put("two", "2");
        numberMap.put("three", "3");
        numberMap.put("four", "4");
        numberMap.put("five", "5");
        numberMap.put("six", "6");
        numberMap.put("seven", "7");
        numberMap.put("eight", "8");
        numberMap.put("nine", "9");
        
        for(String word : numberMap.keySet()){
            s = s.replaceAll(word, numberMap.get(word));
        }
        
        return Integer.parseInt(s);
    }
}

// 숫자 -> 숫자, 문자열 -> 숫자
// 문자열을 어떻게 판단해서 숫자로 변경하는지가 관건
// for문으로 숫자는 그냥 패스 시키면 되는거고 문자열은 그러면 저 영단어랑 일치하는 문장이 있는지 판단이 가능한가?
// 가능하면 문자열 s에서 저 대응되는 영단어를 찾아서 그것을 숫자를 변경시키고 새로운 문자열에 저장하고 기존 문자열에서 제거하는 방식으로 진행하면 될듯