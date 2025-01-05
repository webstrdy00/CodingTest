import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        for(int i = 0; i < wallpaper.length; ++i){
            for(int j = 0; j < wallpaper[i].length(); ++j){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}
// [제일 왼쪽 파일, 제일 위에 파일, 제일 오른쪽 파일 + 1, 제일 아래 파일 + 1]