import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; ++i){
            times[i][0] = timeToMin(book_time[i][0]);
            times[i][1] = timeToMin(book_time[i][1]);
        }
        
        Arrays.sort(times, (a , b) -> a[0] - b[0]); // 시작 시간을 기준으로 정렬
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐(최소 힙) 생성 : 종료 시간을 기준으로 관리
        
        for(int[] time : times){
            if(!pq.isEmpty() && pq.peek() + 10 <= time[0]){
                pq.poll(); // 현재 객실 재사용
            }
            pq.offer(time[1]); // 새로운 종료 시간 추가
        }
        
        return pq.size();
    }
    private int timeToMin(String time){
        String[] parts = time.split(":");
        int hours = Integer.valueOf(parts[0]);
        int min = Integer.valueOf(parts[1]);
        return hours * 60 + min;
    }
}