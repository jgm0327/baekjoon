class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if(">".equals(ineq)){
            if("=".equals(eq)){
                if(n >= m)answer = 1;
                else answer = 0;
            }else{
                if(n > m)answer = 1;
                else answer = 0;
            }
        }
        else{
            if("=".equals(eq)){
                if(n <= m)answer = 1;
                else answer = 0;
            }else{
                if(n < m)answer = 1;
                else answer = 0;
            }
        }
        return answer;
    }
}