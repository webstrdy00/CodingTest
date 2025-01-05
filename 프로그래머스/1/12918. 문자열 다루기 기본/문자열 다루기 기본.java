class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        String[] arr = s.split("");
        
        if(arr.length != 4 && arr.length != 6)
            return false;
        
        for(String str : arr){
            try{
                Integer.parseInt(str);
            }catch(NumberFormatException e){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}