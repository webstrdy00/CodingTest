class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        for(int i = 1; i <= n/2; ++i){
            answer++;
            a = (a/2) + (a%2);
            b = (b/2) + (b%2);
            if(a == b){
                break;
            }
        }

        return answer;
    }
}
// n/2 = 최대 경기 수, (a/2)+(a%2) == (b/2)+(b%2)