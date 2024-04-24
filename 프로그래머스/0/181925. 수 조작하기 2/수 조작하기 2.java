class Solution {
    public String solution(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        for(int i=1 ; i<numLog.length ; i++){
            char ch = 'w';
            
            if(numLog[i] == numLog[i - 1] - 1)
                ch = 's';
            else if(numLog[i] == numLog[i - 1] + 10)
                ch = 'd';
            else if(numLog[i] == numLog[i - 1] - 10)
                ch = 'a';
            
            answer.append(ch);
        }
        
        return answer.toString();
    }
}