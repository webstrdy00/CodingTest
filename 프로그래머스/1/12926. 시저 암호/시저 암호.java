class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] sArr = new char[s.length()];
        sArr = s.toCharArray();
        for(char c : sArr){
            if(c == ' '){
                answer += " ";
            }else if(c >= 'A' && c <= 'Z'){
                char shifed = (char)(c+n);
                if(shifed > 'Z'){
                    shifed = (char) (c-26+n);
                }
                answer += shifed;
            }
            else if(c >= 'a' && c <= 'z'){
                char shifed = (char) (c+n);
                if(shifed > 'z'){
                    shifed = (char) ( c-26+n);
                }
                answer += shifed;
            }
                
        }
        
        return answer;
    }
}

// 대문자 65~90, 소문자 97 ~ 122
// 90 - 65 = 25