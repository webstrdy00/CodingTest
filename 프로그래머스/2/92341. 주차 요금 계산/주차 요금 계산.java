import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> inTimeMap = new HashMap<>(); // 차량의 입차 기록을 저장하기 위함
        HashMap<String, Integer> recordMap = new HashMap<>(); // 차량의 주차 시간 기록 저장하기 위함
        
        for(int i = 0; i < records.length; ++i){
            String[] parts = records[i].split(" "); // 공백을 기준으로 문자열 분해
            int min = timeToMin(parts[0]);  // 시간을 분으로 변환
            
            if(parts[2].equals("IN")){
                inTimeMap.put(parts[1], min); // 들어온 시간 계산
            }else{
                int inTime = inTimeMap.remove(parts[1]); // 들어온 시간 가져오기
                int parkedTime = min - inTime; // 주차 시간 계산
                recordMap.put(parts[1], recordMap.getOrDefault(parts[1], 0) + parkedTime);
            }
        }
        
        int closeTime = timeToMin("23:59");
        for(String num : inTimeMap.keySet()){   // 23:59 출차를 시키기 위한 과정
            int inTime = inTimeMap.get(num);
            int parkedTime = closeTime - inTime; 
            recordMap.put(num, recordMap.getOrDefault(num, 0) + parkedTime);
        }
        
        List<String> carNum = new ArrayList<>(recordMap.keySet());  // 차 번호로 정렬하기 위해서 생성
        Collections.sort(carNum);
        
        int[] answer = new int[carNum.size()];
        for(int i = 0; i < carNum.size(); ++i){  // 요금 계산
            String num = carNum.get(i);
            int totalMin = recordMap.get(num);
            answer[i] = parkFees(fees, totalMin);
        }
        
        return answer;
    }
    private int timeToMin(String time){
        String[] parts = time.split(":"); // 시/분 으로 분해
        int hours = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hours * 60 + min;
    }
    private int parkFees(int[] fees, int min){
        int basicMin = fees[0];
        int basicMoney = fees[1];
        int plusMin = fees[2];
        int plusMoney = fees[3];
        
        if(min <= basicMin){ // 기본 시간보다 적을 떄
            return basicMoney;  
        }else{
            int newMin = min - basicMin; // 추가된 시간
            int newMoney = (int) Math.ceil((double) newMin/plusMin) * plusMoney; // 추가된 시간만큼 요금 계산
            return basicMoney + newMoney;
        }
    }
}
// fees[0] = 기본 시간, fees[1] = 기본 요금, fees[2] = 단위 시간, fees[3] = 단위 요금