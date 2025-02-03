import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>(); 
        Stack<String[]> stack = new Stack<>();   // 남은 과제를 넣은 스택 {과제명, 남은 시간}
        
        Arrays.sort(plans, (a, b) -> toMin(a[1]) - toMin(b[1]));  // 과제 시작 시간 기준으로 오름차순 정렬
        
        int current = 0; // 현재 시간
        
        for(int i = 0; i < plans.length; ++i){
            String name = plans[i][0]; // 과제 이름
            int start = toMin(plans[i][1]); // 시작 시간
            int min = Integer.valueOf(plans[i][2]); // 소요 시간
            
            while(!stack.isEmpty()){  // 이전 과제와 현재 과제 사이에 여유 시간 확인
                String[] prev = stack.peek(); 
                int remain = Integer.valueOf(prev[1]); // 남아 있는 시간
                
                if(start >= current + remain){
                    stack.pop();
                    current += remain;   // 시간 업데이트
                    answer.add(prev[0]);  // 왼료 과제 리스트에 저장
                }else{
                    prev[1] = String.valueOf(remain - (start - current));
                    break;
                }
            }
            
            current = start;
            int end = start + min;   // 끝나는 시간
            
            if(i + 1 < plans.length){  // 다음 과제 시간 확인
                int nextStart = toMin(plans[i + 1][1]);  // 다음 과제 시작 시간
                
                if(end <= nextStart){   // 다음 과제 시작 전에 완료 할떄
                    answer.add(name);
                    current = end;
                }else{    // 다음 과제 시작 전에 완료 못할시
                    stack.push(new String[]{name, String.valueOf(end - nextStart)});
                    current = nextStart;  // 다음 과제 시간으로 업데이트
                }
            }else{
                answer.add(name);
                current = end;
            }
        }
        
        while(!stack.isEmpty()){  // 남아 있는 과제 처리하기
            answer.add(stack.pop()[0]);
        }
        
        return answer.toArray(new String[0]);   // new String[0] == new String[answer.size()]
    }
    private int toMin(String time){
        String[] parts = time.split(":");
        return Integer.valueOf(parts[0]) * 60 + Integer.valueOf(parts[1]);
    }
}
// 멈춘 과제 넣기 = Stack