import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> winSet = new HashSet<>();
        for(int num : win_nums){
            winSet.add(num);
        }
        
        int zeroCount = 0;
        int matchCount = 0;
        for(int num : lottos){
            if(num == 0){
                zeroCount++;
            }else if(winSet.contains(num)){
                matchCount++;
            }
        }
        
        int maxRank = getRank(zeroCount + matchCount);
        int minRank = getRank(matchCount);
        
        int[] answer = {maxRank, minRank};
        return answer;
    }
    private int getRank(int count){
        switch(count){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
}
// 0으로 되어있는 부분이 지워진 부분,
// 그러면 일단 배열을 보고 이미 일치한 번호 갯수를 더해서 구하고 0으로 되어 있는 부분으로 최대한 맞출 수 있는 방법이랑 못 맞추는 방법을 구하면 됨
// 그러면 최고는 0으로 되어 있는 부분이 남아 있는 숫자들이랑 다 일치하는 거고 == 최고는 이미 일치한 번호 갯수 + 0의 갯수
// 최저는 0으로 되어 있는 부분이 남아 있는 숫자들이랑 다 안맞는 거 == 결론은 최저는 이미 일치한 번호 갯수 결과