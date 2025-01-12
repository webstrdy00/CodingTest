class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];  // [arr1에 열 갯수][arr2에 행 갯수]
        
        // 행렬 곱겜 수행 (3중 for문)
        for(int i = 0; i < arr1.length; ++i){ // 결과 행렬의 행
            for(int j = 0; j < arr2[0].length; ++j){ // 결과 행렬의 열
                for(int k = 0; k < arr1[0].length; ++k){  // 공통된 부분 순회
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
            
        }
        return answer;
    }
}
// 행렬 곱셈 = arr1 열 개수와 arr2 행 개수가 같아야함
// 결과 행렬의 크기 = [arr1 열 갯수][arr2 행 갯수]