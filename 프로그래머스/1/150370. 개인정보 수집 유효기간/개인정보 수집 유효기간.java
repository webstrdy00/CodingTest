import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayNum = num(today);
        HashMap<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] parts = term.split(" ");
            String termType = parts[0];
            int month = Integer.parseInt(parts[1]);
            termMap.put(termType, month);
        }
        
        List<Integer> expiredList = new ArrayList<>();
        for(int i = 0; i < privacies.length; ++i){
            String[] parts = privacies[i].split(" ");
            int collecteDate = num(parts[0]);
            String termType = parts[1];
            
            int expirateDate = collecteDate + (termMap.get(termType) * 28);
            
            if(expirateDate <= todayNum){
                expiredList.add(i + 1);
            }
        }
        
        return expiredList.stream().mapToInt(Integer::intValue).toArray();
    }
    private int num(String day){
        String[] parts = day.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int days = Integer.parseInt(parts[2]);
        int today = (year * 12 * 28) + (month * 28) + days;
        return today;
    }
}
// 문자열 날짜를 어떻게 비교할건지가 관건
// 