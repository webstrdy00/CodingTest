class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numResult = new int[number];
        for(int i = 1; i <= number; ++i){
            for(int j = 1; j <= Math.sqrt(i); ++j){
                if(i % j == 0){
                    numResult[i - 1] += 1;
                    if(j != i / j){
                        numResult[i - 1] += 1;
                    }
                }
            }
        }
        for(int i = 0; i < numResult.length; ++i){
            if(numResult[i] > limit){
                numResult[i] = power;
            }
            answer += numResult[i];
        }
        return answer;
    }
}
// 무기 공격력 1당 철 1KG 필요
// 기사단원 수에 각 숫자에 약수 갯수를 구해서 limit를 넘지 않으면 그냥 사용하게 하고 넘으면 power에 검을 사용하게 함
// 그러면 일단 number에 숫자를 보고 각 약수에 개수를 구하는 배열을 만드는 과정
// 약수 갯수를 보고 limit이랑 비교해서 넘는지 넘지 않는지 판단해서 각각에 공격력 검을 나타내는 배열만드는 과정
// 그리고 배열에 모든 값을 더해서 return하는 과정