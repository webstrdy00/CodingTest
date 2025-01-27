class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = gcdOfArray(arrayA);    // a의 최대 공약수 결과
        int gcdB = gcdOfArray(arrayB);    // b의 최대 공약수 결과
        
        if(isNotDiv(gcdA, arrayB)){   // gcdA가 arrayB의 숫자를 하나도 나눌 수 없는 경우
            answer = Math.max(answer, gcdA);
        }
        
        if(isNotDiv(gcdB, arrayA)){   // gcdB가 arrayA의 숫자를 하나도 나눌 수 없는 경우
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    private boolean isNotDiv(int gcd, int[] array){   
        for(int num : array){
            if(num % gcd == 0){
                return false;    // 나눌 수 있으면 false
            }
        }
        return true;   // 나눌 수 없으면 true
    }
    private int gcdOfArray(int[] array){  // 배열에 최대 공약수 계산
        int result = array[0];
        for(int num : array){
            result = gcd(result, num);
            if(result == 1){   // 최대 공약수가 1이면 더 계산할 필요가 없음
                break;   
            }
        }
        return result;
    }
    private int gcd(int a, int b){    // 두 정수에 공약수 계산
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}