class Solution {
    private int[] discounts = {10, 20, 30, 40}; // 가능한 할인율
    private int maxSub = 0; // 최대 가입자 수
    private int maxSales = 0; // 최대 매출액
    
    public int[] solution(int[][] users, int[] emoticons) {
        int size = emoticons.length;
        int[] rates = new int[size];
        
        dfs(0, users, emoticons, rates); // dfs로 할인율 조합 탐색
        
        return new int[]{maxSub, maxSales};
    }
    private void dfs(int d, int[][] users, int[] emoticons, int[] rates){
        if(d == emoticons.length){ // 모든 이모티콘에 할인율을 정한 경우
            value(users, emoticons, rates); // 가입자수와 매출 계산
            return;
        }
        
        for(int dis : discounts){   // 각 이모티콘에 할인율 적용
            rates[d] = dis;
            dfs(d + 1, users, emoticons, rates);
        }
    }
    private void value(int[][] users, int[] emoticons, int[] rates){    
        int subCount = 0;
        int total = 0;
        
        for(int[] user : users){
            int minDis = user[0];   // 사용자가 원하는 최소 할인율
            int maxPrice = user[1]; // 이모티콘을 살 최대 예산
            int userPrice = 0;  // 소비한 예산
            
            for(int i = 0; i < emoticons.length; ++i){
                if(rates[i] >= minDis){ // 사용자가 원하는 할인율보다 높을떄
                    userPrice += emoticons[i] * (100 - rates[i]) / 100;
                }
            }
            
            if(userPrice >= maxPrice){  // 예산을 넘어가면 플러스 가입
                subCount++;
            }else{      // 아니면 구매 금액만 매출액으로 추가
                total += userPrice;
            }
        }
        
        // 더 많은 가입자가 생기거나 가입자가 같은데 매출액이 더 클 경우 갱신
        if(subCount > maxSub || 
          subCount == maxSub && total > maxSales){
            maxSub = subCount;
            maxSales = total;
        }
    }
}