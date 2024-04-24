class Solution {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        
        for(int i=0 ; i<code.length() ; i++){
            char ch = code.charAt(i);
            
            if(ch == '1'){
                mode = 1 - mode;
                continue;
            }
            
            if(mode == 1 && i % 2 == 1){
                answer.append(ch);
            }else if(mode == 0 && i % 2 == 0){
                answer.append(ch);
            }
        }
        
        return answer.length() > 0 ? answer.toString() : "EMPTY";
    }
}