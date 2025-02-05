class Solution {
    public int solution(String[] board) {
        int oCount = 0, xCount = 0;
        
        for(String r : board){   // O 갯수와 X 갯수 세기
            for(char c : r.toCharArray()){
                if(c == 'O'){
                    oCount++;
                }else if(c == 'X'){
                    xCount++;
                }
            }
        }
        
        if(xCount > oCount || oCount - xCount > 1){  // x가 더 많거나 o를 여러번 놨을 경우
            return 0;
        }
        
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        
        if(oWin && xWin){  // o와 x가 동시에 승리하는것은 불가능
            return 0;
        }
        if(oWin && oCount == xCount){   // o가 승리했는데 o와x 갯수가 같은것은 불가능
            return 0;
        }
        if(xWin && oCount > xCount){   // x가 승리했는데 o가 x 갯수보다 많은것은 불가능
            return 0;
        }
        
        return 1;
    }
    private boolean isWin(String[] board, char c){
        for(int i = 0; i < 3; ++i){   // 가로, 세로 검사
            if(board[i].charAt(0) == c & board[i].charAt(1) == c && board[i].charAt(2) == c){
                return true;
            }
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c){
                return true;
            }
        }
        
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c){  // 대각선 검사
            return true;
        }
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c){
            return true;
        }
        
        return false;
    }
}