import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());  // 입력 처리
        
        int result = findPalindromeaPrime(n);  // 문제 풀이
        
        System.out.println(result);  // 결과 출력
    }
    private static int findPalindromeaPrime(int n){
        while(true){  
            if(isPrime(n) && isPalindrome(n)){   // 소수이거나 팰린드롬 숫자가 만족하는지 판단
                return n;
            }
            n++;
        }
    }
    private static boolean isPrime(int n){  // 소수 찾기
        if(n < 2){
            return false;
        }
        for(int i = 2; i * i <= n; ++i){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    private static boolean isPalindrome(int n){ // 팰린드롬 숫자 찾기
        String str = String.valueOf(n);
        int len = str.length();
        for(int i = 0; i < len; ++i){
            if(str.charAt(i) != str.charAt(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
}