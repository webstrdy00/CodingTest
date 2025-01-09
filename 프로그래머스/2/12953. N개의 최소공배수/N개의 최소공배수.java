class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; ++i){
            // 최대공약수 계산
            int a = answer;   
            int b = arr[i];   
            while(b != 0){
                int temp = b;  
                b = a % b;  
                a = temp; 
            }
            int gcp = a; // 최대 공약수
            
            answer = (answer * arr[i]) / gcp; // 최소 공배수 계산
        }
        return answer;
    }
}