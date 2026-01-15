import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        
        for(int start=0 ; start < n ; start++){
            ArrayDeque<Character> stk = new ArrayDeque<>();
            boolean flag = true;
            
            for(int i=start ; i<start + n ; i++){
                char ch = s.charAt(i % n);
                
                if(stk.isEmpty() || ch == '(' || ch == '{' || ch == '[' )
                    stk.add(ch);
                else if(ch == ')' && stk.peekLast() == '(')
                    stk.pollLast();
                else if(ch == '}' && stk.peekLast() == '{')
                    stk.pollLast();
                else if(ch == ']' && stk.peekLast() == '[')
                    stk.pollLast();
                else{
                    flag = false;
                    break;
                }
            }
            
            if(flag && stk.isEmpty())answer++;
        }
        return answer;
    }
}