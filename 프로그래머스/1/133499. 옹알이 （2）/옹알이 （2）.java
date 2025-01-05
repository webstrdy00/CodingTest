class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = {"aya", "ye", "woo", "ma"};
        for(String word : babbling){
            boolean isVaild = true;
            String original = word;
            
            for(String s : str){
                word = word.replace(s, " ");
            }
            
            if(!word.trim().isEmpty()){
                isVaild = false;
            }
            
            for(String vaild : str){
                if(original.contains(vaild + vaild)){
                    isVaild = false;
                    break;
                }
            }
            
            if(isVaild){
                answer++;
            }
        }
        return answer;
    }
}