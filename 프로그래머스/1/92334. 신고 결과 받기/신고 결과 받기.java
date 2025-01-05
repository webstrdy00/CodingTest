import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> newReport = new HashSet<>();
        for(String s : report){   // report에 중복된 신고 제거
            newReport.add(s);
        }
        
        HashMap<String, Integer> count = new HashMap<>();
        for(String s : newReport){  // 각 id에 신고 횟수 증가
            String[] parts = s.split(" ");
            String id = parts[1];
            
            count.put(id, count.getOrDefault(id, 0) + 1);
        }
        
        Set<String> stopUser = new HashSet<>();
        for(Map.Entry<String, Integer> entry : count.entrySet()){  // 정지된 유저 결정
            if(entry.getValue() >= k){
                stopUser.add(entry.getKey());
            }
        }
        
        Map<String, Set<String>> userReport = new HashMap<>();
        for(String s : newReport){
            String[] parts = s.split(" ");
            String user1 = parts[0]; // 신고자
            String user2 = parts[1]; // 신고받은 유저
            
            userReport.putIfAbsent(user1, new HashSet<>());
            userReport.get(user1).add(user2);
        }
        
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; ++i){
            String user = id_list[i];
            Set<String> reports = userReport.getOrDefault(user, new HashSet<>());
            
            for(String reportUser : reports){
                if(stopUser.contains(reportUser)){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
// HashMap으로 각각 id에 신고 횟수를 넣고
// 