import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> arr = new ArrayList<>();  // 우박 수열을 저장하기위한 배열
        arr.add(k);
        
        while(k > 1){  // 우박 수열 과정
            if(k % 2 ==0){
                k /= 2;
            }else{
                k = k * 3 + 1;
            }
            arr.add(k);
        }
        
        int n = arr.size() - 1;
        double[] areas = new double[n]; // 사다리꼴 면적 저장 배열
        
        for(int i = 0; i < n; ++i){   // 사다리꼴 면적 계산
            areas[i] = (arr.get(i) + arr.get(i + 1)) / 2.0; 
        }
        
        double[] answer = new double[ranges.length];  // ranges 계산 결과 배열 생성
        
        for(int i = 0; i < ranges.length; ++i){   // ranges 계산
            int a = ranges[i][0];
            int b = ranges[i][1];
            
            int end = n + b;   // 음수 b 처리
            
            if(a > end){   // 잘못된 영역
                answer[i] = -1.0;
            }else{
                double num = 0.0;
                for(int j = a; j < end; ++j){   // 각 영역에 넓이 더하기
                    num += areas[j];
                }
                answer[i] = num;
            }
        }
        
        return answer;
    }
}