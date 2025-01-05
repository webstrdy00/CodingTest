class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] daysMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int totalDays = 0;
        for(int i = 1; i<a;i++){
            totalDays += daysMonth[i];
        }
        totalDays += b - 1;
        answer = daysWeek[(totalDays+5) % 7];
        return answer;
    }
}
// 해시맵으로 일단 요일이름과 문자열을 매칭시키기
// 