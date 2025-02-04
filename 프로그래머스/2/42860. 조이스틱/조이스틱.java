class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        for(char c : name.toCharArray()){  // 알파벳 변경 최소횟수 구하기
            answer += Math.min(c - 'A', 'Z' - c + 1);   // 위로 이동시키거나 아래로 이동시키는 방법중 빠른 방법 구해서 더하기
        }
        
        int minMove = length - 1;
        
        for(int i = 0; i < length; ++i){   // 최소 이동거리 구하기
            int next = i + 1;
            while(next < length && name.charAt(next) == 'A'){    // 연속된 A 스킵하기
                next++;     
            }
            
            minMove = Math.min(minMove, i + (length - next) + Math.min(i, length - next));  // 최소 이동 거리 갱신
        }
        
        return answer + minMove;
    }
}