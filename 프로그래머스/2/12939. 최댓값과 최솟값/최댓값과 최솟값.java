class Solution {
    public String solution(String s) {
        int size = s.length();
        String[] arr = new String[size];
        arr = s.split(" ");
        
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
        for(String num : arr){
            int number = Integer.parseInt(num);
            
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        String answer = min + " " + max;
        return answer;
    }
}
// 