class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int numRows = arr1.length;
        int numCols = arr1[0].length;
        int[][] answer = new int[numRows][numCols];
        
        for(int i = 0;i<numRows;i++){
            for(int j = 0;j<numCols;j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}