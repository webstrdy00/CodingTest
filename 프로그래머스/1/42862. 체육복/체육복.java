import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        for(int i : lost){
            lostList.add(i);
        }
        for(int r : reserve){
            reserveList.add(r);
        }
        
        ArrayList<Integer> toRemove = new ArrayList<>();
        for(int l : lostList){
            if(reserveList.contains(l)){
                toRemove.add(l);
            }
        }
        
        lostList.removeAll(toRemove);
        reserveList.removeAll(toRemove);
        
        for(int i = 0; i < lostList.size(); i++){
            int student = lostList.get(i);
            if(reserveList.contains(student -1)){
                reserveList.remove((Integer) (student - 1));
                lostList.set(i, -1);
            }else if(reserveList.contains(student + 1)){
                reserveList.remove((Integer) (student + 1));
                lostList.set(i, -1);
            }
        }
        
        int num = 0;
        for(int j : lostList){
            if(j != -1){
                num++;
            }
        }
        
        return answer - num;
    }
}
// 잃어버린 학생에 앞뒤 번호에 학생만 체육복을 빌려줄 수 있음
// lost가 읽어버린 학생 번호, reserve가 여벌 체육복을 가져온 학생 번호, n이 총 학생수
// 1. 잃어버린 번호에 학생에 앞뒤번호에 학생이 여벌에 체육복을 가져 왔는지 확인
// 2. 가져왔으면 빌려서 lost에서 삭제하고 빌려준 번호도 reserve에서 삭제
// 3. 총 학생수 n에서 lost에 남은 학생 수를 빼서 return하기