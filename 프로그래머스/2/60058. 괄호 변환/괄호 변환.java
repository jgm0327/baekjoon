import java.util.*;

class Solution {
    public String solution(String p) {
        if(isCorrect(p))
            return p;
        
        return dfs(new StringBuilder(p)).toString();
    }
    
    private StringBuilder dfs(StringBuilder u){
        if(u.length() == 0)
            return new StringBuilder("");
        
        int o = 0, c = 0, idx = 0;
        while(idx < u.length()){
            if(u.charAt(idx) == '(')
                o++;
            else
                c++;
            
            idx++;
            if(o == c){
                break;
            }
        }
        
        StringBuilder nU = new StringBuilder(u.substring(0, idx));
        StringBuilder nV = new StringBuilder(u.substring(idx));
        
        if(isCorrect(nU.toString())){
            return nU.append(dfs(nV));
        }
        
        StringBuilder ret = new StringBuilder();
        ret.append("(").append(dfs(nV)).append(")");
        nU.deleteCharAt(0);
        nU.deleteCharAt(nU.length() - 1);
        reverse(nU);
        return ret.append(nU);
    }
    
    private void reverse(StringBuilder p){
        for(int i=0 ; i<p.length() ; i++){
            char ch = p.charAt(i);
            if(ch == '(')
                ch = ')';
            else
                ch = '(';
            p.setCharAt(i, ch);
        }
    }
    
    private boolean isCorrect(String p){
        ArrayDeque<Character> stk = new ArrayDeque<>();
        
        for(int i=0 ; i<p.length() ; i++){
            if(p.charAt(i) == '(')
                stk.add('(');
            
            else{
                if(stk.isEmpty())
                    return false;
                
                stk.pollLast();
            }
        }
        
        return stk.isEmpty();
    }
}