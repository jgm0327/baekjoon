import java.util.ArrayDeque;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = recur(p);
        return answer;
    }
    
    private String recur(String s){
        int left=0, right=0, idx=0;
        StringBuilder u = new StringBuilder();
        if(s.length() == 0)return "";
        
        // u 문자열 만들기
        while(idx < s.length()){
            char ch = s.charAt(idx++);
            if(ch == '(')left++;
            else if(ch == ')')right++;
            u.append(ch);
            if(left == right)break;
        }
        
        // v 문자열 만들기
        StringBuilder v = new StringBuilder();
        for(int i=idx ; i<s.length() ; i++){
            v.append(s.charAt(i));
        }
        
        // 올바른 문자가 아닐 시 첫, 끝 문자 삭제 후 뒤집기
        if(!checkRight(u.toString())){
            StringBuilder str = new StringBuilder();
            str.append('(');
            str.append(recur(v.toString()).toString());
            str.append(')');
            
            System.out.println(str);
            u.deleteCharAt(u.length() - 1);
            u.deleteCharAt(0);
            u = reverse(u);
            return str.append(u.toString()).toString();
        }
        return u.append(recur(v.toString())).toString();
    }
    
    private StringBuilder reverse(StringBuilder s){
        for(int i=0 ; i<s.length() ; i++){
            char ch = '(';
            if(s.charAt(i) == '(')ch = ')';
            s.setCharAt(i, ch);
        }
        return s;
    }
    
    private boolean checkRight(String s){
        ArrayDeque<Character> stack = new ArrayDeque();
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() && ch == ')')return false;
            if(ch == '(')stack.addLast(ch);
            if(!stack.isEmpty() && ch == ')' 
               && stack.getLast() == '(')stack.pollLast();
        }
        return stack.isEmpty();
    }
}