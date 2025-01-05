import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerList = new HashMap<>();
        for(int i = 0; i < players.length; ++i){
            playerList.put(players[i], i);
        }
        for(String name : callings){
            int current = playerList.get(name);
            if(current > 0){
                String frontName = players[current - 1];
                players[current - 1] = name;
                players[current] = frontName;
                
                playerList.put(name, current - 1);
                playerList.put(frontName, current);
            }
        }
        return players;
    }
}
// 추월한 선수 이름을 부름 -> 그 사람 등수가 한 단계 상승
// 배열에 