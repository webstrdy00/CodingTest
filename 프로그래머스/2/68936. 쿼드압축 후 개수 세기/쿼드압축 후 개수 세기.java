class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // [0의 갯수, 1의 갯수]
        
        compress(arr, 0, 0, arr.length, answer);    // 재귀적으로 압축 실행
        
        return answer;
    }
    private void compress(int[][] arr, int startX, int startY, int size, int[] answer){   // 압축 진행 함수
        if(isCompressible(arr, startX, startY, size)){    // 현재 영역이 압축 가능한지 확인
            int value = arr[startX][startY];   // 해당 영역의 값
            answer[value]++;  // 0 또는 1의 갯수 증가
            return;
        }
        
        int newSize = size / 2; // 압축 불가능하던 영역을 4개로 분할
        
        compress(arr, startX, startY, newSize, answer);  // 좌상단
        compress(arr, startX, startY + newSize, newSize, answer); // 우상단
        compress(arr, startX + newSize, startY, newSize, answer); // 좌하단
        compress(arr, startX + newSize, startY + newSize, newSize, answer); // 우하단
    }
    private boolean isCompressible(int[][] arr, int startX, int startY, int size){   // 해당 영역이 압축 가능한지 판단하는 함수
        int value = arr[startX][startY]; // 첫 번째 값
        for(int i = startX; i < startX + size; ++i){
            for(int j = startY; j < startY + size; ++j){
                if(arr[i][j] != value){
                    return false;  // 다른 값이 있으면 압축 불가능
                }
            }
        }
        return true;  // 모든 값이 같으면 압축 가능
    }
}