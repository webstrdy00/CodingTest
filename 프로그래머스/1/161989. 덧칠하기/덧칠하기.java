class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int current = 0;
        for(int i = 0; i < section.length; ++i){
            if(section[i] > current){
                current = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}
// 룰러 길이가 m, 벽 길이가 n, 칠해야 하는 부분이 section
// 그러면은 section 제일 낮은 숫자부터 m만큼 칠하고 그 안에 section안에 숫자가 포함이 되어 있으면 없애고 answer를 1더하면 될듯
// 