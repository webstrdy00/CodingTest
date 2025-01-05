class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = 0;
        char[] charArr = new char[s.length()];
        for(char c : s.toCharArray()){
            charArr[size++] = c;
        }
        int a = 0;
        int b = 0;
        char x = ' ';
        for(int i = 0; i < charArr.length; ++i){
            if(a == 0 && b == 0){
                x = charArr[i];
                a++;
                continue;
            }
            
            if(x == charArr[i]){
                a++;
            }else if(x != charArr[i]){
                b++;
            }
            
            if(a == b){
                answer++;
                a = 0;
                b = 0;
            }
        }
        
        if(a != 0 || b != 0){
            answer++;
        }
        
        return answer;
    }
}
// 문자열을 각각 문자로 분해해서 하나씩 비교하면서 돌아가면 될듯
// 1. 문자열을 분해해서 배열로 만들기
// 2. a = 1, b = 0으로 만들고 첫번째 글자를 x로 지정
// 3. x가 아닌 문자가 나오면 b에 1를 더하고 x인 문자가 나오면 a에 1 더하기
// 4. a와 b가 같아지면 answer에 1를 더하고 a = 1, b = 0으로 초기화하고 x를 다음 글자로 지정하기
// 5. 문자열이 끝나면 1더하기