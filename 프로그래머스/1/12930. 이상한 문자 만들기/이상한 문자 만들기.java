class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] strArr = s.split(" ",-1);
        
        for(int i = 0;i<strArr.length;i++){
            StringBuilder word = new StringBuilder();
            
            for(int j = 0;j<strArr[i].length();j++){
                if(j%2 == 0)
                    word.append(Character.toUpperCase(strArr[i].charAt(j)));
                else
                    word.append(Character.toLowerCase(strArr[i].charAt(j)));
            }
            
            answer.append(word);
            if(i < strArr.length -1)
                answer.append(" ");
        }
        
        return answer.toString();
    }
}