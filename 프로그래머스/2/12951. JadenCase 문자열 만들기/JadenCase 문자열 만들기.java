class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        
        boolean flag = true;
        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                flag = true;
                answer.append(ch);
                continue;
            }
            
            if(flag){
                if('0' <= ch && ch <= '9')
                    answer.append(ch);
                else answer.append((char)(ch - 32));
                flag = false;
                continue;
            }
            answer.append(ch);
        }
        
        return answer.toString();
    }
}