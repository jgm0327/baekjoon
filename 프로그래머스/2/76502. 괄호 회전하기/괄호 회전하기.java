import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder str = new StringBuilder(s);
        int answer = 0;
        for(int i=0 ; i<str.length() ; i++){
            if(check(str.toString())){
                answer++;
            }
            char ch = str.charAt(0);
            str.deleteCharAt(0);
            str.append(ch);
        }
        return answer;
    }
    
    static boolean check(String str){
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(int i=0 ; i<str.length(); i++){
            char ch = str.charAt(i);
            if(stk.isEmpty() || ch == '(' || ch == '{' || ch == '[')
                stk.add(ch);
            else if(ch == ']' && stk.peekLast() == '[')
                stk.pollLast();
            else if(ch == '}' && stk.peekLast() == '{')
                stk.pollLast();
            else if(ch == ')' && stk.peekLast() == '(')
                stk.pollLast();
            else
                return false;
        }
        
        return stk.isEmpty();
    }
}